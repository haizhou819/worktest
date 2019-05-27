package com.yhz.test.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Go {
	public static void main(String[] args) {  
        int [] vals = new int[]{1,2,3,4,5,6,7,8,9,10};  
        User user = Go.setUserValues(vals);  
        List list = Go.getUserValues(user);  
        for (int i = 0; i < list.size(); i++) {  
            int j = i+1;  
            System.out.println("value" + j + "=" + list.get(i));  
        }  
    }  
      
    public static User setUserValues(int [] vals) {  
        User user = new User();  
        try {  
            //获取Class的对象  
            Class c = user.getClass();  
            for (int i = 1; i <= 10; i++) {  
                //动态获取方法名  
                String methodName = "setValue"+i;  
                //设置方法的参数  
                Class[] args = new Class[1];  
                Integer u = new Integer(3);  
                args[0] = u.getClass();  
                Method method = c.getMethod(methodName, args);  
                //调用方法  
                method.invoke(user, vals[i-1]);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return user;  
    }  
      
    public static List getUserValues(User user) {  
        List list = new ArrayList();  
        try {  
            Class c = user.getClass();  
            for (int i = 1; i <= 10; i++) {  
                String methodName = "getValue"+i;  
                Method method = c.getMethod(methodName, null);  
                Integer s = (Integer) method.invoke(user, null);  
                list.add(s);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return list;  
    }  
      
}
