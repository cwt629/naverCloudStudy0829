package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ex2_MysqlJdbc {
	// cj 안넣어도 되긴 하는데 deprecated돼서 경고나옴
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	public Ex2_MysqlJdbc() {
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패: " + e.getMessage());
		}
	}
	
	public void sawonAllDatas()
	{
		Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon order by num";
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
			//System.out.println("Mysql 연결 성공");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("사원번호\t이름\t점수\t성별\t부서");
			System.out.println("=".repeat(40));
			
			int total = 0;
			int count = 0;
			double avg;
			
			while (rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				
				total += score;
				count++;
				System.out.println(num + "\t" + name + "\t" + score + "\t" +
					gender + "\t" + buseo);
			}
		
			System.out.println("\n총점: " + total);
			avg = (double)total / count;
			System.out.printf("평균: %3.1f\n", avg);
		} catch (SQLException e) {
			System.out.println("Mysql 연결 실패: " + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ex2_MysqlJdbc ex = new Ex2_MysqlJdbc();
		ex.sawonAllDatas();
	}

}
