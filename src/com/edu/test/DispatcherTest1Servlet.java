/*
 * RequestDispatcher의 forward 메소드는 req와 resp를 다른 자원에 전달하고 완전히 수행제어를 넘겨서 
 * 다른 자원의 수행결과를 클라이언트로 응답하도록 하는 기능의 메소드이다. 
 * Client -> 요청 페이지 -> 포워딩 페이지 -> Client(응답)
 * 
 * include 메소드는 req와 resp를 다른 자원에 전달하고 수행한 다음, 
 * 그 결과를 클라이언트에서 요청한 서블릿 내에 포함하여 클라이언트로 응답하는 메소드.
 */

package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/dispatcher1")
public class DispatcherTest1Servlet extends HttpServlet {
		
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>Dispatcher Test1의 수행결과</h3>");
		
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");
		
		//rd.forward(req, resp);
		rd.include(req, resp); 
		
		
		out.close();
	}
}