package by.javatr.task6.main;

import by.javatr.task6.unit.Unit;

import java.util.Calendar;

/**
6.  Приложение, выводящее фамилию разработчика и за сколько дней готов выполнить задание. 
Необходимо  рассчитать  дату  и  время  сдачи  задания.  Для  получения  даты  и  времени 
использовать класс Calendar из пакета java.util
 */
public class Main {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Must be 2 args");
            return;
        }
        
        String name = args[0];
        int duration;
        try {
            duration = Integer.parseInt(args[1]);
        } catch(NumberFormatException e) {
            System.out.println("Invalid input");
            return;
        }

        Calendar resultDate = Unit.getResultDate(duration);

        System.out.println("Name: " + name + ", result date: " + resultDate.getTime());
        
    }
}