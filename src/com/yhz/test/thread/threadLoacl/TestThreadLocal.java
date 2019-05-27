package com.yhz.test.thread.threadLoacl;

public class TestThreadLocal {
	public static void main(String[] args) { 
        MyThreadLocal tlt = new MyThreadLocal(); 
        //MyThreadLocal2 tlt = new MyThreadLocal2();
        //MyThreadLocalImpl tlt = new MyThreadLocalImpl();  //自己实现ThreadLocal功能
        Thread t1 = new Thread(new MyThread(tlt)); 
        Thread t2 = new Thread(new MyThread(tlt)); 
        Thread t3 = new Thread(new MyThread(tlt)); 
        Thread t4 = new Thread(new MyThread(tlt)); 
        t1.start(); 
        t2.start(); 
        t3.start(); 
        t4.start(); 
	} 
}

class MyThreadLocal{
	 //定义了一个ThreadLocal变量，用来保存int或Integer数据 
    private ThreadLocal<Integer> tl = new ThreadLocal<Integer>() { 
        @Override 
        protected Integer initialValue() { 
                return 0; 
        } 
    }; 

    public Integer getNextNum() { 
        //将tl的值获取后加1，并更新设置t1的值 
        tl.set(tl.get() + 1); 
        return tl.get(); 
    } 
}

//不使用ThreadLocal
class MyThreadLocal2{
	private Integer t1 = 0; 
    public Integer getNextNum(){ 
        return t1=t1+1; 
    } 
}

class MyThread implements Runnable{

	private MyThreadLocal tlt = null;
	//private MyThreadLocal2 tlt = null; 
	//private MyThreadLocalImpl tlt = null;
   /* public MyThread(MyThreadLocalImpl tlt) { 
            this.tlt = tlt; 
    } */
    
    public MyThread(MyThreadLocal tlt) { 
        this.tlt = tlt; 
} 

    @Override 
    public void run() { 
        for (int i = 0; i < 3; i++) { 
                System.out.println(Thread.currentThread().getName() + "\t" + tlt.getNextNum()); 
        } 
    } 
	
}