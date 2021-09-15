package com.bitcamp.lecture.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitcamp.lecture.comm.Member;

public class PracticeForUpdate {

	public static void main(String[] args) {

		//0. 멤버객체 생성 및 연결 인터페이스들 설정
		Connection con = null;
		PreparedStatement stmt = null;
		
		Member mem2 = new Member();
		mem2.setId("아디오스");
		mem2.setName("르네상스최");
		
		//1. 드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//2. 드라이버 연결
			//연결정보 작성
			String url = "jdbc:mysql://localhost:3306/lecture";
			String id = "bitcamp";
			String pw = "1234";
			 con = DriverManager.getConnection(url, id, pw);
			
		//3. Statement 작성
			String sql = "DELETE FROM member where id=?";
			 stmt = con.prepareStatement(sql);

			 stmt.setString(1, mem2.getId());
			 int result = stmt.executeUpdate();
			 System.out.println("query가 "+result+"행 만큼 적용 되었습니다.");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
		//5. 리소스 해제
				//연결상태가 null이 아니고, 닫히지 않았다면 하기 코드 실행
				if(con!=null && !con.isClosed()) {
					
				stmt.close();
				con.close();
				System.out.println("리소스 해제 완료");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
