package ro.jademy.SixJars.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ro.jademy.SixJars.Business.entities.User;
import ro.jademy.SixJars.Business.services.TransactionManager;

public class UserDAO {

	public User getUserByUsername(String username) {

		String usernameRegister = " ";
		String passwordRegister = " ";
		String emailRegister = " ";

		Connection connection = new TransactionManager().getConnection();

		String str = "select username and password from users where username = ?";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usernameRegister = rs.getString("username");
				passwordRegister = rs.getString("password");
				emailRegister = rs.getString("email");
				System.out.println("Username from DB: " + usernameRegister);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Cannot execute querry", e);
		}

		if (usernameRegister == null) {
			System.out.println("User doesn't exist!");
			return null;
		} else {
			User user = new User(usernameRegister, passwordRegister, emailRegister);
			return user;
		}

	}

	public void saveNewUserInDB(User user) {

		Connection connection = new TransactionManager().getConnection();

		String sql = "INSERT INTO user(username, password, email,) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(6, user.getEmail());
			ps.executeUpdate();
			System.out.println("User registered in DB");
		} catch (SQLException e) {
			throw new RuntimeException("Cannot insert user into DB", e);
		}
	}

}
