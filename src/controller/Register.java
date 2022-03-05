package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.CustomerDao;
import model.Customer;




@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String result;
		boolean rs;
		Customer C;
		CustomerDao CD;
		String id=request.getParameter("id");
		String loginname=request.getParameter("loginname");
		String password=request.getParameter("password");
		C=new Customer();
		C.setID(id);
		C.setLoginname(loginname);
		C.setPassword(password);
		CD=new CustomerDao();
		rs=CD.insertCustomer(C);
		if (rs) result="×¢²á³É¹¦";
		else result="×¢²áÊ§°Ü£¡";
		session.setAttribute("result", result);
		response.sendRedirect("RegisterR.jsp");
		//String condition;
		
	}

}
