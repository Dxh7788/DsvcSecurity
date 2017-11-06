package com.spfr.diff;
import java.io.IOException;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spfr.diff.support.MyResource;
@SuppressWarnings("deprecation")
public class DiffTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		//1.声明资源,加载资源
		MyResource myResource = new MyResource("E:\\OpenSrcLrn\\DsvcSecurity\\WebContent\\WEB-INF\\application.xml");
		System.out.println(myResource.exists());
		System.out.println(myResource.getFilename());
		System.out.println(myResource.contentLength());
		
		
		//怎么把Resource解析成BeanDefinition,重要的是这个解析过程
//		DefaultListableBeanFactory dfactory = new DefaultListableBeanFactory();
//		dfactory.registerBeanDefinition("",null);
		MyBeanFactory factory = new MyBeanFactory(myResource);
//		InternalResourceViewResolver obj = (InternalResourceViewResolver)factory.getBean("internalRVR");
//		System.out.println(obj);
//		System.out.println(factory.getBean("internalRVR"));
	}
}
