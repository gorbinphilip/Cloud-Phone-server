package com.virt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virt.Service.MasterService;
import com.virt.Service.SocketCreation;
import com.virt.Service.UpdateUsage;

/**
 * Servlet implementation class X86StartServlet
 */
@WebServlet("/X86StartServlet")
public class X86StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public X86StartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MasterService mstServ=new MasterService();
		UpdateUsage upUsage =new UpdateUsage();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("IN X86 Start Servlet");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				SocketCreation scc=new SocketCreation();
				scc.CreateSocketConn();		
			}
		}).start();
		//upUsage.UpdateDetail();
		out.write("1");
	}

}
