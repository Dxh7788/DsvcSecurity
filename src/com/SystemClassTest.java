package com;

import org.otk.model.User;

public class SystemClassTest {
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long l = rt.totalMemory();
		System.out.println("有"+l/(1024*1024)+"M内存");
		
		/**
		 *  测试==的作用
		 * */
		User origin = new User();
		User u = origin;
		System.out.println(origin==u);
		/**
		* 底层实现也是origin==u,使用的==
		* ==和equals是一样的
		* 但对Spring来说,equals不仅仅比较的是地址还是比较的value值
		*/
		System.out.println(origin.equals(u));
		/**
		 * 测试String
		 * */
		String s = new String("123");
		String s0 = s;
		System.out.println(s==s0);
	}
}
