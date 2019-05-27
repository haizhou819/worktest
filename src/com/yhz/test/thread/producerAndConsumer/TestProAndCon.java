package com.yhz.test.thread.producerAndConsumer;

import java.util.ArrayList;
import java.util.List;

/*
 *  继经典线程同步问题之后，我们来看看生产者消费者问题及读者写者问题。
 *  生产者消费者问题是一个著名的线程同步问题，该问题描述如下：有一个生产者在生产产品，
 *  这些产品将提供给若干个消费者去消费，为了使生产者和消费者能并发执行，
 *  在两者之间设置一个具有多个缓冲区的缓冲池，生产者将它生产的产品放入一个缓冲区中，
 *  消费者可以从缓冲区中取走产品进行消费，显然生产者和消费者之间必须保持同步，
 *  即不允许消费者到一个空的缓冲区中取产品，也不允许生产者向一个已经放入产品的缓冲区中再次投放产品。
    这个生产者消费者题目不仅常用于操作系统的课程设计，也常常在程序员和软件设计师考试中出现。
    并且在计算机考研的专业课考试中也是一个非常热门的问题。因此现在就针对这个问题进行详细深入的解答。
 */
public class TestProAndCon {
	public static void main(String[] args) {
		Basket basket = new Basket();
		
		for(int i=0;i<10;i++){
			new Thread(new Producer(basket)).start();
			new Thread(new Consumer(basket)).start();
		}
	}
}

class Egg{
	private  int no;
	
	Egg(int no){
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}

class Basket{
	private List<Egg> list = new ArrayList<Egg>();//一次只能放一个
	
	public synchronized Egg getEgg(){
		while(list.size() == 0){   //注意此处只能用while循环判断条件，不能用if判断
			try {
				this.wait();
	            //当前线程进入阻塞队列，且该方法必须在while循环中，不能在if条件中
                //原因线程被唤醒 不等于 线程满足执行条件 ，当有多个等待线程被唤醒时（多个线程等在wait方法处，其他线程调用notifyAll方法），比如线程A、线程B
	            //若A线程获得锁，且执行的条件满足list.size() != 0，此时该线程顺利执行，但是执行完后条件又被改变了（对B来说条件又不满足了），
	            //此时B线程若获得锁，如果使用if判断，则本次B线程是不会对条件做判断的，因为if只判断一次，之前B线程已经判断过一次，
	            //B直接执行wait下面的代码，结果会报错，如果使用while判断，B会对条件再做一次判断，若条件不满足，则此次B会又一次
	            //执行wait方法，进入阻塞队列，而不会执行wait下面的代码，所以不会出错。
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Egg egg = list.get(0);
		
		list.clear();
		/**
		 * 在多个生产者和消费者的情况下，使用notify（）方法容易发生死锁，
		 * 比如所有生产者处于wait状态，多个消费者处于wait状态，同时有一个消费者
		 * 处于运行状态，当这个消费者执行到notify（）方法时，若此时唤醒的是另一个消费者
		 * 线程，根据条件list.size（）==0，被唤醒的消费者线程又将执行wait（）方法，进入
		 * wait状态，此时所有线程都处于wait状态发生死锁。如果使用notifyAll方法来唤醒所有正在等待该锁的线程，
		 * 那么所有的线程都会处于运行前的准备状态（就是消费者线程执行完后，唤醒了所有等待该锁的状态,注：不是wait状态,就绪状态），
		 * 那么此时，即使再次唤醒一个消费者调度线程，while循环等于true，唤醒的线程再次处于等待状态，
		 * 那么还会有其它的线程可以获得锁，进入运行状态。
		 * 
		 */
		// 唤醒阻塞队列的某线程到就绪队列
		this.notifyAll();
		System.out.println(Thread.currentThread().getName()+"取出鸡蛋------"+egg.getNo());
		
		return egg;		 
	}
	
	public synchronized void putEgg(Egg egg){
		while(list.size() > 0){
			try {
				this.wait();      
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		list.add(egg);
		
		// 唤醒阻塞队列的某线程到就绪队列
		this.notifyAll();
		
		System.out.println(Thread.currentThread().getName()+"放入鸡蛋------"+egg.getNo());
	}
}

class Producer implements Runnable{	
	private Basket basket;
	private static int i = 1;
	//private static Object o = new Object();  //保证鸡蛋的编号不重复
	private Egg egg = null;
	
	Producer(Basket basket){
		this.basket = basket;
		//synchronized(o){
			egg = new Egg(i);
			i++;
		//}
	}
	
	@Override
	public void run() {
		basket.putEgg(egg);
	}
}

class Consumer implements Runnable{
	private Basket basket;
	
	Consumer(Basket basket){
		this.basket = basket;
	}
	
	@Override
	public void run() {
		basket.getEgg();
	}
}