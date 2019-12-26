package by.javatr.task7.main;

import by.javatr.task7.unit.Unit;
import by.javatr.task7.entity.BirthdayData;

/**
7.  Создать приложение, получающее дату рождения (день, месяц и год) и определяющее в какой 
день недели Вы родились, сколько Вам полных лет и поздравляет с днем рождения, если оно 
сегодня (использовать класс Calendar из пакета java.util). 
 */
public class Main {
    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Must be 3 args");
            return;
        }
        
        int day, month, year;
        try {
            day = Integer.parseInt(args[0]);
            month = Integer.parseInt(args[1]);
            year = Integer.parseInt(args[2]);
        } catch(NumberFormatException e) {
            System.out.println("Invalid input");
            return;
        }

        BirthdayData birthdayData = Unit.getBirthdayData(day, month, year);

        System.out.println("Day of week: " + birthdayData.getDayOfWeek() + ", full years: " + birthdayData.getFullYears() + ", is birthday today: " + birthdayData.isBirthdayToday());
        
    }
}