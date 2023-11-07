package escthemes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class EscThemesDao {
	DbConnect db = new DbConnect();

	// 검색된 테마들 출력 1: 이름
	public List<EscThemesDto> getThemesByName(String searchingName) {
		List<EscThemesDto> list = new Vector<EscThemesDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escthemes where themename like ? order by roomcode desc";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, "%" + searchingName.trim() + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EscThemesDto dto = new EscThemesDto();
				dto.setRoomcode(rs.getString("roomcode"));
				dto.setMemcode(rs.getString("memcode"));
				dto.setThemename(rs.getString("themename"));
				dto.setGenre(rs.getString("genre"));
				dto.setCafename(rs.getString("cafename"));
				dto.setRegion(rs.getString("region"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegisteredDate(rs.getTimestamp("registereddate"));
				dto.setImage(rs.getString("image"));

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

	// 검색된 테마들 출력 2: 지역
	public List<EscThemesDto> getThemesByRegion(String searchingRegion) {
		List<EscThemesDto> list = new Vector<EscThemesDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from escthemes where region like ? order by roomcode desc";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, "%" + searchingRegion.trim() + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EscThemesDto dto = new EscThemesDto();
				dto.setRoomcode(rs.getString("roomcode"));
				dto.setMemcode(rs.getString("memcode"));
				dto.setThemename(rs.getString("themename"));
				dto.setGenre(rs.getString("genre"));
				dto.setCafename(rs.getString("cafename"));
				dto.setRegion(rs.getString("region"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegisteredDate(rs.getTimestamp("registereddate"));
				dto.setImage(rs.getString("image"));

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

	// 검색된 테마들 출력 3: 장르
	public List<EscThemesDto> getThemesByGenre(String searchingGenre) {
		List<EscThemesDto> list = new Vector<EscThemesDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escthemes where genre like ? order by roomcode desc";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, "%" + searchingGenre.trim() + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EscThemesDto dto = new EscThemesDto();
				dto.setRoomcode(rs.getString("roomcode"));
				dto.setMemcode(rs.getString("memcode"));
				dto.setThemename(rs.getString("themename"));
				dto.setGenre(rs.getString("genre"));
				dto.setCafename(rs.getString("cafename"));
				dto.setRegion(rs.getString("region"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegisteredDate(rs.getTimestamp("registereddate"));
				dto.setImage(rs.getString("image"));

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

	// 검색된 테마들 출력 4: 지점명
	public List<EscThemesDto> getThemesByCafename(String searchingCafe) {
		List<EscThemesDto> list = new Vector<EscThemesDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escthemes where cafename like ? order by roomcode desc";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, "%" + searchingCafe.trim() + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EscThemesDto dto = new EscThemesDto();
				dto.setRoomcode(rs.getString("roomcode"));
				dto.setMemcode(rs.getString("memcode"));
				dto.setThemename(rs.getString("themename"));
				dto.setGenre(rs.getString("genre"));
				dto.setCafename(rs.getString("cafename"));
				dto.setRegion(rs.getString("region"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegisteredDate(rs.getTimestamp("registereddate"));
				dto.setImage(rs.getString("image"));

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

	// 특정 roomcode에 해당하는 테마 dto 반환
	public EscThemesDto getThemeByCode(String roomcode) {
		EscThemesDto dto = new EscThemesDto();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from escthemes where roomcode = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, roomcode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setRoomcode(rs.getString("roomcode"));
				dto.setMemcode(rs.getString("memcode"));
				dto.setThemename(rs.getString("themename"));
				dto.setGenre(rs.getString("genre"));
				dto.setCafename(rs.getString("cafename"));
				dto.setRegion(rs.getString("region"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegisteredDate(rs.getTimestamp("registereddate"));
				dto.setImage(rs.getString("image"));
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
	public void insertTheme(EscThemesDto dto) {
		String sql = "insert into escthemes values (null, ?, ?, ?, ?, ?, ?, now(), ?)";

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getMemcode());
			pstmt.setString(2, dto.getThemename());
			pstmt.setString(3, dto.getGenre());
			pstmt.setString(4, dto.getCafename());
			pstmt.setString(5, dto.getRegion());
			pstmt.setString(6, dto.getExplanation());
			pstmt.setString(7, dto.getImage());
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// update
	public void updateTheme(EscThemesDto dto) {
		String sql = "";

		// 사진을 수정한 경우와 수정하지 않은 경우 따로 한다
		if (dto.getImage() == null) {
			sql = "update escthemes set themename = ?, genre = ?, cafename = ?, region = ?, explanation = ? where roomcode = ?";
		} else {
			sql = "update escthemes set themename = ?, genre = ?, cafename = ?, region = ?, explanation = ?, image = '"
					+ dto.getImage() + "' where roomcode = ?";
		}

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getThemename());
			pstmt.setString(2, dto.getGenre());
			pstmt.setString(3, dto.getCafename());
			pstmt.setString(4, dto.getRegion());
			pstmt.setString(5, dto.getExplanation());
			pstmt.setString(6, dto.getRoomcode());
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
	public void deleteTheme(String code) {
		String sql = "delete from escthemes where roomcode = ?";

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, code);
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
