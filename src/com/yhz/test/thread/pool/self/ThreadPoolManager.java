package com.yhz.test.thread.pool.self;

import java.util.LinkedList;
import java.util.List;
/**
 * 线程池管理类
 * @author sunny
 *
 */
public class ThreadPoolManager extends ThreadGroup{
	 /**线程池是否开启标识*/
	int flagThreadPoolValid = 0; //1:开启线程池状态，0：关闭线程池状态
	 /**线程池中线程的数量，从系统配置类中获取*/
	int threadSize = SystemConfig.getThreadDefaultCount();
	  /**任务队列*/
	List<Task> TaskList = new LinkedList<Task>();
	
	public ThreadPoolManager(String threadpoolname){
		super(threadpoolname);
		setDaemon(true);
	}
	//开启线程池
	public synchronized void threadPoolStart(){
		if(threadSize == 0 || flagThreadPoolValid != 0){
			try{
				throw new Exception("线程池中没有可用线程！");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return;
		}
		
		if(TaskList == null){
			try{
				throw new Exception("线程池中没有可用线程！");
			}catch(Exception e){
				e.printStackTrace();
			}
			return;
		}
		// 创建并开启线程例程
		for(int i = 0;i < threadSize;i++){
			new WorkThread(i).start();
		}
		
		flagThreadPoolValid = 1;
	}
	//关闭线程池
	public synchronized void threadPoolEnd(){
		if(threadSize == 0 || flagThreadPoolValid != 1){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
			return;
		}
		if(TaskList == null){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
			return;
		}
		TaskList.clear();
		threadSize = 0;
		flagThreadPoolValid = 0;
		
		interrupt();
	}
	//向线程池管理类的任务队列中添加任务	
	public synchronized void addTask(Task newTask){
		if(TaskList == null){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
			return;
		}
		
		TaskList.add(newTask);
		//唤醒一个正在getTask()方法中等待任务的工作线程
		notify();
	}
	//获取线程池中任务队列中的任务	
	public synchronized Task getTask(){
		if(TaskList == null){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		while(TaskList.size() == 0){
			try{
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return TaskList.remove(0);
	}
	//内部类，工作线程类
	private class WorkThread extends Thread{
		public WorkThread(int threadID){
			 //父类构造方法,将线程加入到ThreadGroup中
			super(ThreadPoolManager.this,""+threadID);
		}
		
		public void run(){
			//isInterrupted()方法继承自Thread类，判断线程是否被中断
			while(!isInterrupted()){
				Task runTask = getTask();
				 //getTask()返回null或者线程执行getTask()时被中断
				if(runTask == null)
					break;
				runTask.run();
			}
		}
	}
	
}
