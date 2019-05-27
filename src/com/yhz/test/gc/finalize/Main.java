package com.yhz.test.gc.finalize;

public class Main {
	public static void main(String[] args) throws Exception {  
        @SuppressWarnings("unused")
		A a = new A(new B("allen", 20));  
        a = null;  
  
        System.gc();  
        Thread.sleep(5000);  
        System.out.println(C.a.b);  
        System.out.println(a);
    }  
}

class C {  
    static A a;  
}  
  
class A {  
    B b;  
  
    public A(B b) {  
        this.b = b;  
    }  
  
    @Override  
    public void finalize() {  
        System.out.println("A finalize");  
        C.a = this;  
    } 
    
    @Override  
    public String toString() {  
        return "a is alive";  
    }  
}  
  
class B {  
    String name;  
    int age;  
  
    public B(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }  
  
    @Override  
    public void finalize() {  
        System.out.println("B finalize");  
    }  
  
    @Override  
    public String toString() {  
        return name + " is " + age;  
    }  
}  