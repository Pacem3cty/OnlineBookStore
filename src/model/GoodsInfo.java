package model;

import java.io.Serializable;

/*
 * 与数据库中GoodsInfo表对应的数据类
 */
public class GoodsInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;   //定义商品编号
	private String name; //定义商品名称
	private double price;//定义商品价格
	private int    num;//定义购物数量

	
	public String getId() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;		
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;		
	}
}
