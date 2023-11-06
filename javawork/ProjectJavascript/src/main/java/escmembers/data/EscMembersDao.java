package escmembers.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.db.DbConnect;

public class EscMembersDao {
	DbConnect db = new DbConnect();

	// insert
	public void insertMember(EscMembersDto dto) {
		String sql = "insert into escmembers (memcode, id, pw, favorplace, registereddate) values (null, ?, ?, ?, now())";

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getFavorplace());
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// 특정 code에 해당하는 ID 반환
	public EscMembersDto getMemberDto(String memcode) {
		EscMembersDto dto = new EscMembersDto();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escmembers where memcode = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, memcode);
			// 실행
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setMemcode(rs.getString("memcode"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setFavorplace(rs.getString("favorplace"));
				dto.setRegisteredDate(rs.getTimestamp("registereddate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return dto;
	}

	// 특정 id에 해당하는 dto 반환
	public EscMembersDto getMemberValidated(String id) {
		EscMembersDto dto = new EscMembersDto();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escmembers where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, id);
			// 실행
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setMemcode(rs.getString("memcode"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setFavorplace(rs.getString("favorplace"));
				dto.setRegisteredDate(rs.getTimestamp("registereddate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return dto;
	}

	// 특정 id와 pw에 해당하는 dto 반환
	public EscMembersDto getMemberValidated(String id, String pw) {
		EscMembersDto dto = new EscMembersDto();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escmembers where id = ? and pw = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			// 실행
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setMemcode(rs.getString("memcode"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setFavorplace(rs.getString("favorplace"));
				dto.setRegisteredDate(rs.getTimestamp("registereddate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return dto;
	}

	// 특정 memcode에 해당하는 id 반환하는 함수
	public String getIdByMemcode(String memcode) {
		String id = "";

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escmembers where memcode = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, memcode);
			// 실행
			rs = pstmt.executeQuery();

			if (rs.next()) {
				id = rs.getString("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return id;
	}

	// 회원정보 수정
	public void updateMember(EscMembersDto dto) {
		String sql = "update escmembers set pw = ?, favorplace = ? where memcode = ?";

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getFavorplace());
			pstmt.setString(3, dto.getMemcode());
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// 회원정보 삭제
	public void deleteMember(String memcode) {
		String sql = "delete from escmembers where memcode = ?";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, memcode);

			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
}
