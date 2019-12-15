package by.javatr.task7.unit;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import by.javatr.task7.entity.BirthdayData;

public class Unit {
    public static BirthdayData getBirthdayData(int day, int month, int year) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        //todo remove debug
        /*
        String dateStr = calendar.getTime().toString();
        System.out.println(dateStr);
        */

        String dayOfWeek = new SimpleDateFormat("EE").format(calendar.getTime());

        Calendar now = Calendar.getInstance();

        long timeCalendar = calendar.getTime().getTime();
        long timeNow = now.getTime().getTime();

        //todo remove debug
        /*
        double temp1 = (timeNow - timeCalendar) / (1000. * 60. * 60. * 24. * 365.242199);
        System.out.println("temp1 = " + temp1);
        */

        int fullYears = (int) ((timeNow - timeCalendar) / (1000. * 60. * 60. * 24. * 365.242199));

        int monthNow = now.get(Calendar.MONTH);
        int dayOfMonthNow = now.get(Calendar.DAY_OF_MONTH);
        boolean isBirthdayToday = false;
        if (monthNow == (month - 1) && day == dayOfMonthNow) {
            isBirthdayToday = true;
        }

        return new BirthdayData(dayOfWeek, fullYears, isBirthdayToday);
    }
}