package reply.service;

import reply.dao.ReplyDao;
import reply.dao.ReplyDaoInf;
import reply.model.ReplyVO;

public class ReplyService implements ReplyServiceInf{

	private ReplyDaoInf dao = new ReplyDao();
	
	@Override
	public int insertReply(ReplyVO rvo) {
		return dao.insertReply(rvo);
	}

}
