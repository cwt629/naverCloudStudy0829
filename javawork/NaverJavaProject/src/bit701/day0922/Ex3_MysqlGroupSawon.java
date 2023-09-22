package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3_MysqlGroupSawon {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	public Ex3_MysqlGroupSawon() {
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패: " + e.getMessage());
		}
	}
	
	public void sawonBunseok()
	{
		String sql = "select buseo, count(*) count, max(score) maxscore, min(score) minscore,"
				+ " avg(score) avgscore from sawon group by buseo";
		
		Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("부서\t인원수\t최고점\t최저점\t평균");
			System.out.println("=".repeat(40));
			
			while (rs.next()) {
				String buseo = rs.getString("buseo");
				int count = rs.getInt("count");
				int maxScore = rs.getInt("maxscore");
				int minScore = rs.getInt("minscore");
				double average = rs.getDouble("avgscore");
				
				// 출력하기
				System.out.printf("%s\t%d\t%d\t%d\t%.4f\n", buseo, count, maxScore, minScore, average);
			}
			
		} catch (SQLException e) {
			System.out.println("Mysql 연결 실패: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Ex3_MysqlGroupSawon ex = new Ex3_MysqlGroupSawon();
		ex.sawonBunseok();
	}

}
