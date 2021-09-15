package com.bitcamp.lecture.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitcamp.lecture.comm.Member;

public class PracticeForSelect {

	public static void main(String[] args) {

		//0. 멤버객체 생성 및 연결 인터페이스들 설정
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Member mem1 = new Member();
		mem1.setName("홍길동");
		
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
			String sql = "SELECT id, name FROM member WHERE name=?";
			 stmt = con.prepareStatement(sql);
			 
			 stmt.setString(1, mem1.getName());
			
		//4. ResultSet 작성
			//반환된 테이블을 rs에 저장
			 /*
			  * 중요!!! executeQuery에 매개변수로 sql을 넣어서 계속 null을 반환 한 것이었음
			  * 왜냐면 sql문에는 where 조건에 name이 공란이기 때문에 해당하는 sql문을 반환 해주지 못하는 게 당연하므로 null이 뜰 수 밖에 없음
			  * 따라서, preparedStatement에 이미 해당 sql문이 저장되어 있으므로 매개변수 없이 executeQuery를 실행 해 주어야 함
			  */
			 rs = stmt.executeQuery();
			
			//하나만 조회(next()함수는 boolean을 리턴함 값이 있으면 true , 없으면 false)
			//일단 next로 자료를 읽어와야 rs에 데이터가 담기기 떄문에 끝까지 next를 해줘야함
			 while(rs.next()) {
				 String idValue = rs.getString("id");
				 String name = rs.getString("name");
				 System.out.println("id = "+idValue);
				 System.out.println("name = "+name);
			 }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
		//5. 리소스 해제
				//연결상태가 null이 아니고, 닫히지 않았다면 하기 코드 실행
				if(con!=null && !con.isClosed()) {
					
				rs.close();
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
