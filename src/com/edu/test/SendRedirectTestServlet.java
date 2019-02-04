/*
 * HttpServletResponse 객체의 sendRedirect 메소드는 
 * 다른 페이지로 이동할 수 있는 메소드이며, 
 * 현재 서버가 아닌 다른 서버의 자원으로도 이동할 수 있다. 
 */

package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/portalSite")
public class SendRedirectTestServlet extends HttpServlet {
		
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("site");
		if(param.equals("naver")) {
			resp.sendRedirect("http://www.naver.com");
		} else if(param.equals("daum")) {
			resp.sendRedirect("http://www.daum.net");
		} else if(param.equals("zum")) {
			resp.sendRedirect("http://zum.com");
		} else if(param.equals("google")) {
			resp.sendRedirect("http://www.google.com");
		}

	}
}