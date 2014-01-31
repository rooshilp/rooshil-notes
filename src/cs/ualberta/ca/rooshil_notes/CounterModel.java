package cs.ualberta.ca.rooshil_notes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CounterModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer count;
	private ArrayList<Date> countDates;
	
	public CounterModel(String name) {
		super();
		this.name = name;
		this.count = 0;
		this.countDates = new ArrayList<Date>();
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
		this.countDates = new ArrayList<Date>();
	}
	
	
	public void incrementCount() {
		this.count += 1;
		this.countDates.add(new Date());
	}
	
	public ArrayList<Date> getCountDates() {
		return countDates;
	}
	
	public ArrayList<String> getHourlyStatistics() {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		String[] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Nov", "Dec"};
		ArrayList<String> hourlyStats = new ArrayList<String>();
		for(Date date : countDates) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String hashKey = monthName[calendar.get(Calendar.MONTH)] + " " +
			calendar.get(Calendar.DAY_OF_MONTH) + ", " + calendar.get(Calendar.YEAR) + " - " +
			calendar.get(Calendar.HOUR_OF_DAY) + ":00";
			
			if (hashMap.containsKey(hashKey)) {
				hashMap.put(hashKey, hashMap.get(hashKey)+1);
			}
			else {
				hashMap.put(hashKey, 1);
			}
		}
		for(String hashKey : hashMap.keySet()) {
			hourlyStats.add(hashKey + " -> " + hashMap.get(hashKey));
		}
		return hourlyStats;
		
	}
	
	public ArrayList<String> getDailyStatistics() {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		String[] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Nov", "Dec"};
		ArrayList<String> dailyStats = new ArrayList<String>();
		for(Date date : countDates) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String hashKey = monthName[calendar.get(Calendar.MONTH)] + " " +
			calendar.get(Calendar.DAY_OF_MONTH) + ", " + calendar.get(Calendar.YEAR);
			
			if (hashMap.containsKey(hashKey)) {
				hashMap.put(hashKey, hashMap.get(hashKey)+1);
			}
			else {
				hashMap.put(hashKey, 1);
			}
		}
		for(String hashKey : hashMap.keySet()) {
			dailyStats.add(hashKey + " -> " + hashMap.get(hashKey));
		}
		return dailyStats;
	}
	
	public ArrayList<String> getWeeklyStatistics() {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		String[] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Nov", "Dec"};
		ArrayList<String> weeklyStats = new ArrayList<String>();
		for(Date date : countDates) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String hashKey = monthName[calendar.get(Calendar.MONTH)] + " Week " +
					calendar.get(Calendar.WEEK_OF_MONTH) + ", " + calendar.get(Calendar.YEAR);
			
			if (hashMap.containsKey(hashKey)) {
				hashMap.put(hashKey, hashMap.get(hashKey)+1);
			}
			else {
				hashMap.put(hashKey, 1);
			}
		}
		for(String hashKey : hashMap.keySet()) {
			weeklyStats.add(hashKey + " -> " + hashMap.get(hashKey));
		}
		return weeklyStats;
	}
	
	public ArrayList<String> getMonthlyStatistics() {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		String[] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Nov", "Dec"};
		ArrayList<String> monthlyStats = new ArrayList<String>();
		for(Date date : countDates) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String hashKey = monthName[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR);
			
			if (hashMap.containsKey(hashKey)) {
				hashMap.put(hashKey, hashMap.get(hashKey)+1);
			}
			else {
				hashMap.put(hashKey, 1);
			}
		}
		for(String hashKey : hashMap.keySet()) {
			monthlyStats.add(hashKey + " -> " + hashMap.get(hashKey));
		}
		return monthlyStats;
	}
	
	
}
