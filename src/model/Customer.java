package model;

import java.io.Serializable;

/*
 * 购物用户数据类
 */
public class Customer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;   //定义用户编号
	private String loginname; //定义用户名称
	private String password;//定义登录密码

	
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
