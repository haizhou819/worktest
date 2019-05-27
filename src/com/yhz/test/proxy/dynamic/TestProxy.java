package com.yhz.test.proxy.dynamic;

public class TestProxy {
	public static void main(String[] args) {  
        BookFacadeHandler proxyHandler = new BookFacadeHandler();  
        BookFacade bookProxy = (BookFacade) proxyHandler.bind(new BookFacadeImpl());  
        bookProxy.addBook();  
    } 
}
