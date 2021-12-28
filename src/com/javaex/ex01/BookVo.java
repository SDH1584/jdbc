package com.javaex.ex01;

public class BookVo {

	private int bookId;
	private String bookTitle;
	private String bookPubs;
	private String bookPubdate;
	private int boAuthorid;
	private String AuthorName;
	private String authorDesc;
	public BookVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookVo(int bookId, String bookTitle, String bookPubs, String bookPubdate, int boAuthorid, 
			String AuthorName, String authorDesc) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPubs = bookPubs;
		this.bookPubdate = bookPubdate;
		this.boAuthorid = boAuthorid;
		this.AuthorName = AuthorName;
		this.authorDesc = authorDesc;
	}
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookPubs=" + bookPubs + ", bookPubdate="
				+ bookPubdate + ", boAuthorid=" + boAuthorid + ", auAuthorid=" +  ", AuthorName="
				+ AuthorName + ", authorDesc=" + authorDesc + "]";
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookPubs() {
		return bookPubs;
	}
	public void setBookPubs(String bookPubs) {
		this.bookPubs = bookPubs;
	}
	public String getBookPubdate() {
		return bookPubdate;
	}
	public void setBookPubdate(String bookPubdate) {
		this.bookPubdate = bookPubdate;
	}
	public int getBoAuthorid() {
		return boAuthorid;
	}
	public void setBoAuthorid(int boAuthorid) {
		this.boAuthorid = boAuthorid;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String AuthorName) {
		this.AuthorName = AuthorName;
	}
	public String getAuthorDesc() {
		return authorDesc;
	}
	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}
	
}
