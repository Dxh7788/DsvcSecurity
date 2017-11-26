package com;

import org.otk.model.User;

public class SystemClassTest {
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long l = rt.totalMemory();
		SystemClassTest sct =new SystemClassTest();
		System.out.println("有"+l/(1024*1024)+"M内存");
		
		/**
		 *  测试==的作用
		 * */
		User origin = new User();
		User u = origin;
		System.out.println("对象==的比较结果"+(origin==u));
		/**
		* 底层实现也是origin==u,使用的==
		* ==和equals是一样的
		* 但对Spring来说,equals不仅仅比较的是地址还是比较的value值
		* ==如果作用于引用类型的变量，则比较的是所指向的对象的地址
		*/
		System.out.println(origin.equals(u));
		/**
		 * 测试String
		 * */
		String s = new String("123");
		String s0 = s;
		System.out.println(s==s0);
		
		/**
		 * ========================================================
		 *                            别名现象                                                                    =
		 * ========================================================
		 * 1.基本类型
		 * 2.基本类型的包装类
		 * 3.自定义类
		 * */
		int a=8;
		int b=9;
		System.out.println("a="+a+", b="+b);
//		sct.swap(a,b);
		System.out.println("a="+a+", b="+b);
		/**
		 * 以上的值没变
		 * */
		Integer c =10;
		Integer d =11;
		System.out.println("c="+c+", d="+d);
		sct.swap(c,d);
		System.out.println("c="+c+", d="+d);
		/**
		 * 可见主类型的包装类同基本类型一样,采用的是值传递,不存在别名现象
		 * */
		
		/**
		 * 布尔值封装类和基本类型的区别
		 * */
		Boolean mb = Boolean.TRUE;
		boolean mb2 =true;
		Boolean mb3 = true;
		System.out.println(mb==mb2);
		System.out.println(mb==mb3);
		/**
		 * 由此可见,Boolean值得==和equals能起到相同作用,虽然它们的原理不同,==代表所引用的值的地址是否一致,而equals代表值是否一致.
		 * */
		Integer ia = new Integer(7);
		Integer ib = new Integer(7);
		Integer ic = Integer.valueOf(7);
		System.out.println(ia==ib);
		System.out.println(ia==ic);
		System.out.println(ia.equals(ic));
		Double iac =new Double(0d);
		Double iad =new Double(0d);
		System.out.println(iac==iad);
		System.out.println(iac.equals(iad));
		/**
		 * 虽然说字符串123保存在常量池中,但是经过new的过程之后,新生成的对象又开辟了新的空间
		 * */
		String is= new String("123");
		String isb= new String("123");
		System.out.println(is==isb);
		/**
		 * Object的==和equals
		 * */
		User u1= new User();
		User u2=u1;
		System.out.println(u1==u2);
		System.out.println(u1.equals(u2));
		
		/**
		 * 布尔值比较
		 * */
	}
	void swap(Integer a,Integer b){
		Integer temp =0;
		temp = a;
		a=b;
		b=temp;
	}
	
	Integer inc(Integer k,Integer l){
		return 0;
	}
}
