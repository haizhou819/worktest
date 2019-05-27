package com.yhz.test.thread.vol;

public class TestVolatile {
	public volatile int inc = 0;
	
    public void increase() {
        inc++;
        try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    /**
     * 一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
　　	 *	1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
　　	 *	2）禁止进行指令重排序。
	 *
	 * 对于可见性，Java提供了volatile关键字来保证可见性。
　　	 *	当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
　　	 *  而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，什么时候被写入主存是不确定的，当其他线程去读取时，
	 *	此时内存中可能还是原来的旧值，因此无法保证可见性。
	 *	
     * 测试发现结果不是期望的1000，volatile保证了可见性，那么在每个线程中对inc自增完之后，
     * 在其他线程中都能看到修改后的值啊，所以有10个线程分别进行了100次操作，那么最终inc的值应该是100*10=10000。
     * 误区在于，volatile关键字能保证可见性没有错，但是上面的程序错在没能保证原子性。可见性只能保证每次读取的是最新的值，
     * 但是volatile没办法保证对变量的操作的原子性。
     * 自增操作是不具备原子性的，它包括读取变量的原始值、进行加1操作、写入工作内存。
     * 那么就是说自增操作的三个子操作可能会分割开执行，就有可能导致下面这种情况出现：
     * 假如某个时刻变量inc的值为10，线程1先读取了变量inc的原始值，然后线程1被阻塞了，线程2也去读取变量inc的原始值，
     * 然后进行加1操作，并把11写入工作内存，最后写入主存。然后线程1接着进行加1操作，由于已经读取了inc的值，
     * 注意此时在线程1的工作内存中inc的值仍然为10，所以线程1对inc进行加1操作后inc的值为11，
     * 然后将11写入工作内存，最后写入主存。两个线程分别进行了一次自增操作后，inc只增加了1。
     * @param args
     */
    public static void main(String[] args) {
        final TestVolatile test = new TestVolatile();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<100;j++)
                        test.increase();
                };
            }.start();
        }
         
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
