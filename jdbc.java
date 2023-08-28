package com.springCharan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbc {
	Connection conn;
	PreparedStatement pstat;
	ResultSet rs;
	String pass;

	public String db(String param2) {

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");
			String query = "select password from validation where username=?;";
			pstat = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstat.setString(1, param2);
			System.out.println(pstat.toString());
			rs = pstat.executeQuery();
			if (rs.next()) {
				pass = rs.getString(1);
				System.out.println("pass:" + pass);
			}
		} catch (Exception ex) {
			System.out.println("db:" + ex);
		}
		return pass;
	}

}
