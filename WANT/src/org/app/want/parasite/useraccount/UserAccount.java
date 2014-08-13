package org.app.want.parasite.useraccount;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class UserAccount {
	private String name;
	private String surname;
	@Id
	private String userName;
	private String password;
	private String mail;
	private String phone;
	private Integer zipcode;
	private String uType;
	public UserAccount(){}
	public UserAccount(String name, String surname, String username, String pssd, String mail, String phone, Integer zipcode){
		this.name=name;
		this.surname=surname;
		this.userName=username;
		this.password=pssd;
		this.mail=mail;
		this.phone=phone;
		this.zipcode=zipcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public String getuType() {
		return uType;
	}
	public void setuType(String uType) {
		this.uType = uType;
	}
	public String toString(){
		return "{"+getName()+","+getSurname()+","+getUserName()+","+getMail()+","+getPhone()+","+getZipcode()+"}";
	}
}
