package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDelete {
	public static void main(String[] args) {
	// 0. import java.sql.*;
	Connection conn = null;
	PreparedStatement pstmt= null;
	try {
	// 1. JDBC 드라이버(Oracle) 로딩
	Class.forName("oracle.jdbc.driver.OracleDriver");
		
	// 2. Connection 얻어오기
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	conn = DriverManager.getConnection(url, "webdb", "webdb");
	System.out.println("접속 success");
	
	
	// 3. SQL문준비/ 바인딩/ 실행
	String query="";
	query +=" delete from  author ";
	query +=" where author_id= ? ";
			
	System.out.println(query);
	pstmt =conn.prepareStatement(query);		
	
	pstmt.setInt(1,3);
	
	//실행
	int count=pstmt.executeUpdate();//쿼리문실행
	
	
	// 4.결과처리
	System.out.println(count+"건이 저장되었습니다.");
	} catch (ClassNotFoundException e) {
	System.out.println("error: 드라이버로딩실패-"+ e);
	} catch (SQLException e) {
	System.out.println("error:" + e);
	} finally {
	// 5. 자원정리
	try {
	if (pstmt!= null) {
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
