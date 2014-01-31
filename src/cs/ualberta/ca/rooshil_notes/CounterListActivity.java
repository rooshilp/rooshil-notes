package cs.ualberta.ca.rooshil_notes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class CounterListActivity extends Activity {

	private static String saveFile = "counterList.sav";
	private static int currentCounter;
	private static CounterListModel counterList;
	private ArrayAdapter<CounterModel> counterListAdapter;
	private ListView counterListView;
	private Button createCounter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createCounter = (Button) findViewById(R.id.newCounter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	protected void saveToFile() {
		try {
			FileOutputStream fileoutputstream = openFileOutput(saveFile, 0);
			ObjectOutputStream objectoutputstream = new ObjectOutputStream(fileoutputstream);
			objectoutputstream.writeObject(counterList);
			objectoutputstream.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void loadFromFile() {
		try {
			FileInputStream fileinputstream = openFileInput(saveFile);
			ObjectInputStream objectinputstream = new ObjectInputStream(fileinputstream);
			counterList = (CounterListModel) objectinputstream.readObject();
			objectinputstream.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void clearCounterList() {
		counterList = null;
	}
	
	private void createNewCounterList() {
		counterList = new CounterListModel();
	}
	
	protected void setCurrentCounter(int i) {
		currentCounter = i;
	}
	
	protected int getCurrentCounter() {
		return currentCounter;
	}
	
	protected void removeCurrentCounter() {
		counterList.removeCounter(currentCounter);
	}
}
