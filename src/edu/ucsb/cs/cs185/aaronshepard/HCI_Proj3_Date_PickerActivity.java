package edu.ucsb.cs.cs185.aaronshepard;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class HCI_Proj3_Date_PickerActivity extends Activity {
	private final String FROMTEXT = "From: ";
	private final String TOTEXT = "To: ";
	
	private Button b_set;
	
	private TextView tv_from;
	private TextView tv_to;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tv_from = (TextView) findViewById(R.id.tv_from);
    	tv_to = (TextView) findViewById(R.id.tv_to);
    	
    	/*
    	 * set to and from fields to current date
    	 */
    	setDates();
    	
        b_set = (Button)findViewById(R.id.b_set);
        
        b_set.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				setDates();
			}
		});
    }
	
  //TODO
	private void setDates() {
		int day, month, year, hour, minute;
		boolean am_time= false;
		
		TimePicker dp_date = (TimePicker)findViewById(R.id.tp_timePicker);
		
		/*
		 * get entered date
		 */
		
		/*
		 * Get entered time
		 */
		minute = dp_date.getCurrentMinute();
		
		hour = dp_date.getCurrentHour();
		
		//get duration
		
		
		//set to date
		
	}
	
	//TODO
	private void getDateString(int day, int month, int year, int hour, int minute, String begin_str) {
		String date_string = "";
		
		date_string = date_string.concat(begin_str);
		date_string = date_string.concat(Integer.toString(day));
		date_string = date_string.concat("-");
		date_string = date_string.concat(Integer.toString(month));
		date_string = date_string.concat("-");
		date_string = date_string.concat(Integer.toString(year));
		date_string = date_string.concat(",");
		date_string = date_string.concat(Integer.toString(hour));
		date_string = date_string.concat(":");
		date_string = date_string.concat(Integer.toString(minute));
	}
	
	
}