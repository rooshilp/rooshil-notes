package cs.ualberta.ca.rooshil_notes;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class CounterActivity extends CounterListActivity {

	private Button reset, count, stats, rename, delete;
	private TextView countDisplay;
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
		// Show the Up button in the action bar.
		setupActionBar();
		reset = (Button) findViewById(R.id.reset);
		count = (Button) findViewById(R.id.count);
		stats = (Button) findViewById(R.id.Stats);
		rename = (Button) findViewById(R.id.rename);
		delete = (Button) findViewById(R.id.delete);
		countDisplay = (TextView) findViewById(R.id.textView1);
		
		reset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				counterListObject.getCounter(currentCounter).resetCount();
				saveToFile();
			}
		});
		
		count.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				counterListObject.getCounter(currentCounter).incrementCount();
				countDisplay.setText(counterListObject.getCounter(currentCounter).getCount().toString());
				saveToFile();
			}
		});
		
		stats.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(CounterActivity.this, CounterStatisticsActivity.class));
			}
		});
		
		rename.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(CounterActivity.this, CounterRenameActivity.class));
			}
		});
		
		delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				counterListObject.removeCounter(currentCounter);
				saveToFile();
				finish();
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		countDisplay.setText(counterListObject.getCounter(currentCounter).getCount().toString());
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.counter, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
