package com.spfr.diff.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class MyResource implements Resource,WritableResource{

	private final File file;

	private final String path;
	
	public MyResource(File file) {
		this.file = file;
		this.path = StringUtils.cleanPath(file.getPath());
	}

	public MyResource(String path) {
		Assert.notNull(path, "Path must not be null");
		this.file = new File(path);
		this.path = StringUtils.cleanPath(file.getPath());
	}
	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(this.file);
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return file.exists();
	}

	@Override
	public boolean isReadable() {
		// TODO Auto-generated method stub
		return (this.file.canRead() && !this.file.isDirectory());
	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public URL getURL() throws IOException {
		return file.toURI().toURL();
	}

	@Override
	public URI getURI() throws IOException {
		return file.toURI();
	}

	@Override
	public File getFile() throws IOException {
		return this.file;
	}

	@Override
	public long contentLength() throws IOException {
		return file.length();
	}

	@Override
	public long lastModified() throws IOException {
		return 0;
	}

	@Override
	public Resource createRelative(String relativePath) throws IOException {
		return null;
	}

	@Override
	public String getFilename() {
		return file.getName();
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public boolean isWritable() {
		return false;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return new FileOutputStream(file);
	}

}
