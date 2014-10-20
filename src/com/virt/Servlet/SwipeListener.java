package com.virt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.AdbCommandUtil;

/**
 * Servlet implementation class SwipeListener
 */
@WebServlet("/SwipeListener")
public class SwipeListener extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SwipeListener() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String x1=request.getParameter("x1axis");
		String y1=request.getParameter("y1axis");
		
		String x2=request.getParameter("x2axis");
		String y2=request.getParameter("y2axis");
		
		AdbCommandUtil adbutil=new AdbCommandUtil();
		adbutil.commandSwipe(x1, y1, x2, y2);
		System.out.println("IN Swipe Listen Servlet");
		out.write("1");
	}

}
