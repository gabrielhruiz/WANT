package org.app.want.parasite.useraccount;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.app.want.parasite.file.File;
@Entity
public class User {
	@Id
	private String userName;
	private String mail;
	private List<File> files;
	private String phone;
	public User(){}
	public User(String uname, String mail, List<File> files, String phone){
		userName=uname;
		this.mail=mail;
		this.files=files;
		this.phone=phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String toString(){
		return "{"+getUserName()+","+getMail()+"}";
	}
}
