package model;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.*;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	
	private static final String DBURL = "jdbc:mysql://localhost:3306/JavaWeb?useUnicode=true&characterEncoding=UTF-8";
	
	private static final String DBUSER = "root";
	
	private static final String DBPASSWORD = "";
	
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	
	public DBUtil(){
		try{
	    	   Class.forName(DBDRIVER);
	       }catch(ClassNotFoundException ex){
	    	   throw new RuntimeException(ex);
	       }
	}
	public static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    /**
     * ����DataSource
     * @return 
     * @return 
     */
    private static void configDataSource(){
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/Javaweb?useUnicode=true&characterEncoding=UTF-8");
            dataSource.setUser("root");
            dataSource.setPassword("");
            dataSource.setInitialPoolSize(3);
            dataSource.setMaxPoolSize(10);
            dataSource.setMinPoolSize(3);
            dataSource.setAcquireIncrement(3);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    /**
     * ��ȡConnection����
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        configDataSource();
        try {
            conn = dataSource.getConnection();
            //System.out.print("���ݿ����ӳس�ʼ���ɹ�");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

	
	//��ͳ�����ݿ�����
	public Connection getCon() throws Exception {
		Connection conn=null;
		try{
			conn= DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		}catch(SQLException e){
			System.err.print(e);
		}		
		return conn;
	}
	
	//�������ݿ����ӳص�����
	public  Connection getDBCon()  {
		 DataSource ds = null;
		 Connection conn=null;
		  try{ 
		  InitialContext ctx=new InitialContext(); 
		  ds=(DataSource)ctx.lookup("java:comp/env/jdbc/JavaWeb"); 
		  conn = ds.getConnection(); 
		  }
		  catch (Exception e){
			  System.out.print("���ݿ����ӳ�"+e);
		  }
		  return conn;
	}
	public void closeCon(Connection conn) throws Exception {
		if(conn != null) {
			conn.close();
		}
	}
	
	public static void main(String []args) {
		//DBUtil dbUtil = new DBUtil();
		try {
			DBUtil.getConnection();
			//System.out.println("���ݿ����ӳس�ʼ���ɹ�");
			//dbUtil.getCon();
			//System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӳس�ʼ��ʧ��"+e);
		}
	}
}