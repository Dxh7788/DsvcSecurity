package com.spfr.diff;
import java.io.IOException;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.spfr.diff.support.MyResource;
@SuppressWarnings("deprecation")
public class DiffTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		//1.声明资源,加载资源
		MyResource myResource = new MyResource("G:\\JavaWebDev\\DsvcSecurity\\WebContent\\WEB-INF\\application.xml");
		System.out.println(myResource.exists());
		System.out.println(myResource.getFilename());
		System.out.println(myResource.contentLength());
		
		
		//怎么把Resource解析成BeanDefinition,重要的是这个解析过程
//		DefaultListableBeanFactory dfactory = new DefaultListableBeanFactory();
//		dfactory.registerBeanDefinition("",null);
		XmlBeanFactory factory = new XmlBeanFactory(myResource);
		System.out.println(factory.getBean("internalRVR"));
	}
}
