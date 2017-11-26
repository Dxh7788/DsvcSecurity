package com;

public class SystemClassTest {
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long l = rt.totalMemory();
		System.out.println("有"+l/(1024*1024)+"M内存");
	}
}
