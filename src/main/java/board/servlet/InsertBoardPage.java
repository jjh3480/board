package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardPageVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class InsertBoard
 */
@WebServlet("/insertBoardPage")
public class InsertBoardPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private BoardServiceInf service;
    public InsertBoardPage() {
        super();
        service = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		BoardPageVO bpvo = new BoardPageVO();
		bpvo.setBp_title(request.getParameter("bp_title"));
		bpvo.setBp_mem_id((String)request.getSession().getAttribute("userId"));
		int result = service.insertBoardPage(bpvo);

		if(result>0){
			List<BoardPageVO> boardPageList = service.searchBoard();
			
			HttpSession session = request.getSession();
			session.setAttribute("boardPageList", boardPageList);
			
			RequestDispatcher disp = request.getRequestDispatcher("main/main.jsp");
			disp.forward(request, response);
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("main/main.jsp");
			disp.forward(request, response);
		}
	}

}
