package escreviews.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import escthemes.data.EscThemesDao;
import escthemes.data.EscThemesDto;
import mysql.db.DbConnect;

public class EscReviewsDao {
	DbConnect db = new DbConnect();

	// 특정 방탈출 테마 리뷰 가져오기
	public List<EscReviewsDto> getReviewsByTheme(String roomcode) {
		List<EscReviewsDto> list = new Vector<EscReviewsDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escreviews where roomcode = ? order by writeday desc";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, roomcode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EscReviewsDto dto = new EscReviewsDto();
				dto.setReviewcode(rs.getString("reviewcode"));
				dto.setMemcode(rs.getString("memcode"));
				dto.setRoomcode(rs.getString("roomcode"));
				dto.setScore(rs.getString("score"));
				dto.setComment(rs.getString("comment"));
				dto.setWriteday(rs.getTimestamp("writeday"));

				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	// 특정 유저가 작성한 리뷰들 가져오기
	public List<EscReviewsDto> getReviewsByMember(String memcode) {
		List<EscReviewsDto> list = new Vector<EscReviewsDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escreviews where memcode = ? order by writeday desc";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, memcode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EscReviewsDto dto = new EscReviewsDto();
				dto.setReviewcode(rs.getString("reviewcode"));
				dto.setMemcode(rs.getString("memcode"));
				dto.setRoomcode(rs.getString("roomcode"));
				dto.setScore(rs.getString("score"));
				dto.setComment(rs.getString("comment"));
				dto.setWriteday(rs.getTimestamp("writeday"));

				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	// 특정 방탈출 테마에 대해 특정 유저가 작성한 리뷰 가져오기
	public EscReviewsDto getThemeReviewByMemcode(String roomcode, String memcode) {
		EscReviewsDto dto = new EscReviewsDto();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escreviews where roomcode = ? and memcode = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, roomcode);
			pstmt.setString(2, memcode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setReviewcode(rs.getString("reviewcode"));
				dto.setMemcode(rs.getString("memcode"));
				dto.setRoomcode(rs.getString("roomcode"));
				dto.setScore(rs.getString("score"));
				dto.setComment(rs.getString("comment"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return dto;
	}

	// insert
	public void insertReview(EscReviewsDto dto) {
		String sql = "insert into escreviews values (null, ?, ?, ?, ?, now())";

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getMemcode());
			pstmt.setString(2, dto.getRoomcode());
			pstmt.setString(3, dto.getScore());
			pstmt.setString(4, dto.getComment());
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// delete
	public void deleteReview(String reviewcode) {
		String sql = "delete from escreviews where reviewcode = ?";

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, reviewcode);
			// 실행
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// 평점 기준 상위 n개의 테마를 받아오는 함수
	public List<EscThemesDto> getRoomTopN(int n) {
		List<EscThemesDto> list = new Vector<EscThemesDto>();
		EscThemesDao dao = new EscThemesDao();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select roomcode, avg(score) as average " + "from escreviews " + "group by roomcode "
				+ "order by average desc " + "limit ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setInt(1, n);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String roomcode = rs.getString("roomcode");
				EscThemesDto dto = dao.getThemeByCode(roomcode);

				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	// 특정 roomcode에 해당하는 테마의 평균 점수를 받아오는 함수
	public double getAveragePoint(String roomcode) {
		double average = 0;

		EscThemesDao dao = new EscThemesDao();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select avg(score) as average from escreviews where roomcode = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, roomcode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				average = rs.getDouble("average");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return average;
	}
}
