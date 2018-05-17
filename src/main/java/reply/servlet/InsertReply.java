package reply.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyVO;
import reply.service.ReplyService;
import reply.service.ReplyServiceInf;

@WebServlet("/insertReply")
public class InsertReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReplyServiceInf service;
    
    public InsertReply() {
        super();
        service = new ReplyService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setComment_content(request.getParameter("content"));
		rvo.setComment_board_seq(Integer.parseInt(request.getParameter("board_seq")));
		rvo.setComment_mem_id(request.getParameter("reg_id"));
		rvo.setComment_del_yn("N");
		
		int result = service.insertReply(rvo);
		
		if(result > 0){
			RequestDispatcher disp = request.getRequestDispatcher("board/getBoard.jsp");
			disp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
