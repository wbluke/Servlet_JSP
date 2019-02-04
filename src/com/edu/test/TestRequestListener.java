package com.edu.test;

import javax.servlet.*;

public class TestRequestListener implements ServletRequestListener {
	public TestRequestListener() {
		System.out.println("TestRequestListener 객체 생성");
	}
	
	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("HttpServlerRequest 객체 초기화");
	}
	
	public void requestDestroyed(ServletRequestEvent e) {
		System.out.println("HttpServletRequest 객체 해제");
	}
}
