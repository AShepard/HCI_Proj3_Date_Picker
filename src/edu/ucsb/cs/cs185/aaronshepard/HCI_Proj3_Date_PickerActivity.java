package edu.ucsb.cs.cs185.aaronshepard;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
	
	private DatePicker dp_date;
	private TimePicker tp_time;
	
	private NumberPicker np_hour;
	private NumberPicker np_minute;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        dp_date = (DatePicker)findViewById(R.id.dp_date);
		tp_time = (TimePicker)findViewById(R.id.tp_time);
		
        np_hour = (NumberPicker)findViewById(R.id.np_hour);
		np_minute = (NumberPicker)findViewById(R.id.np_minute);
		/*
		 * set number picker min/masx values
		 */
		np_hour.setMaxValue(47);
		np_hour.setMinValue(0);
		
		np_minute.setMaxValue(59);
		np_hour.setMinValue(0);
		
		//set date constraints
		// http://stackoverflow.com/questions/5296919/setting-minimum-year-in-calendar
		Calendar start = new GregorianCalendar(2004, Calendar.JANUARY, 1);
		/*
		start.add(Calendar.YEAR, 2004);
		start.add(Calendar.MONTH, Calendar.JANUARY);
		start.add(Calendar.DAY_OF_MONTH, 1);
		*/
		
		Calendar end = new GregorianCalendar(2012, Calendar.DECEMBER, 31);
		//end.add(Calendar.YEAR, 2012);
		//end.add(Calendar.MONTH, Calendar.DECEMBER);
		//end.add(Calendar.DAY_OF_MONTH, 31);
		
		long start_time = start.getTimeInMillis();
		long end_time = end.getTimeInMillis();
		
		dp_date.setMinDate(start_time);
		dp_date.setMaxDate(end_time);
		
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
	
	private void setDates() {
		String from_text, to_text;
		int from_day, from_month, from_year, from_hour, from_minute;
		int duration_hour, duration_minute;
		boolean am_time= false;
		
		/*
		 * get entered date
		 */
		from_day = dp_date.getDayOfMonth();
		from_month = dp_date.getMonth();
		from_year = dp_date.getYear();
		/*
		 * Get entered time
		 */
		from_minute = tp_time.getCurrentMinute();
		from_hour = tp_time.getCurrentHour();
		
		from_text = getDateString(from_day, from_month, from_year, from_hour, from_minute, FROMTEXT);
		tv_from.setText(from_text);
		
		/*
		 * Get duration
		 */
		duration_hour = np_hour.getValue();
		duration_minute = np_minute.getValue();
		
		/*
		 * calculate To date
		 */
		
		int to_day, to_month, to_year, to_hour, to_minute;
		
		//first calculate new minute
		int overflow = 0;
		
		to_minute = from_minute + duration_minute;
		if(to_minute > 59) {
			//ex: 80 -60 = 20
			to_minute = to_minute - 60;
			//overflow cannot be greater than 1
			overflow = 1;
		}
		
		//calculate new hour
		to_hour = from_hour + duration_hour + overflow;
		overflow = 0;
		if(to_hour > 47) {
			to_hour = to_hour - 48;
			overflow = 2;
		} else if(to_hour > 23) {
			to_hour = to_hour - 24;
			overflow = 1;
		}
		
		int days_in_month = getDays(from_month);
		//calculate new day
		to_day = from_day + overflow;
		overflow =0;
		
		//if new month
		if(to_day > days_in_month) {
			to_day = to_day - days_in_month;
			overflow = 1;
		}
		
		//calculate new month
		to_month = from_month = overflow;
		
		//if new year
		if(to_month > 12) {
			to_month = to_month - 1;
			overflow = 1;
		}
		
		//calculate new year
		to_year = from_year + overflow;
	}
	
	private int getDays(int month) {
		int num_days = 0;
		switch(month) {
			case Calendar.JANUARY: 
				num_days = 31;
				break;
			case Calendar.FEBRUARY: 
				num_days = 28;
				break;
			case Calendar.MARCH: 
				num_days = 31;
				break;
			case Calendar.APRIL: 
				num_days = 30;
				break;
			case Calendar.MAY: 
				num_days = 31;
				break;
			case Calendar.JUNE: 
				num_days = 30;
				break;
			case Calendar.JULY: 
				num_days = 31;
				break;
			case Calendar.AUGUST: 
				num_days = 31;
				break;
			case Calendar.SEPTEMBER: 
				num_days = 30;
				break;
			case Calendar.OCTOBER: 
				num_days = 31;
				break;
			case Calendar.NOVEMBER: 
				num_days = 30;
				break;
			case Calendar.DECEMBER: 
				num_days = 31;
				break;
			default:
				num_days = -1;
		}
		
		return num_days;
	}
	private String getDateString(int day, int month, int year, int hour, int minute, String begin_str) {
		String date_string = "";
		
		date_string = date_string.concat(begin_str);
		date_string = date_string.concat(Integer.toString(day));
		date_string = date_string.concat("-");
		//change month from zero based
		date_string = date_string.concat(Integer.toString(month+1));
		date_string = date_string.concat("-");
		date_string = date_string.concat(Integer.toString(year));
		date_string = date_string.concat(",");
		date_string = date_string.concat(Integer.toString(hour));
		date_string = date_string.concat(":");
		date_string = date_string.concat(Integer.toString(minute));
		
		return date_string;
	}
	
	
}