package com.yhz.test.designModel.decarator;

public class D3 extends Old{
	private Old d;
	
	public D3(Old d){
		this.d = d;
	}

	@Override
	public void t() {
		System.out.println("添加安全检查功能");
		d.t();
	}
}
