package com;

import com.dsvc.model.Initializer;

public class InitializerTest {
	public static void main(String[] args) {
		Initializer ier = new Initializer(); 
		System.out.println(ier);
		InitializerTest it = new InitializerTest();
		it.p();
		
		int a=9;
		int b =8;
		System.out.println("a="+a+",b="+b);
		it.swap(a, b);
		System.out.println("a="+a+",b="+b);
		Integer A= 8;
		Integer B=9;
		System.out.println("对象传值前,A="+A+",B="+B);
		it.swapb(A, B);
		System.out.println("对象传值后,A="+A+",B="+B);
	}
	
	void p(){
		int i = 0;
		System.out.println(i);
	}
	/**
	 * 测试主类型传值方式
	 * 值传递
	 * */
	public void swap(int a,int b){
		int temp;
		temp =a;
		a=b;
		b=temp;
		System.out.println("a="+a+",b="+b);
	}
	/**
	 * 测试对象的方式
	 * */
	public void swapb(Integer a,Integer b){
		int temp;
		temp =a;
		a=b;
		b=temp;
		System.out.println("对象传值中,A="+a+",B="+b);
	}
	/**
	 * static的意义,一:只想用一个存储区域保存一个特定的数据
	 * 2:特殊的方法,不跟任何一个对象关联
	 * 在对象未实例化前,static只能访问static属性和方法
	 * @see
	 * @param df
	 * @return vb
	 * @exception nn
	 * */
	
	
}
