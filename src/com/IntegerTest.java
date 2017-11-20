package com;

public class IntegerTest {
	/**
	 * 
	 * Integer测试类
	 * */
	public static void main(String[] args) {
		Integer inte = new Integer(100);
		/**
		 * 进制转换,toBinaryString,toOctalString,toHexString的基础都是toUnsignedString.
		 * toUnsignedString无符号的字符串,该函数中带一个偏移量参数
		 * */
		System.out.println(Integer.toBinaryString(inte));//二进制
		System.out.println(Integer.toOctalString(inte));//八进制
		System.out.println(Integer.toHexString(inte));//十六进制
//		System.out.println(Integer.toUnsignedString(inte, 6));//32进制
		/**
		 * valueOf()方法,valueOf(int),valueOf(String),valueOf(String,radix)
		 * 
		 * */
		System.out.println(Integer.valueOf(Integer.MAX_VALUE));
		System.out.println(Integer.valueOf("2147483649"));
		System.out.println(Integer.valueOf("128", 8));
	}
}
