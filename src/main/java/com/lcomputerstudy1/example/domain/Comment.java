package com.lcomputerstudy1.example.domain;

public class Comment {
	
	private int cIdx;
	private String cContent;
	private String cDatetime;
	private int cGroup;
	private int cOrder;
	private int cDepth;
	private int uIdx;
	private int bId;
	
	
	
	public int getcIdx() {
		return cIdx;
	}
	public void setcIdx(int cIdx) {
		this.cIdx = cIdx;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public String getcDatetime() {
		return cDatetime;
	}
	public void setcDatetime(String cDatetime) {
		this.cDatetime = cDatetime;
	}
	public int getcGroup() {
		return cGroup;
	}
	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}
	public int getcOrder() {
		return cOrder;
	}
	public void setcOrder(int cOrder) {
		this.cOrder = cOrder;
	}
	public int getcDepth() {
		return cDepth;
	}
	public void setcDepth(int cDepth) {
		this.cDepth = cDepth;
	}
	public int getuIdx() {
		return uIdx;
	}
	public void setuIdx(int uIdx) {
		this.uIdx = uIdx;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}

}
