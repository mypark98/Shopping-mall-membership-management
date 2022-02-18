package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBManager;
import dto.MemberDTO;
import dto.SalesDTO;

public class MemberDAO {

	// 싱글턴 패턴
	private MemberDAO() {
	}

	private static MemberDAO dao = new MemberDAO();

	public static MemberDAO getInstance() {
		return dao;
	}

	// 현재 마지막 회원번호 알아오는 쿼리 - select
	public int currentNumber() {
		int number = 0;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select member_seq.nextval from dual";

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				number = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return number;
	}

	// 입력받은 회원 정보 저장 -insert
	public void insertMember(MemberDTO mDto) {
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = "INSERT INTO member_tbl_02 VALUES(?,?,?,?,?,?,?)";

		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, mDto.getCustno());
			psmt.setString(2, mDto.getCustname());
			psmt.setString(3, mDto.getPhone());
			psmt.setString(4, mDto.getAddress());
			psmt.setTimestamp(5, mDto.getJoindate());
			psmt.setString(6, mDto.getGrade());
			psmt.setString(7, mDto.getCity());

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}

	}

	// 모든 회원 정보 읽어오기 => SELECT
	public List<MemberDTO> selectAllMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM member_tbl_02 ORDER BY custno ASC";

		List<MemberDTO> list = new ArrayList<>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberDTO mDto = new MemberDTO();
				mDto.setCustno(rs.getInt("custno"));
				mDto.setCustname(rs.getString("custname"));
				mDto.setPhone(rs.getString("phone"));
				mDto.setAddress(rs.getString("address"));
				mDto.setJoindate(rs.getTimestamp("joindate"));
				mDto.setGrade(rs.getString("grade"));
				mDto.setCity(rs.getString("city"));

				list.add(mDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	// custno를 통해 한명의 회원 정보를 조회하는 메서드 : SELECT
	public MemberDTO selectTargetMember(int custno) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM member_tbl_02 WHERE custno=?";

		MemberDTO mDto = new MemberDTO();

		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, custno);

			rs = psmt.executeQuery();

			if (rs.next()) {
				mDto.setCustno(rs.getInt("custno"));
				mDto.setCustname(rs.getString("custname"));
				mDto.setPhone(rs.getString("phone"));
				mDto.setAddress(rs.getString("address"));
				mDto.setJoindate(rs.getTimestamp("joindate"));
				mDto.setGrade(rs.getString("grade"));
				mDto.setCity(rs.getString("city"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}

		return mDto;
	}

//		회원 정보 수정 => update
	public void updateMember(MemberDTO mDto) {
		Connection conn = null;
		PreparedStatement psmt = null;

		String sql = "UPDATE member_tbl_02 " + " SET custname=?, phone=?, address=?, grade=?, city=?, joindate=? "
				+ " WHERE custno=? ";

		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, mDto.getCustname());
			psmt.setString(2, mDto.getPhone());
			psmt.setString(3, mDto.getAddress());
			psmt.setString(4, mDto.getGrade());
			psmt.setString(5, mDto.getCity());
			psmt.setTimestamp(6, mDto.getJoindate());
			psmt.setInt(7, mDto.getCustno());

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}

	}

	// 매출 정보 조회 - SELECT
	public List<SalesDTO> selectSumAllSalse() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT m1.custno, m1.custname, m1.grade, sum(m2.price) "
				+ " FROM member_tbl_02 m1 join money_tbl_02 m2 " + " on m1.custno = m2.custno "
				+ " GROUP BY (m1.custno, m1.custname, m1.grade) " + " ORDER BY sum(m2.price) DESC ";

		List<SalesDTO> list = new ArrayList<>();

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				SalesDTO sDto = new SalesDTO();
				sDto.setCustno(rs.getInt(1));
				sDto.setCustname(rs.getString(2));
				sDto.setGrade(rs.getString(3));
				sDto.setSumsales(rs.getInt(4));

				list.add(sDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}
}
