package com.yhz.test.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	Lock lock = new ReentrantLock();    //注意这个地方
    public static void main(String[] args)  {
        final ReentrantLockTest test = new ReentrantLockTest();
         
        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
         
        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }  
     
    public void insert(Thread thread) {
        //Lock lock = new ReentrantLock();    //注意这个地方
        /*lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
        	
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }*/
    	 if(lock.tryLock()) {
             try {
                 System.out.println(thread.getName()+"得到了锁");
                 for(int i=0;i<5;i++) {
                     arrayList.add(i);
                 }
             } catch (Exception e) {
            	 
             }finally {
                 System.out.println(thread.getName()+"释放了锁");
                 lock.unlock();
             }
         } else {
             System.out.println(thread.getName()+"获取锁失败");
         }
    }
}
