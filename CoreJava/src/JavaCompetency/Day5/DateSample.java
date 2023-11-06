package JavaCompetency.Day5;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {
// 	index the year from which you want, here index the year to 47
//	index Month with 0
//	index Date with 1
		Date date = new Date(47, 7, 15);
		System.out.println(date);
		
		LocalDate independenceDay = LocalDate.of(1947, 8, 15);
		System.out.println(independenceDay);
	}

}
