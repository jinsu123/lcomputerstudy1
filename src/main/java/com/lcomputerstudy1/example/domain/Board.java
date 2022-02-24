package com.lcomputerstudy1.example.domain;

public class Board {
	private int bId;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bDatetime;
	private int bViewCount;
	
	public int getbViewCount() {
		return bViewCount;
	}
	public void setbViewCount(int bViewCount) {
		this.bViewCount = bViewCount;
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
