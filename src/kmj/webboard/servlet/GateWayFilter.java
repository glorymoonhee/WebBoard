package kmj.webboard.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class GateWayFilter
 * 
 * - URLRewritingFilter
 * 
 */
public class GateWayFilter implements Filter {
	private ServletContext ctx;
       
    /**
     * Default constructor. 
     */
    public GateWayFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("이것은 필터입니다.");
		HttpServletRequest req = (HttpServletRequest) request; // why? 설계 미스!
		String path = stripURI(req.getRequestURI());
	
		System.out.println("잘린 uri   " + path);
		
		if ( path.equals("") || path.equals("/")) {
			path = "/index.jsp";
		}
		
		if ( path.endsWith(".jsp") || path.endsWith(".html") || path.startsWith("/static") || path.equals("")) {
			
			System.out.println(". DefaultServlet으로 넘겨야 합니다.");
			chain.doFilter(request, response);
		}else{
		    	System.out.println("jsp 요청입니다. /board로 넘긴다.");
		    	path = "/board" + path ; // url rewriting
		    	req.getRequestDispatcher(path).forward(request,response);
		}
	}
	
	private String stripURI(String requestURI) {
		 String ctxpath = ctx.getContextPath(); // /WebBoard
        String uri = requestURI;
        String path = uri.substring(ctxpath.length()).trim();

		return path;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	  
    	ctx = fConfig.getServletContext();
	}

}
