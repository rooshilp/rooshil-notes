package cs.ualberta.ca.rooshil_notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CounterListModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private static ArrayList<CounterModel> counterList;

	CounterListModel() {
		super();
		counterList = new ArrayList<CounterModel>();
	}
	
	public void sortCounterList() {
		Collections.sort(CounterListModel.counterList, new Comparator<CounterModel>() {
			@Override
			public int compare(CounterModel counter1, CounterModel counter2) {
				return counter1.getCount() - counter2.getCount();
			}
		});
	}

	public ArrayList<CounterModel> getCounterList() {
		return counterList;
	}

	public static void  addCounter(String name) {
		CounterListModel.counterList.add(new CounterModel(name));
	}
	
	public static void removeCounter(int index) {
		CounterListModel.counterList.remove(index);
	}
	
	public static CounterModel getCounter(int index) {
		return CounterListModel.counterList.get(index);
	}
}
