package top.robotman.myblog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharsetFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(">>> push filter>>>>charcter ok");
		
		HttpServletRequest request = (HttpServletRequest)req;
		
		
		System.out.println(">>>>getCharacterEncoding>>>>>" + request.getCharacterEncoding());
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(req, resp);
		
		System.out.println(">>> pop filter>>>>charcter ok");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println(">>>>>>>>>> CharsetFilter init");
		
	}

}
