package com.adacho.test01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	//source -> doGet()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		System.out.println("=================> doGet 메서드 호출");
	}
	

}
