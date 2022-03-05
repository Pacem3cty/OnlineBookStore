package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;
import model.DBUtil;

public class CustomerDao 
{
	int  line;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ptst;
	public CustomerDao()
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
	public boolean insertCustomer(Customer C) {		
		boolean flag = false;
		try {
			conn = DBUtil.getConnection();
			//DBUtil db = new DBUtil();
			//conn = db.getCon();
			String condition = "insert into customer values(?,?,?)";
			ptst = conn.prepareStatement(condition);
			ptst.setString(1, C.getId());
			ptst.setString(2, C.getLoginname());
			ptst.setString(3, C.getPassword());		
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
}
