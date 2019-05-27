package com.yhz.test.thread.threadLoacl.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyThreadLocalImpl {
	
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

class ThreadLocal<T>{
	private Map<Thread, T> map = Collections.synchronizedMap(new HashMap<Thread, T>()); 

    public ThreadLocal() {} 

    protected T initialValue() { 
         return null; 
    } 

    public T get() { 
        Thread t = Thread.currentThread(); 
        T obj = map.get(t); 
        if (obj == null && !map.containsKey(t)) { 
                obj = initialValue(); 
                map.put(t, obj); 
        } 
        return obj; 
    } 

    public void set(T value) { 
        map.put(Thread.currentThread(), value); 
    } 

    public void remove() { 
        map.remove(Thread.currentThread()); 
    } 
}
