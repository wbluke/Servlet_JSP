/*
 * 세션 트래킹 기능 : 클라이언트마다 상태정보를 일정 시간 동안 개별적으로 유지하여 사용하는 기술 
 * 세션 트래킹의 구현 순서 
 * 1. 클라이언트를 위한 세션을 준비한다. 이전에 이 클라이언트를 위해 생성된 세션이 이미 존재하면 존재하는 세션을 추출하고, 
 * 그렇지 않으면 새로 생성한다. 세션이 새로 생성될 때는 고유한 ID가 하나 부여되며, 이 ID는 클라이언트에 쿠키 기술로 저장된다. 
 * 2. 유지하고자 하는 정보를 저장할 목적의 객체를 생성하여 세션에 등록한다. 
 * 3. 클라이언트가 요청을 전달할 때마다 세션에 등록된 정보를 담고 있는 객체를 추출하여 원하는 기능에 사용한다. 
 * 4. 세션이 더 이상 필요없는 시점에서 세션을 삭제한다. 
 */

package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String param = req.getParameter("p");
		String msg = null;
		HttpSession session = null;
		
		if(param.equals("create")) {
			session = req.getSession();
			if(session.isNew()) {
				msg = "새로운 세션 객체가 생성됨";
			}else {
				msg = "기존의 세션 객체가 리턴됨";
			}
		}else if(param.equals("delete")) {
			session = req.getSession(false); // 세션이 존재하지 않을 시 null 반환 
			if(session != null) {
				session.invalidate();
				msg = "세션 객체 삭제 작업 완료";
			}else {
				msg = "삭제할 세션 존재하지 않음";
			}
		}else if(param.equals("add")) {
			session = req.getSession(true); // 세션이 존재하지 않을 시 새 HttpSession 객체 생성 후 반환 
			session.setAttribute("msg", "메시지입니다");
			msg = "세션 객체에 데이터 등록 완료";
		}else if(param.equals("get")) {
			session = req.getSession(false);
			if(session != null) {
				String str = (String)session.getAttribute("msg");
				msg = str;
			}else {
				msg = "데이터를 추출할 세션 객체 존재하지 않음";
			}
		}else if(param.equals("remove")) {
			session = req.getSession(false);
			if(session != null) {
				session.removeAttribute("msg");
				msg = "세션 객체의 데이터 삭제 완료";
			}else {
				msg = "데이터를 삭제할 세션 객체 존재하지 않음";
			}
		}else if(param.equals("replace")) {
			session = req.getSession();
			session.setAttribute("msg", "새로운 메시지입니다");
			msg = "세션 객체에 데이터 등록 완료";
		}
		
		out.print("처리 결과 : " + msg);		
		out.close();
	}
}
