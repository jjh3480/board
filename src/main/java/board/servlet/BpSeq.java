package board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bpSeq")
public class BpSeq extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BpSeq() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("bp_seq"));
		request.setAttribute("bp_seq", request.getParameter("bp_seq"));
		
		RequestDispatcher disp = request.getRequestDispatcher("board/boardInsert.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
