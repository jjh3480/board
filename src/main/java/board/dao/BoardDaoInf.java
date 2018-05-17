package board.dao;

import java.util.List;
import java.util.Map;

import board.model.BoardPageVO;
import board.model.BoardVO;
import board.model.FilesVO;

public interface BoardDaoInf {
	
	public List<BoardVO> getBoardPageList(int page, int pageSize, int boardCheck);
	
	public List<BoardVO> getBoardList(int category_seq);
	
	//게시글 추가
	public int insertBoard(BoardVO bvo);
	
	//게시판
	public List<BoardPageVO> getBoardPageList();
	
	//게시판추가
	public int insertBoardPage(BoardPageVO bpvo);

	public int getBoardTotalCnt(int boardCheck);
	
	public int insertFile(String filePath);
	
	// 게시글 찾기
	public List<BoardVO> getBoard(int board_seq);
}
