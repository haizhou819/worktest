package com.yhz.test.designModel.decarator;

public class D2 extends Old{

	private Old d;
	
	public D2(Old d){
		this.d = d;
	}

	@Override
	public void t() {
		System.out.println("添加事务处理功能");
		d.t();
	}
}
