package cs.ualberta.ca.rooshil_notes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

/*
 * The CounterStatisticsActivity provides statistics view of any counter.
 * Statistics are recieved from the CounterModel object directly and displayed
 * into a text field.
 */

public class CounterStatisticsActivity extends CounterListActivity {

	private Button hourly, daily, weekly, monthly;
	private TextView statview;
	private String newstring;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter_statistics);
		// Show the Up button in the action bar.
		setupActionBar();
		
		hourly = (Button) findViewById(R.id.hourly);
		daily = (Button) findViewById(R.id.daily);
		weekly = (Button) findViewById(R.id.weekly);
		monthly = (Button) findViewById(R.id.monthly);
		statview = (TextView) findViewById(R.id.statview);
		
		hourly.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				newstring = "";
				for (String string : counterListObject.getCounter(currentCounter).getHourlyStatistics()) {
					newstring = newstring + string + "\n";
				}
				statview.setText(newstring);
			}
		});
		
		daily.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				newstring = "";
				for (String string : counterListObject.getCounter(currentCounter).getDailyStatistics()) {
					newstring = newstring + string + "\n";
				}
				statview.setText(newstring);
			}
		});
		
		weekly.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				newstring = "";
				for (String string : counterListObject.getCounter(currentCounter).getWeeklyStatistics()) {
					newstring = newstring + string + "\n";
				}
				statview.setText(newstring);
			}
		});
		
		monthly.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				newstring = "";
				for (String string : counterListObject.getCounter(currentCounter).getMonthlyStatistics()) {
					newstring = newstring + string + "\n";
				}
				statview.setText(newstring);
			}
		});
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
		getMenuInflater().inflate(R.menu.counter_statistics, menu);
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
