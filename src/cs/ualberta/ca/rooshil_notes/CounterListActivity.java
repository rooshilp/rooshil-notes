package cs.ualberta.ca.rooshil_notes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/* 
 * CounterListActivity is the primary activity for the application.
 * It acts as a superclass to all other activities and provides 
 * functionality for IO to save and load data, counter tracking
 * to allow the app to know which counter to access and the counterListObject
 * attribute which is used to store all counters. It can initiate CounterActivity
 * and CreateCounterActivity.
 */

public class CounterListActivity extends Activity {

	private static String saveFile = "counterList.sav";
	protected static int currentCounter;
	protected static CounterListModel counterListObject;
	private ArrayAdapter<CounterModel> counterListAdapter;
	private ListView counterListView;
	private Button createCounter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createCounter = (Button) findViewById(R.id.newCounter);
		createCounter.setOnClickListener (new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(CounterListActivity.this, CreateCounterActivity.class));
			}
		});
		loadFromFile();
		counterListView = (ListView) findViewById(R.id.counterList);
		counterListAdapter = new ArrayAdapter<CounterModel>(CounterListActivity.this, android.R.layout.simple_list_item_1, counterListObject.getCounterList());
		counterListView.setAdapter(counterListAdapter);
		counterListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				CounterListActivity.this.setCurrentCounter(position);
				startActivity(new Intent(CounterListActivity.this, CounterActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		counterListAdapter.notifyDataSetChanged();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		counterListObject.sortCounterList();
		counterListAdapter.notifyDataSetChanged();
	}

	protected void saveToFile() {
		try {
			FileOutputStream fileoutputstream = openFileOutput(saveFile, 0);
			ObjectOutputStream objectoutputstream = new ObjectOutputStream(fileoutputstream);
			objectoutputstream.writeObject(counterListObject);
			objectoutputstream.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void loadFromFile() {
		clearCounterList();
		try {
			FileInputStream fileinputstream = openFileInput(saveFile);
			ObjectInputStream objectinputstream = new ObjectInputStream(fileinputstream);
			counterListObject = (CounterListModel) objectinputstream.readObject();
			objectinputstream.close();
		}
		catch (FileNotFoundException e) {
			counterListObject = new CounterListModel();
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void clearCounterList() {
		counterListObject = null;
	}
	
	
	protected void setCurrentCounter(int i) {
		currentCounter = i;
	}
	
	protected int getCurrentCounter() {
		return currentCounter;
	}
	
	protected void removeCurrentCounter() {
		counterListObject.removeCounter(currentCounter);
	}
}
