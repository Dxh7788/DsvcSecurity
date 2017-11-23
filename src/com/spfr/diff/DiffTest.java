package com.spfr.diff;
import java.io.IOException;

import com.spfr.diff.support.MyResource;
public class DiffTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		MyResource myResource = new MyResource("E:\\OpenSrcLrn\\DsvcSecurity\\WebContent\\WEB-INF\\application.xml");
		System.out.println(myResource.exists());
		System.out.println(myResource.getFilename());
		System.out.println(myResource.contentLength());
		
		
//		DefaultListableBeanFactory dfactory = new DefaultListableBeanFactory();
//		dfactory.registerBeanDefinition("",null);
		MyBeanFactory factory = new MyBeanFactory(myResource);
//		InternalResourceViewResolver obj = (InternalResourceViewResolver)factory.getBean("internalRVR");
//		System.out.println(obj);
		System.out.println(factory.getBean("address"));
	}
}
