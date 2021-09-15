package com.bitcamp.lecture.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bitcamp.lecture.comm.Member;

public class InsertProgram2 {
	
	static final String URL = "jdbc:mysql://221.148.138.87:3306/lecture";
	static final String ID = "bitcamp";
	static final String PW = "1234";
	

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement preStmt = null; //insert문에 변수 처리할 수 있도록 해주는 인터페이스
//		Statement stmt = null;
//		ResultSet rs = null; //데이터를 따로 받아오지 않기때문에 INSERT문에는 필요 없음
		
		
		//UI 쪽 인터페이스를 통해서 CRUD 관련 데이터를 전달 받는다.
		Member member = new Member();
		member.setId("chocho");
		member.setPwd("1234");
		member.setName("김덕배");
		member.setGender("M");
		
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
			 //value값에 ?처리하여 변수로 받을 수 있도록 함
			 String sql = "INSERT INTO member(ID, PWD, NAME, GENDER) VALUES(?,?,?,?)";
			 preStmt = con.prepareStatement(sql); // Statement 객체를 생성해줌
			 //DB에서는 index가 1부터시작함
			 preStmt.setString(1, member.getId()); 
			 preStmt.setString(2, member.getPwd()); 
			 preStmt.setString(3, member.getName()); 
			 preStmt.setString(4, member.getGender()); 
			 
			 System.out.println("-------------------------------------------------------------");
			 System.out.println("ID                     PWD              NAME       GENDER");
			 System.out.println("-------------------------------------------------------------");

			 //업데이트 실행된 빈도수만큼 숫자 리턴해줌 / 매개변수는 공란으로 둬야함
			 /*
			  * smtm.executeQuery(sql) <- select문에서 쿼리실행하는 경우는 매개변수에 sql문을 넣어줘야함
			  * 
			  */
			 int cnt = preStmt.executeUpdate(); 
			 System.out.println("query OK" + cnt + "row affected");
			
			 
			 
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				if(con != null && !con.isClosed()) {
					preStmt.close();
					con.close();
					System.out.println("리소스 해제 완료");
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
