package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookSelectAll {

	public static void main(String[] args) {
			//책 데이터가져오기
		List<BookVo>bookList=new ArrayList <BookVo>();
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		// 3. SQL문 준비 / 바인딩 / 실행
			String query="";
			query +=" select book_id ," ;
			query +=" title ," ;
			query +=" pubs ," ;
			query +="  to_char(pub_date,'yyyy-mm-dd')dat ," ;
			query +=" bo.author_id, " ;
			query +=" author_name, " ;
			query +=" author_desc " ;
			query +=" from book bo , " ; 
			query +=" author au" ;
			query +=" where au.author_id = ";
			query +="  bo.author_id" ; 
			
			System.out.println(query);
		
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				int bookId=rs.getInt("book_id");
				String bookTitle=rs.getString("title");
				String	bookPubs=rs.getString("pubs");
				String bookPubdate=rs.getString("dat");
				int boAuthorid=rs.getInt("author_id");
				String auAuthorname=rs.getString("author_name");
				String authorDesc=rs.getString("author_desc");
				System.out.println(bookId+", "+bookTitle+", "+bookPubs+", "+bookPubdate+", "+boAuthorid
									+", "+auAuthorname+", "+authorDesc);
//				 int bookId=rs.getInt(1);
//				 String bookTitle=rs.getString(2);
//				 String bookPubs=rs.getString(3);
//				 String bookPubdate=rs.getString(4);
//				 int boAuthorid=rs.getInt(5);
//				 String authorName=rs.getString(6);
//				 String authorDesc=rs.getString(7);
//			
//				 BookVo vo= new BookVo(bookId,bookTitle, bookPubs,bookPubdate,boAuthorid,authorName,authorDesc );
//					bookList.add(vo);
//					
//			for(int i=0; i<bookList.size();i++)	{
//				BookVo bookVo=bookList.get(i);
//				System.out.println(bookVo.getBookId()+", "+bookVo.getBookTitle()+", "+bookVo.getBookPubs()+", "+bookVo.getBookPubdate()+", "
//								+ bookVo.getBoAuthorid()+", "+bookVo.getAuthorName()+", "+bookVo.getAuthorDesc());
//			}
//					
			}
			// 4.결과처리
			
		} catch (ClassNotFoundException e) {
		System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		System.out.println("error:" + e);
		} finally {
		// 5. 자원정리
		try {
		if (rs != null) {
		rs.close();
		} 
		if (pstmt != null) {
		pstmt.close();
		}
		if (conn != null) {
		conn.close();
		}
		} catch (SQLException e) {
		System.out.println("error:" + e);
		}
		}
	}

}