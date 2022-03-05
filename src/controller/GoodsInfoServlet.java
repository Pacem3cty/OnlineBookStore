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
		//��ȡҳ�洫���Ĳ�������
		String type=request.getParameter("type");
		session.setAttribute("sumnum", String.valueOf(num));
		//typeΪsearchname��ʾ������������ģ����ѯ		
		if ("searchname".equals(type))
		{
			String name=request.getParameter("name");
			System.out.println("1:"+name);
			List<GoodsInfo> query=new ArrayList<GoodsInfo>();
			int line=0;
			if (name!=null && !("".equals(name)))
			{
			//����GoodsInfoDAO�еķ���SearchByName����ѯ��¼
				GoodsInfoDao GID=new GoodsInfoDao();
				query=GID.searchByName(name);
				line=query.size();
				//���õ��Ľ��List����session�У�����ʾҳ����е�����ʾ��
				request.setAttribute("query", query);
				request.setAttribute("line", line);
							
		    }		
		//ҳ����ת
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
			//����GoodsInfoDAO�еķ���SearchById����ѯ��¼
				GoodsInfoDao GID=new GoodsInfoDao();
				query=GID.searchById(ids);
				line=query.size();
				//���õ��Ľ��List����session�У�����ʾҳ����е�����ʾ��
				request.setAttribute("query", query);
				request.setAttribute("line", line);
			}
			request.getRequestDispatcher("ConditionsQueryR.jsp").forward(request, response);
		}	
		//typeΪmodify1Ϊ��һ�θ��£�������id�ҵ�Ҫ���µļ�¼,��
		else if ("modify1".equals(type)){ 
			String id=request.getParameter("id");
			System.out.println("id:"+id);
			session.setAttribute("id", id);
			GoodsInfoDao GID=new GoodsInfoDao();
			GoodsInfo GI=GID.searchByIdForUpdate(id);//typeΪmodify1Ϊ��һ�θ��£�������id�ҵ�Ҫ���µļ�¼,��
			session.setAttribute("GI", GI);
			response.sendRedirect("Update.jsp");	
		}
		//typeΪmodify2Ϊ�ڶ��θ��£���Ҫ���µ�GoodsInfo�����滻��Ӧ��¼,��
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
		//typeΪɾ����������id�ҵ�Ҫɾ���ļ�¼��
		else if ("del".equals(type)){			
			String id=request.getParameter("id");
			System.out.println("id:"+id);
			GoodsInfoDao GID=new GoodsInfoDao();
			boolean rs=GID.deleteById(id);
			if (rs)	response.sendRedirect("InfoQueryAll.jsp");
			else response.sendRedirect("UpdateError.jsp");
		}
		//typeΪadd��ʾ��ӣ���ʹ��GoodsInfo������������һ����¼��
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
			if (rs) result="��¼��ӳɹ�";
			else result="�����������û����ӳɹ�";
			session.setAttribute("result", result);
			response.sendRedirect("AddInfoR.jsp");
		}
		//typeΪsearchallInit��ʾΪȫ����ѯҳ���ʼ������
		else if("searchallInit".equals(type))
		{
			GoodsInfoDao GID=new GoodsInfoDao();
			List<GoodsInfo> goodsinfoList=GID.queryAllResult();
			session.setAttribute("goodsinfoList", goodsinfoList);
			response.sendRedirect("QueryAll.jsp");
		}
		
		//typeΪinfoqueryallInit��ʾΪɾ����Ϣҳ���ʼ������
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

