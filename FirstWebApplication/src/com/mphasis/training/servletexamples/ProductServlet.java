package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductdaoImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
      productDao=new ProductdaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products=productDao.getAll();	
		HttpSession session1=request.getSession();
		session1.setAttribute("products", products);
		response.sendRedirect("products.jsp");
		
	/*	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");	//http 1.1
		response.setHeader("Pragma", "no-cache");// 1.0
		response.setHeader("Expires", "0");//proxies
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");*/
		//try {
		//HttpSession session=request.getSession(false);
		//String s=session.getAttribute("sname").toString();
		//out.print("Product page  "+s);
		//out.print("Session "+session.getLastAccessedTime());
		//out.print("Session "+session.getCreationTime());
		//session.setMaxInactiveInterval(30*30*30);
		/*RequestDispatcher rd=
				request.getRequestDispatcher("menu.html");
				rd.include(request, response);*/
	/*	List<Product> products=productDao.getAll();	
		HttpSession session1=request.getSession();
		session1.setAttribute("products", products);
		response.sendRedirect("products.jsp");*/
		/*ServletContext context=getServletContext();
		context.setAttribute("products", products);*/
//		out.print("<table border='1'>");
//		out.print("<tr><th>PID</th><th>PName</th><th>Cost</th>"
//				+ "<th>quntity</th><th>Buy</th></tr>");
//		for(Product p:products) {
//			out.print("<tr>");
//			out.print("<td>"+p.getPid()+"</td>");
//			out.print("<td>"+p.getPname()+"</td>");
//			out.print("<td>"+p.getCost()+"</td>");
//			out.println("<td>"+p.getQunatity()+"</td>");
//			out.print("<td>Buy</td>");
//			out.print("</tr>");
//		}
//		out.print("</table>");
//				
				
				
		/*}catch(NullPointerException e) {
		//	out.print("Login first");
			RequestDispatcher rd=
			request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}*/
		/*PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Cookie ck[]=request.getCookies();
		for(Cookie ck1:ck) {
			if(ck1.getName().equals("cname"))
				out.print("Product page  "+ck1.getValue());
			RequestDispatcher rd=
					request.getRequestDispatcher("menu.html");
					rd.include(request, response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
