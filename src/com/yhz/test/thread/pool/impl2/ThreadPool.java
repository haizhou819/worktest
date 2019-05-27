package com.yhz.test.thread.pool.impl2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadPool {
	
	//任务队列，存放待处理的任务
	private List<Task> taskList = Collections.synchronizedList(new ArrayList<Task>());   
	
	//取得线程管理类实例
	private static ThreadPool instance = null;
	
	private volatile int flagThreadPoolValid = 0; //0:开启线程池状态，1：关闭线程池状态
	
	//工作线程队列
	private WorkThread[] threadList ;
	
	public synchronized void startPool(){
		threadList = new WorkThread[5];
		for(int i=0;i<threadList.length;i++){
			threadList[i] = new WorkThread();
			threadList[i].start();
		}
	}
	
	public ThreadPool(){
		//this(5);
	}
	
	public ThreadPool(int num){
		threadList = new WorkThread[num];
		for(int i=0;i<threadList.length;i++){
			threadList[i] = new WorkThread();
			threadList[i].start();
		}
	}
	
	public synchronized void endPool(){
		while(flagThreadPoolValid == 0){  //当任务队列不为空时，不断循环
			while(taskList.size() == 0 && flagThreadPoolValid == 0){
				for(int i=0;i<threadList.length;i++){
					threadList[i].stopWorker();
					threadList[i] = null;
				}
				
				taskList.clear();
				flagThreadPoolValid = 1;
			}
		}
	}
	
	public static synchronized ThreadPool getIntance(){
		if(instance == null){
			instance = new ThreadPool();
		}
		return instance;
	}
	
	private Task getTask(){    //工作线程队列中的线程对象调用此方法
		synchronized(taskList){
			while(taskList.size() == 0){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Task task = taskList.remove(0);
			return task;
		}
	}
	
	public void addTask(Task newTask){   //线程池管理对象调用此方法
		synchronized(taskList){
			if(newTask != null){
				taskList.add(newTask);
				taskList.notify();
			}else{
				throw new NullPointerException("提交的任务为空！");
			}
		}
	}
	
	private class WorkThread extends Thread{
		private boolean isRunning = true;
	    
	    public void stopWorker() {
            this.isRunning = false;
        }
	    
		public void run(){
			while(isRunning){
				while(!taskList.isEmpty()){
					Task task = getTask();
					if(task == null){
						break;
					}
					task.run();
				}
			}
		}
	}
}

