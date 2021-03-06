package com.javaex.ex05;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<BookVo> BookList;
		BookDao bookDao = new BookDao();
		
		//책 등록(insert)
		bookDao.bookInsert("우리들의 일그러진 영웅", "다림", "1998-02-22", 1);
		
		//책 등록(insert)
		bookDao.bookInsert("삼국지", "민음사", "2002-03-01", 1);
		
		//책 출력(select)
		BookList = bookDao.BookSelect();
		for(int i=0; i<BookList.size(); i++) {
			BookVo vo = BookList.get(i);
			System.out.println(vo.getBookId() + ", " + vo.getTitle() + ", " + vo.getPubs() + ", " + vo.getPubdate());
		}
		//책 수정(Update)
		bookDao.BookUpdate(6, "삼국지(수정)");
		
		//책 삭제(Delete)
		bookDao.BookDelete(5);
		
		//책 출력(select)
		BookList = bookDao.BookSelect();
		for(int i=0; i<BookList.size(); i++) {
			BookVo vo = BookList.get(i);
			System.out.println(vo.getBookId() + ", " + vo.getTitle() + ", " + vo.getPubs() + ", " + vo.getPubdate());
		}
		
	}

}