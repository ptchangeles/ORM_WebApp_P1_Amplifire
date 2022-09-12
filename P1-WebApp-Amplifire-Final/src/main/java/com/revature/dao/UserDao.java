package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDao implements UserDaoInterface{

	@Override
	public int createUser(User user) {
		String SQL = "INSERT into users(username, password, email)" +
				"VALUES (?, ?, ?)";
		int id = 0;
		try (Connection c = ConnectionFactory.getConnection();
		PreparedStatement st = c.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
				st.setString(1, user.getUsername());
				st.setString(2, user.getPassword());
				st.setString(3, user.getEmail());
	
				int affectedRows = st.executeUpdate();
				if(affectedRows> 0) {
					try(ResultSet rs = st.getGeneratedKeys()){
						if (rs.next()) {
									id = rs.getInt(1);
						}  
					}catch (SQLException e) {
									System.out.println(e.getMessage());
						} 
					}
					} catch (SQLException e) {
									System.out.println(e.getMessage());
						}
						return id;
	}

	@Override
	public Set<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readUsername(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existingUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
