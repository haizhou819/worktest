package com.yhz.test.thread.pool.impl3;

import com.yhz.test.thread.pool.impl2.Task;
import com.yhz.test.thread.pool.impl2.TaskSample;
import com.yhz.test.thread.pool.impl2.TaskSample2;


public class Test {
	public static void main(String[] args) {
		ThreadPoolManager pool = ThreadPoolManager.getInstance();
		Task newTask1 = new TaskSample(1);
		pool.addTask(newTask1);
		Task newTask2 = new TaskSample(2);
		pool.addTask(newTask2);
		Task newTask3 = new TaskSample2();
		pool.addTask(newTask3);
		pool.destory();
	}
}
