package com.spfr.diff;
import java.io.IOException;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
public class DiffTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		//1.声明资源,加载资源
		DefaultResourceLoader rsLoader = new DefaultResourceLoader();
		Resource resouce =  rsLoader.getResource("E:\\htouhui1\\htouhui\\htouhui-web\\src\\main\\filters\\applicationContext-sign-util.xml");
		System.out.println(resouce.exists());
		System.out.println(resouce.getFilename());
		System.out.println(resouce.contentLength());
	}
}
