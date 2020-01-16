package by.javatr.task3.runner;

import by.javatr.task3.service.noregexp.TextService;

public class Main {
    public static void main(String[] args) {

        TextService textService = new TextService();

        String s1 = "123456789000";
        System.out.println(textService.subTask1(s1, 3, 'X'));

        String s2 = "РАБОТ РАЛИКИ РОЛЛ Р";
        System.out.println(textService.subTask2(s2));
    }
}
