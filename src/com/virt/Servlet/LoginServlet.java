package com.virt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virt.Model.LoginModel;
import com.virt.Service.MasterService;
import com.virt.Service.SocketCreation;
import com.virt.Service.UsrLoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Login Servlet Do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubxt/html\
		int id=0;
		UsrLoginService usrSer=new UsrLoginService();
		LoginModel lgmod=new LoginModel();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("IN Login Servlet");
		lgmod.setUserName(request.getParameter("userName"));
		lgmod.setPassword(request.getParameter("password"));
		/*mstServ.startThread();*/
		 id=usrSer.LoginCheck(lgmod);
		 
		out.write(Integer.toString(id));
		
	}

}
