package com.yhz.test.exception;

public class ExceptionTest {
	public static void main(String[] args) {
			String name = null;
			String pwd = null;
			try {
				login(name,pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public static void login(String name,String pwd) throws Exception{
		if(name==null || pwd==null){
			throw new NullPointerException("用户名或密码为空");
		}else{
			//System.out.println("登录成功");
			throw new Exception();
		}
	}
}
