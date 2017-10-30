package com.spfr.diff.support;

import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class MyProtocolResolver implements ProtocolResolver {

	@Override
	public Resource resolve(String location, ResourceLoader resourceLoader) {
		
		return null;
	}

}
