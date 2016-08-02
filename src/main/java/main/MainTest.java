package main;

import ro.jademy.SixJars.Business.entities.User;
import ro.jademy.SixJars.Business.services.LoginService;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginService logServ = new LoginService();

		User user = logServ.doLogin("Ana", "12345");
		if (user != null) {
			System.out.println("e bine");
		} else {
			System.out.println("Nu exista in baza de date");

		}

	}
}
