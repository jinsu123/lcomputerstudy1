package com.lcomputerstudy1.example.domain;

public class Pagination {
	private int count; 
	private int page=1;     
	private int pageNum;  
	private int startPage;
	private int endPage; 
	private int lastPage;
	private int prevPage;
	private int nextPage;
	public static final int pageUnit=5;  
	public static final int perPage=5;   
	Search search;

	public Pagination() {
	}
	
	public void init() {		
				
		pageNum = (page-1)*perPage;
		startPage =((page-1)/pageUnit)*pageUnit+1;
		lastPage = (int)Math.ceil(count / (float)perPage);
		endPage = startPage+pageUnit-1;
		endPage = endPage < lastPage ? endPage : lastPage;
		prevPage=(startPage-1);
		nextPage=(startPage+pageUnit);
		
	}
	
	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public static int getPageunit() {
		return pageUnit;
	}
	public static int getPerpage() {
		return perPage;
	}

	
}
