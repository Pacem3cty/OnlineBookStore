package dao;

import java.sql.*;
import java.util.*;

import model.DBUtil;
import model.GoodsInfo;
/*
 * 具体实现对GoodsInfoDao表数据库操作的方法类
 */
public class GoodsInfoDao implements GoodsInfoDaoI
{//继承GoodsInfoDao接口并实现其定义的所有方法
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
	//将使用的对象都进行回收
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
	
	// 查询所有记录
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
			System.out.println("全部查询"+e);
		} finally {
			closeAll();	
		}
		return goodsinfoList;
	}

	// 根据名称模糊查找记录
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
			System.out.println("单个查询"+e);
		} finally {
			closeAll();	
		}
		return goodsinfoList;
	}

	// 插入记录
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

	// 更新记录
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
			    System.out.println("修改数据失败");
			    flag = false;
		} finally {
			closeAll();
		}
		return flag;
	}

	// 根据id号查找记录，找到的话返回GoodsInfo对象
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
	
	// 根据id号查找记录（用于修改数据时获取id）
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
			System.out.println("商品编号查询失败");
		} finally {
				closeAll();
		}
		return GI;
	}
	
	// 根据id号删除记录，根据删除结果返回布尔值
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
	//删除多条记录 未使用
	public int delByIdS(String[] idString) {
	int number=0;//删除行
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
					System.out.println("数据回滚"+e);
				}
			}
		   System.out.println("批量删除"+e);
	}
	
	return number;
}
}