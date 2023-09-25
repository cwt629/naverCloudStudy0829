package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DbConnect;

public class Ex9_StudentCrud {
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	public int getMenu()
	{
		System.out.println("1.추가  2.삭제  3.수정  4.전체출력  5.검색  6.종료");
		int menu = Integer.parseInt(sc.nextLine());
		
		return menu;
	}
	
	// insert
	public void insertStudent()
	{
		/*
		 * 혈액형은 대문자로, writeday는 now()로 넣어서
		 * 데이터 삽입하자.
		 */
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("혈액형: ");
		String blood = sc.nextLine();
		System.out.print("전화번호: ");
		String phone = sc.nextLine();
		
		String sql = "insert into student (name, blood, phone, writeday) values (?, ?, ?, now())";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			
			pstmt.execute();
			
			System.out.println("데이터 삽입 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// delete
	public void deleteStudent()
	{
		/*
		 * 이름으로 삭제하자.
		 */
		
		System.out.print("삭제할 이름: ");
		String name = sc.nextLine();
		
		String sql = "delete from student where name = ?";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int deleted = pstmt.executeUpdate();
			
			if (deleted == 0)
				System.out.println("해당 이름의 학생이 없습니다.");
			else
				System.out.println("학생 데이터 삭제 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// update
	public void updateStudent()
	{
		/*
		 * 날짜를 제외하고 데이터 수정해보자.
		 */
		System.out.print("수정할 데이터의 번호: ");
		String num = sc.nextLine();
		
		System.out.print("이름 변경: ");
		String name = sc.nextLine();
		System.out.print("혈액형 변경: ");
		String blood = sc.nextLine();
		System.out.print("전화번호 변경: ");
		String phone = sc.nextLine();
		
		String sql = "update student set name = ?, blood = ?, phone = ? where num = ?";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			pstmt.setString(4, num);
			
			int updated = pstmt.executeUpdate();
			
			if (updated == 0)
				System.out.println("해당 번호의 데이터가 없습니다.");
			else
				System.out.println("학생 데이터 수정 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 전체 출력
	public void selectAllStudent()
	{
		System.out.println("번호\t이름\t혈액형\t전화\t추가일");
		
		String sql = "select * from student order by num";
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				//String writeday = rs.getString("writeday"); // 그냥 string으로 받아와도 시간까지 잘 가져온다
				Timestamp ts = rs.getTimestamp("writeday"); // timestamp 활용
				
				//System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" + writeday);
				//System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" + ts.toLocaleString());
				System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" + sdf.format(ts));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	// 검색 - 번호 끝 4자리로 검색
	public void searchPhone()
	{
		System.out.print("검색할 전화번호 끝 4자리 입력: ");
		String no = sc.nextLine();
		
		String sql = "select * from student where phone like ? order by num";
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + no);
			rs = pstmt.executeQuery();
			
			System.out.println("전화번호 " + no + " 검색 결과");
			
			int count = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while (rs.next()) {
				System.out.println("-".repeat(40));
				System.out.println((++count) + "번째 결과");
				String num = rs.getString("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				Timestamp writeday = rs.getTimestamp("writeday");
				System.out.println("데이터 번호: " + num);
				System.out.println("이름: " + name);
				System.out.println("혈액형: " + blood);
				System.out.println("전화번호: " + phone);
				System.out.println("데이터 추가일: " + sdf.format(writeday));
				System.out.println("-".repeat(40));
			}
			System.out.println("총 " + count + "개");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
	}
	
	public static void main(String[] args) {
		Ex9_StudentCrud ex = new Ex9_StudentCrud();
		
		while (true)
		{
			System.out.println("-".repeat(40));
			int menu = ex.getMenu();
			System.out.println("-".repeat(40));
			
			switch(menu)
			{
			case 1:
				ex.insertStudent();
				break;
				
			case 2:
				ex.deleteStudent();
				break;
				
			case 3:
				ex.updateStudent();
				break;
				
			case 4:
				ex.selectAllStudent();
				break;
				
			case 5:
				ex.searchPhone();
				break;
				
			default:
				System.out.println("** 프로그램을 종료합니다 **");
				System.exit(0);
			}
		}
	}

}
