package board.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardPageList
 */
@WebServlet("/getBoardPageList")
public class BoardPageList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceInf boardGetList;
    public BoardPageList() {
        super();
        boardGetList = new BoardService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String pageResult = request.getParameter("page");
		int page = (int) (pageResult == null ? 1 : request.getParameter("page"));
		
		String pageSizeResult = request.getParameter("pageSize");
		int pageSize = (int) (pageSizeResult == null ? 10 : request.getParameter("pageSize"));
		int boardCheck = Integer.parseInt(request.getParameter("bp_seq"));
		
		
		Map<String, Object> resultPage = boardGetList.getBoardPageList(page, pageSize, boardCheck);
		
		request.setAttribute("boardList", resultPage.get("boardList"));
		request.setAttribute("pageNav", resultPage.get("pageNav"));
		request.setAttribute("boardCheck", boardCheck);
		
		RequestDispatcher disp = request.getRequestDispatcher("board/boardList.jsp");
		disp.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
}
