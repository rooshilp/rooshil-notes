package cs.ualberta.ca.rooshil_notes;

import java.util.Date;

public class CounterModel {
	private String name;
	private Integer count;
	private Date createDate;
	
	public CounterModel(String name) {
		super();
		this.name = name;
		this.createDate = new Date();
		this.count = 0;
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
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void incrementCount() {
		this.count += 1;
	}
	
	
}
