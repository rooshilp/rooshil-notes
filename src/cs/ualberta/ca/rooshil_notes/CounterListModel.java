package cs.ualberta.ca.rooshil_notes;

import java.util.ArrayList;


public class CounterListModel {
	private static ArrayList<CounterModel> counterList;

	public CounterListModel() {
		super();
		counterList = new ArrayList<CounterModel>();
	}

	public static ArrayList<CounterModel> getCounterList() {
		return counterList;
	}

	public void addCounter(CounterModel counterModel) {
		CounterListModel.counterList.add(counterModel);
	}
	
	public void removeCounter(CounterModel counterModel) {
		CounterListModel.counterList.remove(counterModel);
	}
	
}
