package com.davidesdras.paokentin.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3307/paokentin";
	private static final String USER = "paokentinuser";
	// Abaixo colocar a senha do banco de dados.
	private static final String PASSWORD = "paokentinpass";

	private static Connection conn = null;

	static Connection getCurrentConnection() throws SQLException {
		if (conn == null)
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		return conn;

	}

	static Connection getNewConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
