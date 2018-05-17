package board.model;

import java.util.Date;

public class BoardPageVO {
	
	private int bp_seq;
	private Date bp_dt;
	private String bp_yn;
	private String bp_mem_id;
	private String bp_title;
	
	
	public String getBp_title() {
		return bp_title;
	}
	public void setBp_title(String bp_title) {
		this.bp_title = bp_title;
	}
	public int getBp_seq() {
		return bp_seq;
	}
	public void setBp_seq(int bp_seq) {
		this.bp_seq = bp_seq;
	}
	public Date getBp_dt() {
		return bp_dt;
	}
	public void setBp_dt(Date bp_dt) {
		this.bp_dt = bp_dt;
	}
	public String getBp_yn() {
		return bp_yn;
	}
	public void setBp_yn(String bp_yn) {
		this.bp_yn = bp_yn;
	}
	public String getBp_mem_id() {
		return bp_mem_id;
	}
	public void setBp_mem_id(String bp_mem_id) {
		this.bp_mem_id = bp_mem_id;
	}

}
