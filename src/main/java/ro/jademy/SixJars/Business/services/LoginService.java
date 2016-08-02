package ro.jademy.SixJars.Business.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ro.jademy.SixJars.DAO.UserDAO;
import ro.jademy.SixJars.Business.entities.User;

public class LoginService {

	public User doLogin(String username, String password){
		
		TransactionManager transM = new TransactionManager();
		
		try{
			transM.beginTransaction();
			
			UserDAO userDAO = new UserDAO();
			User user = userDAO.getUserByUsername(username);
			
			if(username == null){
				return null;
			}
			if(!user.getPassword().equals(password)){
				return null;
			}
			transM.commit();
			return user;
			
			
			
		}catch (Exception e){
			transM.rollback();
			return null;
		}
	}
	
public boolean doRegister(User user){
		
		TransactionManager transMng = new TransactionManager();
		
		try{
			transMng.beginTransaction();
			
			UserDAO userDAO = new UserDAO();
			User userFromDB = userDAO.getUserByUsername(user.getUsername());

			if (userFromDB == null) {
				System.out.println("User does not exist. Start register!");
				userDAO.saveNewUserInDB(user);
				transMng.commit();
				return true;
			} else {
				System.out.println("User already in DB!");
				transMng.rollback();
				return false;
			}		
		} catch (Exception e){
			transMng.rollback();
			System.out.println(e.getMessage());
			return false;
		}
	}
}

	

