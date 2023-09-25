package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DbConnect;

public class Ex7_SawonCrud {
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	public void selectAll()
	{
		System.out.println("번호\t사원명\t점수\t성별\t부서");
		System.out.println("=".repeat(50));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from sawon order by num";
		conn = db.getMysqlConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				System.out.println(num + "\t" + name + "\t" + score + "\t" + gender + "\t" + buseo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	public void insertSawon()
	{
		System.out.println("이름은?");
		String name = sc.nextLine();
		System.out.println("1 - 100 사이 점수는?");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("성별은? (남자 or 여자)");
		String gender = sc.nextLine();
		System.out.println("부서는?");
		String buseo = sc.nextLine();
		
		String sql = "insert into sawon (name, score, gender, buseo) values (?,?,?,?)";
		// ?에 값을 넣는 것: 바인딩
		// ?는 차례대로 1,2,3,4...
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 개수만큼 값을 넣어준다
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);
			
			// 실행 (주의: sql문은 안넣는다)
			pstmt.execute();
			
			System.out.println("사원정보를 추가하였습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteSawon()
	{
		/*
		 * 보통은 num으로 가서 삭제하는 게 안전하고 맞지만
		 * 연습하는 거니까 일단 이름으로 받아서 삭제하자.
		 */
		System.out.println("삭제할 사원의 이름은?");
		String name = sc.nextLine();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from sawon where name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 개수만큼 바인딩
			pstmt.setString(1, name);
			// 삭제된 인원을 알고 싶을 경우 executeUpdate 활용
			int n = pstmt.executeUpdate();
			if (n == 0)
				System.out.println("삭제할 사원이 존재하지 않습니다.");
			else
				System.out.println(n + "명 사원 정보 삭제 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void updateSawon()
	{
		/*
		 * 수정할 데이터의 번호를 입력받고
		 * 수정할 점수(score), 성별(gender), 부서(buseo)를 입력받아
		 * update해보자.
		 */
		System.out.println("수정할 데이터의 번호는?");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("점수는 몇점으로 변경?");
		int score = Integer.parseInt(sc.nextLine());
		System.out.println("성별은 어떻게 변경?(남자 or 여자)");
		String gender = sc.nextLine();
		System.out.println("부서는 어디로 변경?");
		String buseo = sc.nextLine();
		
		String sql = "update sawon set score = ?, gender = ?, buseo = ? where num = ?";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// ? binding
			pstmt.setInt(1, score);
			pstmt.setString(2, gender);
			pstmt.setString(3, buseo);
			pstmt.setInt(4, no);
			
			int updated = pstmt.executeUpdate();
			
			if (updated == 0)
				System.out.println("해당 번호에 대한 데이터가 존재하지 않습니다.");
			else
				System.out.println("데이터 수정 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public int getMenu()
	{
		int menu = 0;
		System.out.println("1.추가  2.삭제  3.수정  4.전체조회  5.종료");
		menu = Integer.parseInt(sc.nextLine());
		return menu;
	}
	
	public static void main(String[] args) {
		Ex7_SawonCrud ex = new Ex7_SawonCrud();
		
		while (true)
		{
			int menu = ex.getMenu();
			
			switch(menu) {
			case 1:
				ex.insertSawon();
				break;
				
			case 2:
				ex.deleteSawon();
				break;
				
			case 3:
				ex.updateSawon();
				break;
				
			case 4:
				ex.selectAll();
				break;
				
			default:
				System.out.println("시스템을 종료합니다");
				System.exit(0); // 시스템 종료
			}
			
			System.out.println("-".repeat(30));
		}
	}

}
