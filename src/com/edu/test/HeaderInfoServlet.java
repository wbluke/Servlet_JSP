package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/headerInfo")
public class HeaderInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>요청 헤더 정보</h3>");
		Enumeration<String> em = req.getHeaderNames();
		while(em.hasMoreElements()) {
			String s = em.nextElement();
			out.print(s + " : " + req.getHeader(s) + "<br/>");
		}
		out.print("</body></html>");
		out.close();
	}
}

//요청 헤더 정보
//
//host : localhost:8080
//connection : keep-alive
//upgrade-insecure-requests : 1
//accept : text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//user-agent : Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_2) AppleWebKit/605.1.15 (KHTML, like Gecko) Safari/522.0
//accept-language : en-us
//cache-control : no-cache
//accept-encoding : gzip, deflate