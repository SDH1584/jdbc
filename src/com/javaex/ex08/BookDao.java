package com.javaex.ex08;

//공통변수 빼기
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.ex07.BookVo;

public class BookDao {

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

	// 생성자
	public BookDao() {
	}

	// 메소드 g/s

	// 메소드 일반
	public void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	public void close() {
		try {
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

	public void bookInsert(String title, String pub, String pubDate, int authorId) {

		getConnection();
		
		try {
			String query = "";
			query += " insert into book ";
			query += " values (seq_book_id.nextval, ?, ?, ?, ?) ";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, title);
			pstmt.setString(2, pub);
			pstmt.setString(3, pubDate);
			pstmt.setInt(4, authorId);

			int count = pstmt.executeUpdate();

			System.out.println(count + " 건이 생성되었습니다.(북)");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
		close();
	}

	public void BookUpdate(int bookId, String bookTitle) {

		getConnection();

		try {
			String query = "";
			query += " update  book ";
			query += " set     title = ? ";
			query += " where   book_id = ? ";
			System.out.println(query);

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, bookTitle);
			pstmt.setInt(2, bookId);

			int count = pstmt.executeUpdate();

			System.out.println(count + " 건이 저장되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}

	public void BookDelete(int bookId) {
		getConnection();
		try {
			String query = "";
			query += " delete  from book ";
			query += " where   book_id = ? ";

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, bookId);

			int count = pstmt.executeUpdate();

			System.out.println(count + " 건이 삭제되었습니다.(책)");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}

	public List<BookVo> BookSelect() {
		List<BookVo> bookList = new ArrayList<BookVo>();
		getConnection();
		try {
			String query = "";
				query +=" select  bo.book_id, ";
				query +=" 		  bo.title, "; 
				query +="		  bo.pubs, ";  
				query +="  		  to_char(bo.pub_date,'yyyy-mm-dd'), "; 
				query +=" 		  au.author_id, ";
				query +=" 		  au.author_name, "; 
				query +="		  author_desc ";
				query +=" from book bo, author au"; 
				query +=" where   au.author_id = ";
				query +=" 		  bo.author_id ";
				query +=" and (title || pubs || au.author_name) ";
				query +=" like '%문%' ";
				query +=" order by book_id";
			
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bookId = rs.getInt(1);// 컬럼명, 별명 사용시 별명
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				String pubDate = rs.getString(4);
				String authorId=rs.getString(5);
				String authorDesc=rs.getString(6);
				BookVo bvo = new BookVo(bookId, title, pubs, pubDate, authorId , authorDesc);
				bookList.add(bvo);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return bookList;
	}

}
