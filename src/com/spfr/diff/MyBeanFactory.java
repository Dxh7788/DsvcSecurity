package com.spfr.diff;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;

public class MyBeanFactory extends DefaultListableBeanFactory{
	private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);
	
	public MyBeanFactory(Resource resource){
		this(resource,null);
	}

	public MyBeanFactory(Resource resource, BeanFactory parentBeanFactory) {
		super(parentBeanFactory);
		this.reader.loadBeanDefinitions(resource);
	}
}
