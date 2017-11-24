package spfr.jdbc.analysis.chap01.model;

import java.io.Serializable;

public class Dor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8115579300825963407L;
	private String id;//id
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
}
