package com.learning.rough;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Custom_Dates {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 5); // Adding 5 days
		String output = sdf.format(c.getTime());
		System.out.println(output);
	}
}
