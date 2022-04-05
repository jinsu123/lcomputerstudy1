package com.lcomputerstudy1.example.domain;

public class Auth {

	private String uId;
	private String uAuth;
	private int uIdx;
	
	
	
	
	public int getuIdx() {
		return uIdx;
	}
	public void setuIdx(int uIdx) {
		this.uIdx = uIdx;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuAuth() {
		return uAuth;
	}
	public void setuAuth(String uAuth) {
		this.uAuth = uAuth;
	}
}
