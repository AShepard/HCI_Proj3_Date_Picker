package edu.ucsb.cs.cs185.aaronshepard;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;

public class HCI_Proj3_Date_PickerActivity extends Activity {
	private String m_from_string;
	private String m_to_string;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
	
	private void setDates() {
		int day, month, year, hour, minute;
		boolean am_time= false;
		
		TimePicker dp_date = (TimePicker)findViewById(R.id.tp_timePicker);
		
		/*
		 * get current date
		 */
		
		/*
		 * Get current time
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