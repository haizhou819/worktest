package com.yhz.test.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 公共卫生间实现男女互斥公用
 * @author sunny
 *
 */
public class Bathroom {
	private Lock lock;
	private Condition condition;
	private int malesCount;
	private int femalesCount;
	
	public Bathroom(){
		this.lock = new ReentrantLock();
		this.condition = lock.newCondition();
	}
	
	public void enterMale(){
		lock.lock();
		try{
			while(femalesCount > 0){
				condition.await();
			}
			System.out.println("a man can get into the bathroom!");
			malesCount++;
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
	
	public void leaveMale(){
		lock.lock();
		System.out.println("------a man leave bathroom!");
		malesCount--;
		condition.signalAll();
		lock.unlock();
	}
	
	public void enterFemale(){
		lock.lock();
		try{
			while(malesCount > 0){
				condition.await();
			}
			System.out.println("a woman can get into the bathroom!");
			femalesCount++;
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void leaveFemale(){
		lock.lock();
		System.out.println("------a woman leave bathroom!");
		femalesCount--;
	    condition.signalAll();
		lock.unlock();
	}
	
	public static void main(String[] args){
		Bathroom br = new Bathroom();
		Male m = new Male(br);
		Female fm = new Female(br);
		for(int i = 0; i<3; i++){
			new Thread(m).start();
		}
		for(int i = 0; i<3; i++ ){
			new Thread(fm).start();
		}
		for(int i = 0; i<3; i++){
			new Thread(m).start();
		}
	}
}

class Male implements Runnable{
	Bathroom br;
	
	public Male(Bathroom br){
		this.br = br;
	}
	
	public void run() {
		br.enterMale();
		System.out.println("a man is going to brush teeth!");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		br.leaveMale();
	}
}

class Female implements Runnable{
	Bathroom br;
	
	public Female(Bathroom br){
		this.br = br;
	}
	
	public void run() {
		br.enterFemale();
		System.out.println("a woman is going to brush teeth!");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		br.leaveFemale();
	}	
}
