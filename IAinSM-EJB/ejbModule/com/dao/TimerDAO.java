package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.TimerIA;

@Stateless
public class TimerDAO extends GenericoDAO<TimerIA> {

	public TimerDAO() {
		super(TimerIA.class);
	}

	public TimerIA findTimerByEmail(String email){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		return super.findOneResult(TimerIA.FIND_TIMER_BY_EMAIL, parameters);
	}
	
	public List<TimerIA> findListTimerByEmail(String emailIA){
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("emailIA", emailIA);
		return super.findList(TimerIA.FIND_LIST_TIMER_BY_EMAIL, parameters);
		
	}
	
}
