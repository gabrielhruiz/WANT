package org.app.want.parasite.file;

import java.util.Date;

public class File {
	private String name;
	private String content;
	private Date lastMod;
	public File(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getLastMod() {
		return lastMod;
	}
	public void setLastMod(Date lastMod) {
		this.lastMod = lastMod;
	}
	public String toString(){
		return "{"+getName()+", "+getContent()+", "+getLastMod()+"}";
	}
}
