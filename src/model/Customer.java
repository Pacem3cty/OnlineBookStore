package model;

import java.io.Serializable;

/*
 * �����û�������
 */
public class Customer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;   //�����û����
	private String loginname; //�����û�����
	private String password;//�����¼����

	
	public String getId() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;		
	}

}
