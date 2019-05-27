package com.yhz.test.interfacetest;

public class Xyz implements InterfaceSub{
	 public void output() {    
         System.out.println( "output in class Xyz." );    
	 }    
	 public void outputLen( int  type) {    
         switch (type) {    
             case  InterfaceA.len:    
                 System.out.println( "len of InterfaceA=." +type);    
                 break ;    
             case  InterfaceB.len:    
                 System.out.println( "len of InterfaceB=." +type);    
                 break ;    
          }    
	 }    
	 public   static   void  main(String[] args) {    
        Xyz xyz=  new  Xyz ();    
        xyz.output();    
        xyz.outputLen(1);   
		/* Xyz xyz =  new  Xyz();    
		 int  len = xyz.len;    
		 System.out.println(len); */ 
	 }    
}
