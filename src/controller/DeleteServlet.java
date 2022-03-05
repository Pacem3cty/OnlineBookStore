package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GoodsInfo;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		ArrayList<GoodsInfo> goodsinfoList = (ArrayList<GoodsInfo>) session.getAttribute("goodsinfoList");
		GoodsInfo GI = null;
		int num = 0;
		int sumnum = 0;
		String id = request.getParameter("id");//��ȡ��Shopping.jsp������request�����е�ID��	
		if(id!=null)
		{// ��ID�Ų�Ϊ�յ�����£���ȡSession�����еĹ��ﳵ��Ϣ��������Ϣ������Book�б���
			if(GI!=null)
			{
				num = GI.getNum()-1;
			}
			sumnum=Integer.parseInt((String)session.getAttribute("sumnum"));
			if(goodsinfoList!=null)
			{
				for(int i=0;i<goodsinfoList.size();i++)
				{
					GI = goodsinfoList.get(i);
					if(id.equals(GI.getId()))
					{// �ҵ�Book�б�����ID��Ӧ��Book���󣬽�������bookNum���ּ�1
						num = GI.getNum()-1;
						goodsinfoList.get(i).setNum(num);
					}
				}
			}
		}
		session.setAttribute("goodsinfoList", goodsinfoList);
		session.setAttribute("sumnum", String.valueOf(sumnum-1));// ������д��session������ȥ
		response.sendRedirect("Cart.jsp");// ��ת
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}