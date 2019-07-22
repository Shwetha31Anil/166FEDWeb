package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductdaoImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductDao productDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
    	productDao=new ProductdaoImpl();
       // super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	String pid=request.getParameter("pid");
	System.out.println(pid);
	if(pid.isEmpty()) {
		String pname=request.getParameter("pname");
	double c=Double.parseDouble(request.getParameter("cost"));
	int q=Integer.parseInt(request.getParameter("qty"));
	
	
		Product p=new Product();
		p.setPname(pname);
		p.setCost(c);
		p.setQuantity(q);
		productDao.addProduct(p);
		List<Product> products=productDao.getAll();	
		HttpSession session1=request.getSession();
		session1.setAttribute("products", products);
		response.sendRedirect("products.jsp");
	}else{
		String name=request.getParameter("pname");
		double c=Double.parseDouble(request.getParameter("cost"));
		int q=Integer.parseInt(request.getParameter("qty"));
		int id= Integer.parseInt(pid);
	int i=productDao.updateProduct(id, c, q,name);
		if(i>0) {
			ServletContext context=getServletContext();
		context.setAttribute("message", "updated success");
		List<Product> products=productDao.getAll();	
		HttpSession session1=request.getSession();
		session1.setAttribute("products", products);
		response.sendRedirect("products.jsp");
		}else {
			out.print("Problem with values");
			RequestDispatcher rd=request.getRequestDispatcher("addProducts.jsp");
		rd.include(request, response);	
		}
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
