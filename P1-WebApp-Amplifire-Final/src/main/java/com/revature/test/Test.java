package com.revature.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.ConnectionFactory;

public class Test {

	public static void main(String[] args) throws SQLException {
		Connection c = ConnectionFactory.getConnection();
		String query = "Insert into users(username,password,email) values('pikachu','pikachu','pikachu@email.com')";
		Statement statement = c.createStatement();
		statement.execute(query);
	}

}
