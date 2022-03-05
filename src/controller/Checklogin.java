package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import model.DBUtil;

/**
 * Servlet implementation class Checklogin
 */
@WebServlet("/CheckloginServlet")
public class Checklogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checklogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String type=request.getParameter("type");
		String loginname = request.getParameter("loginname").toString();
		String password = request.getParameter("password").toString();
		Statement stmt =null;
		Connection conn = DBUtil.getConnection();
		//PreparedStatement ptst = null;
		ResultSet rs = null;
		String sql = "";
		if("Administrator".equals(type))
		{
			try {
				if (conn != null) {
					sql = "select * from administrator where loginname='" + loginname + "' and password='" + password + "'";
					stmt= conn.createStatement ();
					rs=stmt.executeQuery(sql);
					if (rs.next()) {
						session.setAttribute("loginname", loginname);
						request.setCharacterEncoding("UTF-8");
						//request.getRequestDispatcher("index_Administrator.jsp").forward(request, response); 
						response.sendRedirect("index_Administrator.jsp");
					}
					else {					
						out.print("<script type='text/javascript'>alert('您输入的用户名或者密码有错误，请核实后重新输入！');</script>");
						out.print("<script type='text/javascript'>location.href='loginError.jsp'</script>");
						response.sendRedirect("loginErrorAdministrator.jsp"); //易报Cannot call sendRedirect() after the response has been committed错误
						/* 重定向 */
						/* response.sendRedirect("../login.jsp"); */
						request.setCharacterEncoding("UTF-8");
						//request.getRequestDispatcher("loginErrorAdministrator.jsp").forward(request, response); 
					}			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		//request.getRequestDispatcher("loginError.jsp").forward(request, response); 
		}
		else if("Customer".equals(type))
		{
			try {
				if (conn != null) {
					sql = "select * from customer where loginname='" + loginname + "' and password='" + password + "'";
					stmt= conn.createStatement ();
					rs=stmt.executeQuery(sql);
					if (rs.next()) {
						session.setAttribute("loginname", loginname);
						request.setCharacterEncoding("UTF-8");
						//request.getRequestDispatcher("index_Administrator.jsp").forward(request, response); 
						response.sendRedirect("GoodsInfoServlet?type=shoppingInit");
					}
					else {					
						out.print("<script type='text/javascript'>alert('您输入的用户名或者密码有错误，请核实后重新输入！');</script>");
						out.print("<script type='text/javascript'>location.href='loginError.jsp'</script>");
						response.sendRedirect("loginErrorCustomer.jsp"); //易报Cannot call sendRedirect() after the response has been committed错误
						/* 重定向 */
						/* response.sendRedirect("../login.jsp"); */
						request.setCharacterEncoding("UTF-8");
						//request.getRequestDispatcher("loginError.jsp").forward(request, response); 
					}			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		//request.getRequestDispatcher("loginError.jsp").forward(request, response); 
		}
		}
	}

