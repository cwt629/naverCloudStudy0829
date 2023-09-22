package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1_OracleJdbc {
	static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	// @ 뒤에는 ip주소(지금은 로컬이므로 localhost, 이후 원격이면 거기꺼)
	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public Ex1_OracleJdbc() {
		try {
			Class.forName(ORACLE_DRIVER);
			//System.out.println("오라클 드라이버 성공");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 오류: " + e.getMessage());
		}
	}
	
	public void shopAllDatas()
	{
		Connection conn = null;
		
		Statement stmt = null;
		ResultSet rs = null; // select일 경우에만 필요
		String sql = "select * from shop order by sang_no";
		
		try {
			conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
			//System.out.println("오라클 연결 성공");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // select일 경우는 무조건 executeQuery(반환 타입이 ResultSet)
			
			// rs.next() : 다음 데이터로 이동하고 true 반환. 이동할 데이터가 없을 경우 false 반환
			System.out.println("상품번호\t상품명\t가격\t색상");
			System.out.println("=".repeat(40));
			int total = 0;
			while (rs.next())
			{
				// 데이터를 가져올 때 인덱스로 가져오거나 컬럼명으로 가져온다
				// 1. 인덱스로 가져오기 (첫째가 1)
//				String no = rs.getString(1);
//				String name = rs.getString(2);
//				int price = rs.getInt(3);
//				String color = rs.getString(4);
				
				// 2. 컬럼명으로 가져오기
				String no = rs.getString("sang_no");
				String name = rs.getString("sang_name");
				int price = rs.getInt("sang_price");
				String color = rs.getString("sang_color");
				
				total += price;
				
				System.out.println(no + "\t" + name + "\t" + price + "\t" + color);
			}
			System.out.println("\n총금액: " + total);
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패: " + e.getMessage());
		} finally {
			try {
				/*
				 * select일땐 괜찮지만 insert 등에서 문제가 발생할 수 있으므로
				 * 꼭 마지막에, exception 발생 여부와 관계 없이
				 * finally 문에서 이들을 닫아줘야 한다.
				 * 이 역시 역순으로 닫아준다.
				 */
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * JRE System Library나 (추가 이후) Referenced Libraries 우클릭
	 * -> Build path -> Configure build path
	 * -> Classpath 클릭 후, Add External jars
	 */
	
	public static void main(String[] args) {
		Ex1_OracleJdbc ex = new Ex1_OracleJdbc();
		ex.shopAllDatas();
	}

}
