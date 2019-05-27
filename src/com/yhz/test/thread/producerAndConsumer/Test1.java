package com.yhz.test.thread.producerAndConsumer;


public class Test1 {
	public static void main(String[] args) {
		EggBasket b = new EggBasket();
		
		for(int i=0; i<3; i++){
			new Thread(new NewProducer(b)).start();
			new Thread(new NewConsumer(b)).start();
		}
	}
}

class NewEgg{
	private int id;
	
	NewEgg(int id){
		this.id = id;
	}
	
	public String toString(){
		return "egg:"+id;
	}
}

class EggBasket{
	private NewEgg[] eggList = new NewEgg[5];
	private int index = 0;
	
	public synchronized void putEgg(NewEgg e){
		while(index == eggList.length){
			try {
				this.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		this.notifyAll();
		eggList[index] = e;
		index++;
	}
	
	public synchronized NewEgg getEgg(){
		while(index == 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		index--;
		return eggList[index];
	}
}

class NewProducer implements Runnable{
	private EggBasket b;
	private static int num = 0;//为每个生产的鸡蛋递增编号
	
	NewProducer(EggBasket b){
		this.b = b;
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			NewEgg e = new NewEgg(num++);
			b.putEgg(e);
			System.out.println("生产了"+e);
			try {
				Thread.sleep(10); //每生产一个鸡蛋休息10毫秒
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}

class NewConsumer implements Runnable{
	private EggBasket b;
	
	NewConsumer(EggBasket b){
		this.b = b;
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			NewEgg e = b.getEgg();
			System.out.println("消费了"+e);
			try {
				Thread.sleep(100);//每消费一个鸡蛋休息100毫秒
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}

