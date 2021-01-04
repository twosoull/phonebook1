package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.PersonVo;

public class PhoneDao {
	// 필드
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "phonedb";
	private String pw = "phonedb";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 생성자
	// 메소드 g/s
	// 메소드 일반
	private void getDriver() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// getDriver()

	private void close() {
		try {
			if (rs != null)
				rs.close();

			if (conn != null)
				conn.close();

			if (pstmt != null)
				pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// close()

	public int phoneInsert(PersonVo pv) {
		int count = 0;
		getDriver();

		try {
			String query = "";
			query += " INSERT INTO person ";
			query += " VALUES(seq_person_id.nextval,?,?,?) ";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, pv.getName());
			pstmt.setString(2, pv.getHp());
			pstmt.setString(3, pv.getCompany());

			count = pstmt.executeUpdate();

			// 실행
			System.out.println("[" + count + "건 등록되었습니다.]");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return count;
	}// phoneInsert

	public int phoneUpdate(PersonVo pv) {
		getDriver();
		int count = 0;

		try {
			String query = "";
			query += " UPDATE person ";
			query += " SET name = ?, ";
			query += "     hp = ?, ";
			query += "     company = ? ";
			query += " WHERE person_id = ? ";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, pv.getName());
			pstmt.setString(2, pv.getHp());
			pstmt.setString(3, pv.getCompany());
			pstmt.setInt(4, pv.getPersonId());

			count = pstmt.executeUpdate();

			// 실행
			System.out.println("[" + count + "건이 수정되었습니다.]");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		return count;

	}// phoneUpdate

	public int phoneDelete(PersonVo pv) {
		getDriver();
		int count = 0;
		try {
			String query = "";
			query += " DELETE FROM person ";
			query += " WHERE person_id = ? ";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, pv.getPersonId());
			count = pstmt.executeUpdate();

			// 실행
			System.out.println("[" + count + "건이 삭제되었습니다.]");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
		return count;
	}// phoneDelete

	public List<PersonVo>  getPersonList() {
		getDriver();
		List<PersonVo> pList = new ArrayList<PersonVo>();
		try {
			String query = "";
			query += " SELECT person_id, ";
			query += "        name, ";
			query += "        hp, ";
			query += "        company ";
			query += " FROM person ";
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int personId = rs.getInt("person_id");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");

				PersonVo pv = new PersonVo(personId, name, hp, company);
				pList.add(pv);
			} // while
/*
			for (int i = 0; i < pList.size(); i++) {
				PersonVo pv = pList.get(i);
				System.out.println(
						pv.getPersonId() + ".    " + pv.getName() + "    " + pv.getHp() + "    " + pv.getCompany());
			}
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return pList;
	}// phoneSelect

	public void phoneSearch(String search) {
		getDriver();
		List<PersonVo> pList = new ArrayList<PersonVo>();
		try {
			String query = "";
			query += " SELECT person_id, ";
			query += "       name, ";
			query += "        hp, ";
			query += "        company ";
			query += " FROM person ";
			query += " WHERE name like ? ";
			query += " or hp like ? ";
			query += " or company like ? ";
			pstmt = conn.prepareStatement(query);

			String search01 = "%" + search + "%";
			pstmt.setString(1, search01);
			pstmt.setString(2, search01);
			pstmt.setString(3, search01);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int personId = rs.getInt("person_id");
				String personName = rs.getString("name");
				String personHp = rs.getString("hp");
				String personCpny = rs.getString("company");

				System.out.println(personId + "    " + personName + "    " + personHp + "    " + personCpny);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
