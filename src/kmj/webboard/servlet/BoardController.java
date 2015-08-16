package kmj.webboard.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kmj.webboard.model.UserVO;
import kmj.webboard.service.UserService;

/**
 * 
 * "/board/list"          -> list.jsp
 * "/board/view?id=39993" -> view.jsp    "39993 포스트입니다."
 * 
 * 
 */
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext ctx;
	private ServletConfig config;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        System.out.println("BoardController.init 메소드가 호출되었음");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	this.config = config;
    	ctx = config.getServletContext();
    	
    	String filepath = (String) ctx.getAttribute("board.db");
    	
    	ServletContextListener scl = null;
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[doGet]클라이언트로부터 요청이 들어왔음");
		String uri = request.getRequestURI();
		System.out.println("GET uri: " + uri);
		
		if ( uri.endsWith("/join")) { //  /WebBoard/board/join
			ctx.getRequestDispatcher("/join.jsp").forward(request, response);
		} else if ( uri.endsWith("/yes")) {
			System.out.println("/yes 요청");
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/yes.jsp").forward(request, response);
		} else if (uri.endsWith("/users")){
			System.out.println("/users 요청");
			List<UserVO> users = null;
			
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/listAllusers.jsp").forward(request, response);		
		}
		else {
			response.setHeader("Content-Type", "text/html; charset=UTF-8");
			response.getWriter().write("unknown uri: " + uri);
			response.flushBuffer();
		}
	}

	/**
	 * RESTful uri로 구성: 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[doPost]클라이언트로부터 요청이 들어왔음");
		String uri = request.getRequestURI();
		System.out.println("POST uri: " + uri);
		if (uri.endsWith("/doJoin")) {
			// 회원 가입 정보가 넘어오고 있음.
			/*
			 *    method   uri
			 *    -------  ---------------           
			 *    POST     /board/doJoin 
			 *    -------------------------
			 *    
			 *    request body
			 *    -------------------------
			 *    key            value
			 *    -------------------------
			 *    userid          길이: 6~10
			 *    emial           길이: [6~], '@'가 있어야함.
			 *    pass            길이: [8~12]
			 *    ---------------------------
			 *       
			 */

			request.setCharacterEncoding("UTF-8");
			 
			String userId = request.getParameter("userid");
			String userEmail = request.getParameter("email");
			String password = request.getParameter("pass");
			
			 
			
			System.out.println(String.format("userId:%s, password:%s", userId,
					password));

			UserService service = new UserService();
			UserVO user = service.insertNewUser(userId, userEmail, password);
			
			request.setAttribute("user", user);
			ctx.getRequestDispatcher("/join-ok.jsp").forward(request, response);
			

		} else {
			response.setHeader("Content-Type", "text/html; charset=UTF-8");
			response.getWriter().write("unknown uri: " + uri);
			response.flushBuffer();
		}
	}

}
