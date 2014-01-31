package cs.ualberta.ca.rooshil_notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * CounterListModel is an object used to store an ArrayList of CounterModels.
 * It also provides the ability to sort the ArrayList by number of counts.
 */

public class CounterListModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<CounterModel> counterList;

	CounterListModel() {
		super();
		counterList = new ArrayList<CounterModel>();
	}
	
	/*
	 * sortCounterList uses collections and a comparator to sort the list
	 * in decreasing order of counts.
	 * sortCounterList was inspired by a StackOverflow answer. Link in Readme.
	 */
	public void sortCounterList() {
		Collections.sort(counterList, new Comparator<CounterModel>() {
			@Override
			public int compare(CounterModel counter1, CounterModel counter2) {
				return counter2.getCount() - counter1.getCount();
			}
		});
	}

	public ArrayList<CounterModel> getCounterList() {
		return counterList;
	}

	public void  addCounter(String name) {
		counterList.add(new CounterModel(name));
	}
	
	public void removeCounter(int index) {
		counterList.remove(index);
	}
	
	public CounterModel getCounter(int index) {
		return counterList.get(index);
	}
}
