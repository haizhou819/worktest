package com.yhz.test.proxy.aop;

import com.yhz.test.proxy.dynamic.BookFacade;
import com.yhz.test.proxy.dynamic.BookFacadeImpl;

public class Test {
	public static void main(String[] args) {  
        //用户访问代理对象---信息->目标对象  
        /*IUserServ iuserServ = new UserServProxyImpl(new UserServImpl());  
        iuserServ.findAllUser();  
        User user = new User();
        iuserServ.deleteUserById(user);
        iuserServ.saveUser(user);*/
		LogHandler handler = new LogHandler();
		/*IUserServ userSer = (IUserServ)handler.createProxy(new UserServImpl());
		userSer.findAllUser();*/
		BookFacade book = (BookFacade)handler.createProxy(new BookFacadeImpl());
		book.addBook();
    }  
}
