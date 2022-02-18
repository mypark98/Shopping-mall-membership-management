package DBPKG;

import java.sql.Connection;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
