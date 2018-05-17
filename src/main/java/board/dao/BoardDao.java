package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardPageVO;
import board.model.BoardVO;
import board.model.FilesVO;

public class BoardDao implements BoardDaoInf {

	private SqlSessionFactory sqlSessionFactory;
	
	
	public BoardDao() {
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardVO> getBoardPageList(int page, int pageSize, int boardCheck) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("page", page);
		pageMap.put("pageSize", pageSize);
		pageMap.put("bp_seq", boardCheck);
		
		List<BoardVO> boardList = sqlSession.selectList("board.getBoardPageList", pageMap);
		sqlSession.close();
		
		return boardList;
	}

	@Override
	public int getBoardTotalCnt(int boardCheck) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int BoardTotalCnt = sqlSession.selectOne("board.getBoardTotalCnt", boardCheck);
		sqlSession.close();
		return BoardTotalCnt;
	}
	@Override
	public List<BoardVO> getBoardList(int category_seq) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BoardVO> boardList = sqlSession.selectList("board.getBoardList", category_seq);
		sqlSession.close();
		return boardList;
	}

	@Override
	public int insertBoard(BoardVO bvo) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int result = sqlSession.insert("board.insertBoard", bvo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public List<BoardPageVO> getBoardPageList() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<BoardPageVO> boardPageList = sqlSession.selectList("boardpage.getBoardPage");
		sqlSession.close();
		return boardPageList;
	}

	@Override
	public int insertBoardPage(BoardPageVO bpvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.insert("boardpage.insertBoardPage", bpvo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int insertFile(String filePath) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.insert("files.insertFiles", filePath);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public List<BoardVO> getBoard(int board_seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardVO> boardList = sqlSession.selectList("board.getBoard", board_seq);
		sqlSession.close();
		return boardList;
	}

	

}
