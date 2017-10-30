package com.spfr.diff;
import java.io.IOException;

import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.spfr.diff.support.MyResource;
@SuppressWarnings("deprecation")
public class DiffTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		//1.������Դ,������Դ
		MyResource myResource = new MyResource("G:\\JavaWebDev\\DsvcSecurity\\WebContent\\WEB-INF\\application.xml");
		System.out.println(myResource.exists());
		System.out.println(myResource.getFilename());
		System.out.println(myResource.contentLength());
		
		XmlBeanFactory factory = new XmlBeanFactory(myResource);
		System.out.println(factory.getBean("internalRVR"));
	}
}
