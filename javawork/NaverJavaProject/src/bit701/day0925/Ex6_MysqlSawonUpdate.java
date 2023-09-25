package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex6_MysqlSawonUpdate {
	DbConnect db = new DbConnect();
	
	public void sawonUpdate() 
	{
		Scanner sc = new Scanner(System.in);
		/*
		 * num을 입력받고 나서
		 * 이름(name), 점수(score), 부서(buseo)를 입력받은 후
		 * 그 num에 해당하는 name, score, buseo 수정하기
		 * num이 없다면, "해당 데이터가 없습니다" 출력
		 */
		
		System.out.println("수정할 데이터의 번호는?");
		String num = sc.nextLine();
		System.out.println("변경할 이름은?");
		String name = sc.nextLine();
		System.out.println("변경할 점수는?");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("변경할 부서는?");
		String buseo = sc.nextLine();
		
		String sql = "update sawon set name = '" + name + "', score = " + score
				+ ", buseo = '" + buseo + "' where num = " + num;
		//System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getMysqlConnection();
		try {
			stmt = conn.createStatement();
			
			int updated = stmt.executeUpdate(sql);
			
			if (updated == 0)
				System.out.println("해당 데이터가 없습니다.");
			else
				System.out.println("데이터를 수정했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		Ex6_MysqlSawonUpdate ex = new Ex6_MysqlSawonUpdate();
		ex.sawonUpdate();
	}

}
