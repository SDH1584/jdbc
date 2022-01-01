package com.javaex.ex08;

import java.util.List;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<BookVo> BookList;
		//작가 dao 
		AuthorDao authorDao=new AuthorDao();
		//작가추가
		authorDao.authorInsert("이문열","경북영양");
		authorDao.authorInsert("박경리", "경상남도 통영");
		authorDao.authorInsert("유시민", "17대 국회의원");
		authorDao.authorInsert( "기안84", "기안동에서 산 84년생");
		authorDao.authorInsert( "강풀", "온라인 만화가 1세대");
		authorDao.authorInsert( "김영하", "알쓸신잡");
		authorDao.authorInsert("이고잉","자바프로그래머");
		//책 dao
		BookDao bookDao = new BookDao();
		//책 추가
		bookDao.bookInsert("우리들의 일일그러진 영웅", "다림", "1998-02-22", 1);
		bookDao.bookInsert("삼국지", "민음사", "1998-02-22", 1);
		bookDao.bookInsert("토지", "마로니에북스", "2012-08-15", 2);
		bookDao.bookInsert("자바 프로그래밍 입문", "위키북스", "2015-04-01", 7);
		bookDao.bookInsert("패션왕", "중앙북스(books)", "2012-02-22", 4);
		bookDao.bookInsert("순정만화", "재미주의", "2011-08-03", 5);
		bookDao.bookInsert("오직두사람", "문학동네", "2017-05-04", 6);
		bookDao.bookInsert( "26년", "재미주의", "2012-02-04", 3);
			
		//책 검색메소드	
		System.out.print("검색 : ");
		sc.nextLine();
			BookList = bookDao.BookSelect();
			//출력
			for(int i=0; i<BookList.size(); i++) 
			{
			BookVo vo = BookList.get(i);
			System.out.println(vo.getBookId() + ", " + vo.getTitle() + ", " + vo.getPubs() + ", " + vo.getPubdate()+vo.getAuthorId()+" ,"+vo.getAuthorDesc());
			}
		sc.close();
	}

	

}