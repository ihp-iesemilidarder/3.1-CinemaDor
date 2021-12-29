package com.cinema.service;

import java.util.HashMap;

import com.cinema.dto.User;

public class AutheticationService {
	
	HashMap<String, User> dadesUsuaris = new HashMap<>();

	public AutheticationService() {
		dadesUsuaris.put("pedro", new User("pedro", "pass1", "Pedro Sánchez"));
		dadesUsuaris.put("joan", new User("joan", "pass2", "Joan Nicolau"));
		dadesUsuaris.put("xavi", new User("xavi", "pass3", "Xavi Pérez"));
	}
	
	public User getUsuari (String userId) {
		return dadesUsuaris.get(userId);
	
	}
	public boolean existUsuari (String userId) {
		return dadesUsuaris.containsKey(userId);
	
	}
	public boolean validUser (String userId, String userPass ) {
		
		if (dadesUsuaris.containsKey(userId)) {
			User usuari = dadesUsuaris.get(userId);
			String pass = usuari.getUserPassword();
			return (pass.equals(userPass));
		}else{
			return false;
		}
		
	
	}	
	

}
