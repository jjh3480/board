package reply.model;

public class ReplyVO {
	private int comment_seq;
	private int comment_board_seq;
	private String comment_content;
	private String comment_mem_id;
	private String comment_del_yn;
	
	public int getComment_seq() {
		return comment_seq;
	}
	public void setComment_seq(int comment_seq) {
		this.comment_seq = comment_seq;
	}
	public int getComment_board_seq() {
		return comment_board_seq;
	}
	public void setComment_board_seq(int comment_board_seq) {
		this.comment_board_seq = comment_board_seq;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_mem_id() {
		return comment_mem_id;
	}
	public void setComment_mem_id(String comment_mem_id) {
		this.comment_mem_id = comment_mem_id;
	}
	public String getComment_del_yn() {
		return comment_del_yn;
	}
	public void setComment_del_yn(String comment_del_yn) {
		this.comment_del_yn = comment_del_yn;
	}
	
	
}
