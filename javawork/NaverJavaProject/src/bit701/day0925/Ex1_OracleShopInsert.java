package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex1_OracleShopInsert {
	DbConnect db = new DbConnect();
	
	public void shopInsert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("상품명 입력");
		String sang = sc.nextLine();
		
		System.out.println("가격 입력");
		int price = Integer.parseInt(sc.nextLine());
		
		System.out.println("색상 입력");
		String color = sc.nextLine();
		
		String sql = "insert into shop values (seq_shop.nextval,'" + sang + "'," + price + ",'" + color + "')";
		
		Connection conn = null;
		Statement stmt = null;
		// resultset은 insert에선 필요없음. select에서 보여주는 데 필요한듯
		
		// db 연결
		conn = db.getOracleConnection();
		// statement 생성
		try {
			stmt = conn.createStatement();
			// 실행
//			boolean b = stmt.execute(sql); // 반환타입이 boolean : false(resultset이 없어서)
//			int n = stmt.executeUpdate(sql); // 반환타입이 int (sql문을 성공한 갯수. delete 3개 되면 3 반환...)
//			System.out.println(b + ", " + n);
//			System.out.println("데이터 두번 insert됨");
			
			stmt.execute(sql);
			System.out.println("shop에 데이터 추가됨");
		} catch (SQLException e) {
			System.out.println("insert sql문 오류: " + e.getMessage());
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}
	
	public static void main(String[] args) {
		Ex1_OracleShopInsert ex = new Ex1_OracleShopInsert();
		ex.shopInsert();
	}

}
