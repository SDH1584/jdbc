package com.javaex.ex07;

public class BookVo {
	
	private int bookId;
	private String title;
	private String pubs;
	private String pubdate;
	private String authorId;
	private String authorDesc;
	public BookVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookVo(int bookId, String title, String pubs, String pubdate, String authorId, String authorDesc) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubdate = pubdate;
		this.authorId = authorId;
		this.authorDesc = authorDesc;
	}
	public BookVo(int bookId, String title, String pubs, String pubdate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubdate = pubdate;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPubs() {
		return pubs;
	}
	public void setPubs(String pubs) {
		this.pubs = pubs;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getAuthorDesc() {
		return authorDesc;
	}
	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubdate=" + pubdate
				+ ", authorId=" + authorId + ", authorDesc=" + authorDesc + "]";
	}

}
