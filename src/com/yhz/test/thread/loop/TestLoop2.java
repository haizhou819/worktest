package com.yhz.test.thread.loop;
/**
 * 子线程循环10次，然后主线程循环20次，如此循环30次。子循环执行时主循环不能执行，主循环执行时子循环也不能执行。
 * @author sunny
 *
 */
public class TestLoop2 {
	final static Loop2 loop = new Loop2();
	public static void executeLoop(Loop2 loop,String flag){
		for(int i=0;i<30;i++){
			if("main".equals(flag)){
				loop.mainLoop(i);
			}else{
				loop.subLoop(i);
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				executeLoop(loop, "sub");
			}
		}).start();
		
		executeLoop(loop,"main");
	}
}

class Loop2{
	private boolean isSubLoop = true;
	public synchronized void mainLoop(int loopNo){
		while(isSubLoop){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<20;i++){
			System.out.println("main loop"+"---"+i+"外循环"+loopNo);
		}
		isSubLoop = true;
		notify();
	}
	public synchronized void subLoop(int loopNo){
		while(!isSubLoop){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<10;i++){
			System.out.println("sub loop"+"-----"+i+"外循环"+loopNo);
		}
		isSubLoop = false;
		notify();
	}
}




