package com.facade;

import java.util.List;

import javax.ejb.Local;
import com.model.TimerIA;

@Local
public interface TimerFacade {

	public abstract void save(TimerIA timer);
	public abstract void delete(TimerIA timer);
	public abstract TimerIA update(TimerIA timer);
	public abstract TimerIA find(int entityID);
	public TimerIA findTimerByEmail(String email);
	public abstract List<TimerIA> findListTimerByEmail(String emailIA);
	public abstract List<TimerIA> findAll();
}