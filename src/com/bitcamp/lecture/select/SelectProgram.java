package com.bitcamp.lecture.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectProgram {
	
	static final String URL = "jdbc:mysql://221.148.138.87:3306/lecture";
	static final String ID = "bitcamp";
	static final String PW = "1234";
	

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			/*
			 * 드라이버 로딩
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			 * DB 연결
			 */
			 con = DriverManager.getConnection(URL, ID, PW);
			 System.out.println("Successfully Connection!");
			 
			 /*
			  * 쿼리 실행
			  */
			 stmt = con.createStatement(); // Statement 객체를 생성해줌
			 String sql = "SELECT * FROM idol_group";
			 rs = stmt.executeQuery(sql); //쿼리 실행 결과가 여기에 담김
			 
			 System.out.println("-------------------------------------------------------------");
			 System.out.println("ID                     PWD              NAME       GENDER");
			 System.out.println("-------------------------------------------------------------");

			 
			 
			 while(rs.next()) { //rs.next()는 boolean을 리턴함 (읽어올 값이 없으면 false)
					 //각 행의 첫줄값을 가져옴
					 String id = rs.getString("Company");
					 String name = rs.getString("group_name");
					 String email = rs.getString("gender");
					 System.out.printf("ID: %s \t Name : %s \t Email : %s%n",id, name, email);
			 }
			
			 
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				if(con != null && !con.isClosed()) {
					rs.close();
					stmt.close();
					con.close();
					System.out.println("리소스 해제 완료");
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
