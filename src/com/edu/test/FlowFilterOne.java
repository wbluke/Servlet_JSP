/*
 * Filter : javax.servlet.Filter 인터페이스를 상속받고, 아래의 메소드들을 오버라이딩.
 * 로그기록, 한글처리와 같은 곳에 객체지향적으로 분리하여 적용 
 * 
 * FilterChain 객체는 web.xml 파일에서 모든 <filter-mapping> 태그에 관한 정보를 갖고 있다. 
 *  => chain.doFilter() 는 자기자신 다음에 실행할 메소드를 실행하는 역할. (다음 필터 혹은 servlet이 실행)
 */

package com.edu.test;

import java.io.IOException;

import javax.servlet.*;

public class FlowFilterOne implements Filter {
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init() 호출 ....... one");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter() 호출 전 ....... one");
		chain.doFilter(req, resp);
		System.out.println("doFilter() 호출 후 ....... one");		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출 ....... one");		
	}
}
