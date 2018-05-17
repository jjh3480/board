package login.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardPageVO;
import board.service.BoardService;
import board.service.BoardServiceInf;
import login.model.LoginVO;
import login.service.LoginService;
import login.service.LoginServiceInf;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/loginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginServiceInf login;
    private BoardServiceInf board;
    
    public LoginUser() {
        super();
        login = new LoginService();
        board = new BoardService();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalStateException {
		
		String id = request.getParameter("userId");
		String userPassword = request.getParameter("password");
		
		LoginVO userCheck = login.LoginCheck(id);
		List<BoardPageVO> boardPageList = board.searchBoard();
		boolean result = false;
		
		if(userCheck != null && userCheck.getMem_pass().equals(userPassword)){
			result = true;
		}
		
		if(result == true){
			HttpSession sessionId = request.getSession();
			sessionId.setAttribute("userId", id);
			
			HttpSession session = request.getSession();
			session.setAttribute("boardPageList", boardPageList);
			
			RequestDispatcher login = request.getRequestDispatcher("main/main.jsp");
			
			login.forward(request, response);
		} else {
			response.sendRedirect("login/login.jsp");
		}
		
	}

}
