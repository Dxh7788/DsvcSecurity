package com;

public class IntegerTest {
	/**
	 * 
	 * Integer������
	 * */
	public static void main(String[] args) {
		Integer inte = new Integer(100);
		/**
		 * ����ת��,toBinaryString,toOctalString,toHexString�Ļ�������toUnsignedString.
		 * toUnsignedString�޷��ŵ��ַ���,�ú����д�һ��ƫ��������
		 * */
		System.out.println(Integer.toBinaryString(inte));//������
		System.out.println(Integer.toOctalString(inte));//�˽���
		System.out.println(Integer.toHexString(inte));//ʮ������
//		System.out.println(Integer.toUnsignedString(inte, 6));//32����
		/**
		 * valueOf()����,valueOf(int),valueOf(String),valueOf(String,radix)
		 * 
		 * */
		System.out.println(Integer.valueOf(Integer.MAX_VALUE));
		System.out.println(Integer.valueOf("2147483649"));
		System.out.println(Integer.valueOf("128", 8));
	}
}
