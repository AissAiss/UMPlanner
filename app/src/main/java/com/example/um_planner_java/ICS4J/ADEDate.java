package com.example.um_planner_java.ICS4J;

public class ADEDate implements Comparable<ADEDate>{
	// Date
	public int day; 
	public int month; 
	public int year; 
	
	// Heure; 
	public int hour; 
	public int minute; 
	
	public ADEDate(int day, 
				   int month, 
				   int year, 
				   int hour, 
				   int minute) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
	}
	
	public ADEDate(int day, int month, int year) {
		this(day, month, year, 0, 0); 
	}
	
	public ADEDate() {
		this(0, 0, 0, 0, 0); 
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getStringDate() {
		return 	((day 	< 10)? "0" + Integer.toString(day)		: Integer.toString(day)) + "/" +
				((month < 10)? "0" + Integer.toString(month)	: Integer.toString(month)) + "/" + 
				((year 	< 10)? "0" + Integer.toString(year)		: Integer.toString(year)); 
	}
	
	public String getStringHour() {
		return 	((hour 	< 10)? "0" + Integer.toString(hour)		: Integer.toString(hour)) + ":" + 
				((minute < 10)? "0" + Integer.toString(minute)	: Integer.toString(minute)); 
	}
	
	@Override
	public String toString() {
		return "ADEDate [" + this.getStringDate() + " " + this.getStringHour() + "]";
	}

	@Override
	public int compareTo(ADEDate o) {
		int diff = this.getYear() - o.getYear(); 
		
		if(diff != 0)
			return diff; 
		
		diff = this.getMonth() - o.getMonth(); 
		if(diff != 0)
			return diff; 
		
		diff = this.getDay() - o.getDay(); 
		if(diff != 0)
			return diff;
		
		diff = this.getHour() - o.getHour(); 
		if(diff != 0)
			return diff;
		
		diff = this.getMinute() - o.getMinute(); 
		if(diff != 0)
			return diff;
		
		return 0;
	}

}
