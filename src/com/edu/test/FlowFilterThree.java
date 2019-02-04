package com.edu.test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName = "timer", urlPatterns = "/third")
public class FlowFilterThree implements Filter {
	
	@Override
	public void init(FilterConfig config) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws java.io.IOException, ServletException {
		long startTime = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		System.out.println("수행 시간 : " + executeTime + " ms");
	}
	
	@Override
	public void destroy() {}
}
