package model;

import java.io.Serializable;

/*
 * �����ݿ���GoodsInfo���Ӧ��������
 */
public class GoodsInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;   //������Ʒ���
	private String name; //������Ʒ����
	private double price;//������Ʒ�۸�
	private int    num;//���幺������

	
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
