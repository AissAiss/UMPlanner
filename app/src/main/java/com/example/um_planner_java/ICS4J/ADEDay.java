package com.example.um_planner_java.ICS4J;

import java.util.ArrayList;
import java.util.List;

public class ADEDay {
	// Une date TODO : Mettre ca dans une classe. 
	private int day; 
	private int month; 
	private int year; 
	
	// Une list d'evenement
	private List<ADEEvent> Events; 
	
	public ADEDay(ADEDate Date) {
		this.Events = new ArrayList<ADEEvent>(); 
		
		this.day 	= Date.getDay(); 
		this.month	= Date.getMonth(); 
		this.year	= Date.getYear(); 
	}
	
	public void add(ADEEvent Event) {
		this.Events.add(Event); 
	}
	
	public List<ADEEvent> getAllEvents() {
		return this.Events; 
	}
	

	public String getDate() {
		return 	((day 	< 10)? "0" + Integer.toString(day)		: Integer.toString(day)) + "/" + 
				((month < 10)? "0" + Integer.toString(month)	: Integer.toString(month)) + "/" + 
				((year 	< 10)? "0" + Integer.toString(year)		: Integer.toString(year));
	}

	@Override
	public String toString() {
		return "ADEDay [" + this.getDate() + " Nombre d'evenements : " + this.Events.size()  +"]";
	}
	
	

}
