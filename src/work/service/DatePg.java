package work.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DatePg {
		LocalDate now = LocalDate.now();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		Date today = new Date();
		
		
		
		
		
		public int getYear() {
			return year;
		}
		public int getMonth() {
			return month;
		}
		public Date getToday () {
			return today;
		}
		

}
