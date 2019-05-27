package com.yhz.test.proxy.aop;

import java.util.List;
/**
 * 静态代理
 * @author sunny
 *
 */
public class UserServProxyImpl implements IUserServ{
	// 访问目标对象(UserServImpl)  
    // 代理对象(UserServProxyImpl)  
    // 持有目标对象的引用  
    private IUserServ iuserServ ;
  
    public UserServProxyImpl(IUserServ iuserServ){  
        this.iuserServ = iuserServ;  
    }  
    public int deleteUserById(User user) {  
        beforeLog();  
        //调用目标对象里方法  
        iuserServ.deleteUserById(user);  
        afterLog();  
        return 0;  
    }  
  
    public List<User> findAllUser() {  
        beforeLog();  
        //调用目标对象里方法  
        iuserServ.findAllUser();  
        afterLog();  
        return null;  
    }  
  
    public int saveUser(User user) {  
        beforeLog();  
        //调用目标对象里方法  
        iuserServ.saveUser(user);  
        afterLog();  
        return 0;  
    }  
  
    private void beforeLog() {  
        System.out.println("开始执行");  
    }  
      
    private void afterLog() {  
        System.out.println("执行完毕");  
    }  
}
