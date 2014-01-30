package cs.ualberta.ca.rooshil_notes;

import java.util.Calendar;
import java.util.ArrayList;

public class CounterModel {
	private String name;
	private Integer count;
	private ArrayList<Calendar> countDates;
	
	public CounterModel(String name) {
		super();
		this.name = name;
		this.count = 0;
		this.countDates = new ArrayList<Calendar>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void resetCount() {
		this.count = 0;
		this.countDates = new ArrayList<Calendar>();
	}
	
	
	public void incrementCount() {
		this.count += 1;
		this.countDates.add(Calendar.getInstance());
	}
	
	public ArrayList<Calendar> getCountDates() {
		return countDates;
	}
	
	public ArrayList<String> getHourlyStatistics() {
		
	}
	
	public ArrayList<String> getDailyStatistics() {
		
	}
	
	public ArrayList<String> getMonthlyStatistics() {
		
	}
	
	
}
