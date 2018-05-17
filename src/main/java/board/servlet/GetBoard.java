package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class getBoard
 */
@WebServlet("/getBoard")
public class GetBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceInf board;
    
    public GetBoard() {
        super();
        board = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		List<BoardVO> boardList = board.getBoard(Integer.parseInt(request.getParameter("board_seq")));
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher disp = request.getRequestDispatcher("board/getboard.jsp");
		disp.forward(request, response);
	}

}
