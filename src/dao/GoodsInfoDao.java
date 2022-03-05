package dao;

import java.sql.*;
import java.util.*;

import model.DBUtil;
import model.GoodsInfo;
/*
 * ����ʵ�ֶ�GoodsInfoDao�����ݿ�����ķ�����
 */
public class GoodsInfoDao implements GoodsInfoDaoI
{//�̳�GoodsInfoDao�ӿڲ�ʵ���䶨������з���
	int  line;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ptst;
	public GoodsInfoDao()
	{
		conn = null;
		stmt = null;
		rs = null;
		ptst = null;
		line=0;
	}
	//��ʹ�õĶ��󶼽��л���
	void closeAll()
	{
		
		if(rs != null)
			try 
		{
				rs.close();

		} 
		catch (SQLException e) 
		{
		}
		
		if (stmt != null)
			try 
		{
				stmt.close();

			
		}
		catch (SQLException e) 
		{
		}

		if (ptst != null)
			try 
		{
				ptst.close();

		} 
		catch (SQLException e) 
		{
		}
		
		if (conn != null)
			try 
		{
				conn.close();

		} 
		catch (SQLException e) 
		{
		}

}
	
	// ��ѯ���м�¼
	public List<GoodsInfo> queryAllResult() 
	{
		List<GoodsInfo> goodsinfoList = null;
		try {
			conn = DBUtil.getConnection();
			//DBUtil db = new DBUtil();
			//conn = db.getCon();					
			goodsinfoList = new ArrayList<GoodsInfo>();			
			String sql = "select * from goodsinfo";
			stmt= conn.createStatement ();
			rs=stmt.executeQuery(sql);
			
			while (rs.next()) {
				GoodsInfo GI = new GoodsInfo();
				GI.setID(rs.getString("ID"));
				GI.setName(rs.getString("name"));
				GI.setPrice(rs.getDouble("price"));
				goodsinfoList.add(GI);	
			}
		} catch (Exception e) {
			System.out.println("ȫ����ѯ"+e);
		} finally {
			closeAll();	
		}
		return goodsinfoList;
	}

	// ��������ģ�����Ҽ�¼
	public List<GoodsInfo> searchByName(String name) {
		List<GoodsInfo> goodsinfoList = null;
		try {
			conn = DBUtil.getConnection();
			//DBUtil db = new DBUtil();
			//conn = db.getCon();					
			goodsinfoList = new ArrayList<GoodsInfo>();			
			String sql = "select * from goodsinfo where name like '%" + name + "%'";
			stmt= conn.createStatement ();
			rs=stmt.executeQuery(sql);
			
			while (rs.next()) {
				GoodsInfo GI = new GoodsInfo();
				GI.setID(rs.getString("ID"));
				GI.setName(rs.getString("name"));
				GI.setPrice(rs.getDouble("price"));
				goodsinfoList.add(GI);	
			}
		} catch (Exception e) {
			System.out.println("������ѯ"+e);
		} finally {
			closeAll();	
		}
		return goodsinfoList;
	}

	// �����¼
	public boolean insertGoodsInfo(GoodsInfo GI) {		
		boolean flag = false;
		try {
			conn = DBUtil.getConnection();
			//DBUtil db = new DBUtil();
			//conn = db.getCon();
			String condition = "insert into goodsinfo values(?,?,?)";
			ptst = conn.prepareStatement(condition);
			ptst.setString(1, GI.getId());
			ptst.setString(2, GI.getName());
			ptst.setDouble(3, GI.getPrice());		
			if (ptst.executeUpdate() >= 1)
				flag = true;			
		} catch (Exception ex) {
			System.out.println("insert:"+ex);
			flag = false;
		} finally {
			closeAll();
		}
		return flag;
	}

	// ���¼�¼
	public boolean updateGoodsInfo(GoodsInfo GI) {
		boolean flag = false;
		try {
			//conn = DBUtil.getConnection();
			DBUtil db = new DBUtil();
			conn=db.getCon();
			String sql = "update goodsinfo set name=?,price=? where id=?";
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, GI.getName());
			ptst.setDouble(2, GI.getPrice());
			ptst.setString(3, GI.getId());
			if (ptst.executeUpdate() >= 1)
				flag = true;
		}
			 catch (Exception ex) {
			    System.out.println("update:"+ex);
			    System.out.println("�޸�����ʧ��");
			    flag = false;
		} finally {
			closeAll();
		}
		return flag;
	}

	// ����id�Ų��Ҽ�¼���ҵ��Ļ�����GoodsInfo����
	public List<GoodsInfo> searchById(String id) {
		List<GoodsInfo> goodsinfoList = null;
		GoodsInfo GI = new GoodsInfo();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			//DBUtil db = new DBUtil();
			//conn = db.getCon();					
			goodsinfoList = new ArrayList<GoodsInfo>();
			String condition = "select * from goodsinfo where id='" + id + "'";
			stmt= conn.createStatement ();
			rs=stmt.executeQuery(condition);		
			while (rs.next()) {			
				GI.setID(rs.getString("id"));
				GI.setName(rs.getString("name"));
				GI.setPrice(rs.getDouble("price"));
				goodsinfoList.add(GI);	
			}
		} catch (Exception ex) {
			System.out.println("search by id:" + ex);
		} finally {
				closeAll();
		}
		return goodsinfoList;
	}
	
	// ����id�Ų��Ҽ�¼�������޸�����ʱ��ȡid��
	public GoodsInfo searchByIdForUpdate(String id) {
		GoodsInfo GI = new GoodsInfo();
		try {
			conn = DBUtil.getConnection();
			//DBUtil db = new DBUtil();
			//conn = db.getCon();					
			String condition = "select * from goodsinfo where id='" + id + "'";
			stmt= conn.createStatement ();
			rs=stmt.executeQuery(condition);		
			while (rs.next()) {			
				GI.setID(rs.getString("id"));
				GI.setName(rs.getString("name"));
				GI.setPrice(rs.getDouble("price"));
			}
		} catch (Exception ex) {
			System.out.println("search by id:" + ex);
			System.out.println("��Ʒ��Ų�ѯʧ��");
		} finally {
				closeAll();
		}
		return GI;
	}
	
	// ����id��ɾ����¼������ɾ��������ز���ֵ
	public boolean deleteById(String id) {
		
		boolean flag = false;
		try {
			conn = DBUtil.getConnection();
			//DBUtil db = new DBUtil();
			//conn = db.getCon();
			String condition = "delete from goodsinfo where id=?";
			ptst = conn.prepareStatement(condition);
			ptst.setString(1, id);
			if (ptst.executeUpdate() >= 1)
				flag = true;
		} catch (Exception ex) {
			     flag = false;
			     System.out.print("delete:"+ex);
		} finally {
			closeAll();
		}
		return flag;
	}
	//ɾ��������¼ δʹ��
	public int delByIdS(String[] idString) {
	int number=0;//ɾ����
	try {
		conn = DBUtil.getConnection();
		//DBUtil db = new DBUtil();
		//conn = db.getCon();
		conn.setAutoCommit(false);
		if(conn!=null && idString!=null){			
			String condition = "delete from goodsinfo where id=?";
			ptst = conn.prepareStatement(condition);
			for (String id:idString){
				ptst.setString(1, id);
				number++;
				ptst.addBatch();
			}
			ptst.executeBatch();
			conn.commit();
		}
		}catch (Exception e){
			if (conn!=null){
				try{
					conn.rollback();
				}catch(SQLException ex){
					System.out.println("���ݻع�"+e);
				}
			}
		   System.out.println("����ɾ��"+e);
	}
	
	return number;
}
}