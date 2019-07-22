package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartAUserBo cartAUserBo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	cartAUserBo=new CartAUserBoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 

			HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");	//http 1.1
		response.setHeader("Pragma", "no-cache");// 1.0
		response.setHeader("Expires", "0");//proxies
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		String pass=request.getParameter("pwd");
		CartAUser user=cartAUserBo.login(name, pass);
		try {
		if(user.getEmail().equals(name) &&
				user.getPassword().equals(pass)) {
			out.print("Welcome   "+name+"<br/> ");
	   		RequestDispatcher rd=
			request.getRequestDispatcher("menu.html");
			rd.include(request, response);
			//out.print("Ur rewritting");
			//out.print("<a href='ProfileServlet?uname="+name+"'>Profile</a>");
			//Cookie
			//	Cookie ck=new Cookie("cname", name);
			//	response.addCookie(ck);
			//HttpSession
		HttpSession session=request.getSession();
		session.setAttribute("sname", name);
		}
		}catch(Exception e) {
			out.print("invalid");
			response.sendRedirect("login.html");
//		RequestDispatcher rd=
//		request.getRequestDispatcher("login.html");
//		rd.include(request, response);
			
		}
	}

}
