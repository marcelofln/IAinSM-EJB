package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.UserDAO;
import com.model.User;

@Stateless
public class UserFacadeImp implements UserFacade {

	@EJB
	private UserDAO userDAO;
	
	@Override
	public void save(User user) {
		isUserWithAllData(user);
		userDAO.save(user);
		
	}

	@Override
	public User update(User user) {
		isUserWithAllData(user);
		return userDAO.update(user);
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);
		
	}

	@Override
	public User find(int entityID) {
		return userDAO.find(entityID);
	}
	
	@Override
	public List<User> findAll() {	
		return userDAO.findAll();
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}
	
	private void isUserWithAllData(User user) {
		boolean hasError = false;
		
		if(user == null){
			hasError = true;
		}
		
		if(user.getEmail()==null || "".equals(user.getEmail().trim())){
			hasError = true;
		}
		
		if(user.getName()==null || "".equals(user.getName().trim())){
			hasError = true;
		}
		
		if(user.getPassword()==null || "".equals(user.getPassword().trim())){
			hasError = true;
		}
	
		if(hasError){
			throw new IllegalArgumentException("Esta faltando dados para cadastrar usu‡rio.");
		}
	}
	

}
