package com.example.um_planner_java.ICS4J;

import java.util.ArrayList;
import java.util.List;

public class ADEDay implements Comparable<ADEDay> {
	// Une date TODO : Mettre ca dans une classe. 
	ADEDate Date; 
	
	// Une list d'evenement
	private List<ADEEvent> Events; 
	
	public ADEDay(ADEDate Date) {
		this.Events = new ArrayList<ADEEvent>(); 
		this.Date = Date; 
	}
	
	public void add(ADEEvent Event) {
		this.Events.add(Event); 
	}
	
	public List<ADEEvent> getAllEvents() {
		return this.Events; 
	}
	

	public String getStringDate() {
		return 	((this.Date.getDay() 	< 10)? "0" + Integer.toString(this.Date.getDay())	: Integer.toString(this.Date.getDay())) + "/" + 
				((this.Date.getMonth() 	< 10)? "0" + Integer.toString(this.Date.getMonth())	: Integer.toString(this.Date.getMonth())) + "/" + 
				((this.Date.getYear() 	< 10)? "0" + Integer.toString(this.Date.getYear())	: Integer.toString(this.Date.getYear() ));
	}

	@Override
	public String toString() {
		return "ADEDay [" + this.getDate() + " Nombre d'evenements : " + this.Events.size()  +"]";
	}
	
	

	public int getDay() {
		return this.Date.getDay();
	}

	public int getMonth() {
		return this.Date.getMonth();
	}

	public int getYear() {
		return this.Date.getYear();
	}
	
	public ADEDate getDate() {
		return this.Date; 
	}

	@Override
	public int compareTo(ADEDay o) {
		return this.Date.compareTo(o.getDate());
	}
	
	

}
