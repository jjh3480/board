package board.servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class InsertBoard
 */
@WebServlet("/insertBoard")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceInf board;
    private final String UPLOAD_PATH = "D:\\A_TeachingMaterial\\7.JspSpring\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\board\\upload";
    public InsertBoard() {
        super();
        board = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//해당게시판 시퀀스번호
		int check = Integer.parseInt(request.getParameter("bp_seq"));
		int result = 0;
		int fileResult = 0;
		BoardVO bvo = new BoardVO();
		
		bvo.setCategory_seq(check);
		bvo.setTitle(request.getParameter("title"));
		bvo.setContent(request.getParameter("content"));
		bvo.setReg_id((String)request.getSession().getAttribute("userId"));
		bvo.setDel_yn("N");

		Part profilePart = request.getPart("profile");
		
		String filePath = null;
		if(profilePart.getSize() > 0){
			filePath = UPLOAD_PATH + File.separator + UUID.randomUUID().toString();
			profilePart.write(filePath);
			profilePart.delete();
			result = board.insertBoard(bvo);
			fileResult = board.insertFile(filePath);
		}
		
		
		if(result > 0 && fileResult>0) {
			request.setAttribute("bp_seq", check);
			RequestDispatcher disp = request.getRequestDispatcher("/getBoardPageList");
			disp.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
