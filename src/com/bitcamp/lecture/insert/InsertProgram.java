package com.bitcamp.lecture.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProgram {
	
	static final String URL = "jdbc:mysql://221.148.138.87:3306/lecture";
	static final String ID = "bitcamp";
	static final String PW = "1234";
	

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
//		ResultSet rs = null; //데이터를 따로 받아오지 않기때문에 INSERT문에는 필요 없음
		
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
			 String sql = "INSERT INTO member(ID, PWD, NAME, GENDER) VALUES('Chuseok','1234','부침개','F')";
			 
			 System.out.println("-------------------------------------------------------------");
			 System.out.println("ID                     PWD              NAME       GENDER");
			 System.out.println("-------------------------------------------------------------");

			 
			 int cnt = stmt.executeUpdate(sql);
			 System.out.println("query OK" + cnt + "row affected");
			
			 
			 
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				if(con != null && !con.isClosed()) {
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
