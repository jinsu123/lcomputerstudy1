package com.lcomputerstudy1.example.domain;

public class Board {
	private int bId;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bDatetime;
	private int bViewcount;
	private int u_idx;
	User user;
	
	
	public int getU_idx() {
		return u_idx;
	}

	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getbViewCount() {
		return bViewcount;
	}
	public void setbViewCount(int bViewCount) {
		this.bViewcount = bViewCount;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbDatetime() {
		return bDatetime;
	}
	public void setbDatetime(String bDatetime) {
		this.bDatetime = bDatetime;
	}
	

}
