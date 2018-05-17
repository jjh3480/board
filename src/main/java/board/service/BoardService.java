package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardPageVO;
import board.model.BoardVO;
import board.model.FilesVO;

public class BoardService implements BoardServiceInf {
	
	private BoardDaoInf dao = new BoardDao();
	
	@Override
	public Map<String, Object> getBoardPageList(int page, int pageSize, int boardCheck) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("page", page);
		resultMap.put("pageSize", pageSize);
		resultMap.put("boardseq", boardCheck);
		
		List<BoardVO> boardList = dao.getBoardPageList(page, pageSize, boardCheck);
		int boardTotalCnt = dao.getBoardTotalCnt(boardCheck);
		String pageNav = makePageNav(page, boardTotalCnt, boardCheck);
		
		resultMap.put("boardList", boardList);
		resultMap.put("pageNav", pageNav);
		return resultMap;
	}
	
	private String makePageNav(int page, int boardTotalCnt, int boardCheck) {
		if(boardTotalCnt == 0 ){
			boardTotalCnt = 1;
		}
		int pageTotalCnt = (int)Math.ceil( (double)(boardTotalCnt)/10);
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("	<ul class=\"pagination\">");
		pageNav.append("		<li>");
		pageNav.append("			<a href=\"getBoardPageList\" aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span></a>");
		pageNav.append("		</li>");
		
		for(int i=1; i<=pageTotalCnt; i++){
			if(page == i){
				pageNav.append("		<li class='active'><a href=\"getBoardPageList?page="+i+"&pageSize=10\">"+ i +"</a></li>");
			}else{
				pageNav.append("		<li><a href=\"getBoardPageList?page="+i+"&pageSize=10\">"+ i +"</a></li>");
			}
		}
		pageNav.append("		<li><a href=\"getBoardPageList?page="+pageTotalCnt+"&pageSize=10\" aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span></a></li>");
		pageNav.append("	</ul>");
		pageNav.append("</nav>");
	
		return pageNav.toString();
	}

	/**
	 * 
	 * Method : getBoardList
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "J.J.H"
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 게시글을 찾는 메서드
	 */
	@Override
	public List<BoardVO> getBoardList(int category_seq) {
		return dao.getBoardList(category_seq);
	}
	
	/**
	 * 
	 * Method : searchBoard
	 * 최초작성일 : 2018. 5. 15.
	 * 작성자 : "J.J.H"
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 게시판들을 읽어서 left리스트에 쏴주기
	 */
	@Override
	public List<BoardPageVO> searchBoard(){
		return dao.getBoardPageList();
	}
	
	

	@Override
	public int insertBoard(BoardVO bvo) {
		return dao.insertBoard(bvo);
	}

	@Override
	public int insertBoardPage(BoardPageVO bpvo) {
		return dao.insertBoardPage(bpvo);
	}

	@Override
	public int insertFile(String filePath) {
		return dao.insertFile(filePath);
	}

	@Override
	public List<BoardVO> getBoard(int board_seq) {
		return dao.getBoard(board_seq);
	}


}
