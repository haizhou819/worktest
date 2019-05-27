package com.yhz.test.thread.loop;

/**
 * 子线程循环10次，然后主线程循环20次，如此循环50次。子循环执行时主循环不能执行，主循环执行时子循环也不能执行。
 * @author sunny
 *
 */
public class TestLoopThread {
	public static void main(String[] args) {
		final Loop loop = new Loop();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				executeLoop(loop,"sub");
			}
		}).start();
		
		executeLoop(loop,"main");
	}
	
	public static void executeLoop(Loop loop,String loopThread){
		for(int i=0;i<50;i++){
			if("main".equals(loopThread)){
				loop.mainLoop(i);
			}else{
				loop.subLoop(i);
			}
		}
	}
}

class Loop{
	private boolean isSubLoop = true;
	
	public synchronized void mainLoop(int loopNum){
		while(isSubLoop){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i=0;i<20;i++){
			System.out.println("main thread loop"+"内循环"+i+"----外循环"+loopNum);
		}
		
		isSubLoop = true;// 主线程执行完毕，由子线程来执行 
		
		notify();// 唤醒阻塞队列中的子线程到就绪队列
	}
	
	public synchronized void subLoop(int loopNum){
		while(!isSubLoop){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i=0;i<10;i++){
			System.out.println("sub thread loop"+"内循环"+i+"----外循环"+loopNum);
		}
		
		isSubLoop = false;//  子线程执行完毕，由主线程来执行
		
		notify(); // 唤醒阻塞队列中的主线程到就绪队列
	}
}