package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/second")  // 서블릿 실행을 위한 URI를 "/second"로 설정 
public class SecondServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("SecondServlet!");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Test</title></head>");
		out.print("<body><h1>have a nice day!!</h1></body>");
		out.print("</html>");
		out.close();
	}
}
