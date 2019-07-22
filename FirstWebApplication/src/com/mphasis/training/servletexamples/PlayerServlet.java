package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.Player;
import com.mphasis.cart.beans.Product;
import com.mphasis.cart.bo.PlayerBO;
import com.mphasis.cart.bo.PlayerBOImpl;
import com.mphasis.cart.exceptions.BuissnessException;

/**
 * Servlet implementation class PlayerServlet
 */
@WebServlet("/Players")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PlayerBO playerBO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerServlet() {
    	playerBO=new PlayerBOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");	//http 1.1
		response.setHeader("Pragma", "no-cache");// 1.0
		response.setHeader("Expires", "0");//proxies
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
		HttpSession session=request.getSession(false);
		String s=session.getAttribute("sname").toString();
		out.print(s);
		RequestDispatcher rd=
				request.getRequestDispatcher("menu.html");
				rd.include(request, response);
		out.print("<br/><br/>");
				List<Player> players=playerBO.getAllPlayers();	
		out.print("<table border='1' width='100%'>");
		out.print("<tr style='background-color:green'><th>PID</th><th>Name</th><th>Age</th>"
				+ "<th>contact</th><th>Email</th>"
				+ "<th>Gender</th><th>Score</th>"
				+ "<th>TeamName</th><th>DOB</th><th>ADD</th></tr>");
		for(Player p:players) {
			out.print("<tr>");
			out.print("<td>"+p.getPid()+"</td>");
			out.print("<td>"+p.getName()+"</td>");
			out.print("<td>"+p.getAge()+"</td>");
			out.println("<td>"+p.getContact()+"</td>");
			out.println("<td>"+p.getEmail()+"</td>");
			out.println("<td>"+p.getGender()+"</td>");
			out.println("<td>"+p.getScore()+"</td>");
			out.println("<td>"+p.getTeamname()+"</td>");
			out.println("<td>"+p.getDob()+"</td>");
			out.print("<td><a>Add</a></td>");
			
		}
		out.print("</table>");
				
				
				
		}catch(NullPointerException e) {
			out.print("Login first");
			RequestDispatcher rd=
			request.getRequestDispatcher("login.html");
			rd.include(request, response);
		} catch (BuissnessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
