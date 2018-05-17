package board.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import board.model.BoardPageVO;
import board.model.BoardVO;
import board.model.FilesVO;

public interface BoardServiceInf {
	/**
	 * 
	 * Method : getUserPageList
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "J.J.H"
	 * 변경이력 : 
	 * @param page
	 * @param pageSize
	 * @return 
	 * Method 설명 : 페이지를 세기위해 게시판 리스트 조회
	 */
	public Map<String, Object> getBoardPageList(int page, int pageSize, int boardCheck);
	
	/**
	 * 
	 * Method : getBoardList
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "J.J.H"
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 게시판리스트 조회
	 */
	public List<BoardVO> getBoardList(int category_seq);
	
	/**
	 * 
	 * Method : insertBoard
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "J.J.H"
	 * 변경이력 : 
	 * @param bvo 
	 * Method 설명 : 게시글 추가
	 */
	public int insertBoard(BoardVO bvo);
	
	/**
	 * 
	 * Method : insertBoard
	 * 최초작성일 : 2018. 5. 14.
	 * 작성자 : "J.J.H"
	 * 변경이력 : 
	 * @param fvo 
	 * Method 설명 : 파일 추가
	 */
	public int insertFile(String filePath);
	
	public List<BoardPageVO> searchBoard();
	
	public int insertBoardPage(BoardPageVO bpvo);

	public List<BoardVO> getBoard(int board_seq);
	
}
