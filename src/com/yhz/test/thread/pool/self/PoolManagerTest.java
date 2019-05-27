package com.yhz.test.thread.pool.self;

public class PoolManagerTest {
	 public static void main(String[] args) {

        ThreadPoolManager threadpoolmanager = new ThreadPoolManager("SimpleThreadPool");
        threadpoolmanager.threadPoolStart();
        Task newTask = new TestTask(1);
        threadpoolmanager.addTask(newTask);
        newTask = new TestTask(2);
        threadpoolmanager.addTask(newTask);
        newTask = new TestTask(3);
        threadpoolmanager.addTask(newTask);
        newTask = new TestTask(4);
        threadpoolmanager.addTask(newTask);
        newTask = new TestTask(5);
        threadpoolmanager.addTask(newTask);
        newTask = new TestTask(6);
        threadpoolmanager.addTask(newTask);
        //threadpoolmanager.threadPoolEnd();

	    }
}
