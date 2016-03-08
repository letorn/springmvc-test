package init;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

public class WebFilter extends OncePerRequestFilter {
	
	private static Set<String> whiteSet = new HashSet<String>();

	static {
		whiteSet.add("/login.html");
		whiteSet.add("/login.do");
		whiteSet.add("/index.html");
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		String ctx = request.getContextPath();
		String uri = request.getRequestURI().substring(ctx.length());
		if ((uri.endsWith(".jsp") || uri.endsWith(".do")) && !whiteSet.contains(uri)) {
			HttpSession session = request.getSession();
			String admin = (String) session.getAttribute("admin");
			if (admin == null && false) {// 暂时关闭
				response.sendRedirect(ctx + "/login.html");
				return;
			}
		}
		chain.doFilter(request, response);
	}

}
