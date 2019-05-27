package com.yhz.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPage extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		Date now = new Date(); // Date & Time
		String page = "<html><body><p>" + now +"</p></body></html>";
		out.println(page);
	}
}
