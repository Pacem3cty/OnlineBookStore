package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodsInfoDao;
import model.*;

@WebServlet("/GoodsInfoServlet")
public class GoodsInfoServlet extends HttpServlet 
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		int num=0;
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		//获取页面传来的操作类型
		String type=request.getParameter("type");
		session.setAttribute("sumnum", String.valueOf(num));
		//type为searchname表示根据姓名进行模糊查询		
		if ("searchname".equals(type))
		{
			String name=request.getParameter("name");
			System.out.println("1:"+name);
			List<GoodsInfo> query=new ArrayList<GoodsInfo>();
			int line=0;
			if (name!=null && !("".equals(name)))
			{
			//调用GoodsInfoDAO中的方法SearchByName，查询记录
				GoodsInfoDao GID=new GoodsInfoDao();
				query=GID.searchByName(name);
				line=query.size();
				//将得到的结果List存入session中，供显示页面进行调用显示。
				request.setAttribute("query", query);
				request.setAttribute("line", line);
							
		    }		
		//页面跳转
		request.getRequestDispatcher("ConditionsQueryR.jsp").forward(request, response);
		}
		else if("searchid".equals(type))
		{
			String ids=request.getParameter("id");
			System.out.println("2:"+ids);
			List<GoodsInfo> query=new ArrayList<GoodsInfo>();
			int line=0;
			if (ids!=null && !("".equals(ids)))
			{
			//调用GoodsInfoDAO中的方法SearchById，查询记录
				GoodsInfoDao GID=new GoodsInfoDao();
				query=GID.searchById(ids);
				line=query.size();
				//将得到的结果List存入session中，供显示页面进行调用显示。
				request.setAttribute("query", query);
				request.setAttribute("line", line);
			}
			request.getRequestDispatcher("ConditionsQueryR.jsp").forward(request, response);
		}	
		//type为modify1为第一次更新，即根据id找到要更新的记录,。
		else if ("modify1".equals(type)){ 
			String id=request.getParameter("id");
			System.out.println("id:"+id);
			session.setAttribute("id", id);
			GoodsInfoDao GID=new GoodsInfoDao();
			GoodsInfo GI=GID.searchByIdForUpdate(id);//type为modify1为第一次更新，即根据id找到要更新的记录,。
			session.setAttribute("GI", GI);
			response.sendRedirect("Update.jsp");	
		}
		//type为modify2为第二次更新，将要更新的GoodsInfo对象替换对应记录,。
		else  if("modify2".equals(type)){
			boolean rs;
			GoodsInfo GI=new GoodsInfo();
			GoodsInfoDao GID=new GoodsInfoDao();			
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			double price=Double.parseDouble(request.getParameter("price"));
			System.out.println(id);
			System.out.println(name);
			System.out.println(price);
			GI.setID(id);
			GI.setName(name);
			GI.setPrice(price);
			System.out.println("update");
			rs=GID.updateGoodsInfo(GI);
			if (rs)	response.sendRedirect("InfoQueryAll.jsp");
			else response.sendRedirect("UpdateError.jsp");
		}
		//type为删除，即根据id找到要删除的记录。
		else if ("del".equals(type)){			
			String id=request.getParameter("id");
			System.out.println("id:"+id);
			GoodsInfoDao GID=new GoodsInfoDao();
			boolean rs=GID.deleteById(id);
			if (rs)	response.sendRedirect("InfoQueryAll.jsp");
			else response.sendRedirect("UpdateError.jsp");
		}
		//type为add表示添加，即使用GoodsInfo对象向表中添加一条记录。
		else if ("add".equals(type))
		{
			String result;
			boolean rs;
			GoodsInfo GI;
			GoodsInfoDao GID;
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			double price=Double.parseDouble(request.getParameter("price"));
			GI=new GoodsInfo();
			GI.setID(id);
			GI.setName(name);
			GI.setPrice(price);
			GID=new GoodsInfoDao();
			rs=GID.insertGoodsInfo(GI);
			if (rs) result="记录添加成功";
			else result="您输入的数据没有添加成功";
			session.setAttribute("result", result);
			response.sendRedirect("AddInfoR.jsp");
		}
		//type为searchallInit表示为全部查询页面初始化数据
		else if("searchallInit".equals(type))
		{
			GoodsInfoDao GID=new GoodsInfoDao();
			List<GoodsInfo> goodsinfoList=GID.queryAllResult();
			session.setAttribute("goodsinfoList", goodsinfoList);
			response.sendRedirect("QueryAll.jsp");
		}
		
		//type为infoqueryallInit表示为删改信息页面初始化数据
		else if("infoqueryallInit".equals(type))
		{
			GoodsInfoDao GID=new GoodsInfoDao();
			List<GoodsInfo> goodsinfoList=GID.queryAllResult();
			session.setAttribute("goodsinfoList", goodsinfoList);
			response.sendRedirect("InfoQueryAll.jsp");
		}
		
		else if("shoppingInit".equals(type))
		{
			GoodsInfoDao GID=new GoodsInfoDao();
			List<GoodsInfo> goodsinfoList=GID.queryAllResult();
			session.setAttribute("goodsinfoList", goodsinfoList);
			response.sendRedirect("index_Shopping.jsp");
		}
		
		else if("shopping".equals(type))
		{
			response.sendRedirect("index_Shopping.jsp");
		}
	}
}

