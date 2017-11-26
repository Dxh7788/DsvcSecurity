package org.otk.model;

import java.io.Serializable;

public class Dor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1971172081775951714L;
	private String id;
	private String name;
	private String title;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Dor(){
		
	}
	
	public Dor(String id, String name, String title) {
		this.id = id;
		this.name = name;
		this.title = title;
	}
	@Override
	public String toString() {
		return "Dor [id=" + id + ", name=" + name + ", title=" + title + "]";
	}
}
