package com.edu.test;

import java.io.IOException;

import javax.servlet.*;

public class FlowFilterTwo implements Filter {
	String charset; // web.xml에서 설정한 인코딩 문자코드를 가져오기 위함 
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init() 호출 ....... two");
		charset = config.getInitParameter("en");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding(charset);
		System.out.println("doFilter() 호출 전 ....... two");
		chain.doFilter(req, resp);
		System.out.println("doFilter() 호출 후 ....... two");		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출 ....... two");		
	}
}
