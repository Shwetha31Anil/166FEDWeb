package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", 
		"no-cache,no-store,must-revalidate");	//http 1.1
		response.setHeader("Pragma", "no-cache");// 1.0
		response.setHeader("Expires", "0");//proxies
		PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			try {
			ServletContext context=getServletContext();	
				out.print(context.getInitParameter("driver"));
				
			HttpSession session=request.getSession(false);
			String s=session.getAttribute("sname").toString();
			out.print("Profile page  "+s);
			RequestDispatcher rd=
					request.getRequestDispatcher("menu.html");
					rd.include(request, response);
			}catch(NullPointerException e) {
				out.print("Login first");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
					/*Cookie ck[]=request.getCookies();
			for(Cookie ck1:ck) {
				if(ck1.getName().equals("cname"))
					out.print("Profile page  "+ck1.getValue());
				RequestDispatcher rd=
						request.getRequestDispatcher("menu.html");
						rd.include(request, response);
			}*/
			//out.print("Profile page  ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
