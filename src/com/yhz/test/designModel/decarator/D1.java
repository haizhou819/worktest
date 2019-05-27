package com.yhz.test.designModel.decarator;

public class D1 extends Old{
	
	private Old d;
	
	public D1(Old d){
		this.d = d;
	}

	@Override
	public void t() {
		System.out.println("添加日志功能");
		d.t();
	}

}
