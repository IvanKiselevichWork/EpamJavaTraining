package by.javatr.task3.runner;

import by.javatr.task3.input.TextInput;
import by.javatr.task3.service.noregexp.TextService;

public class Main {
    public static void main(String[] args) {
        try {
            TextService textServiceNoRegExp = new TextService();
            by.javatr.task3.service.regexp.TextService textServiceRegExp = new by.javatr.task3.service.regexp.TextService();
            TextInput textInput = new TextInput();

            String s1 = textInput.inputTextFromConsole();//"qwe ert tyurty";
            System.out.println("Subtask 1 source: " + s1);
            System.out.println("Subtask 1 noregexp: " + textServiceNoRegExp.subTask1(s1, 3, 'X'));
            System.out.println("Subtask 1 regexp  : " + textServiceRegExp.subTask1(s1, 3, 'X'));


            String s2 = textInput.inputTextFromFile("2.txt");//"РАБОТ РАЛИКИ РОЛЛ Р";
            System.out.println("Subtask 2 source: " + s2);
            System.out.println("Subtask 2 noregexp: " + textServiceNoRegExp.subTask2(s2));
            System.out.println("Subtask 2 regexp  : " + textServiceRegExp.subTask2(s2));

            String s3 = " sdf sdfg . FFD dsfg";
            System.out.println("Subtask 3 source: " + s3);
            System.out.println("Subtask 3 noregexp: " + textServiceNoRegExp.subTask3(s3, 3, "TEST"));
            System.out.println("Subtask 3 regexp  : " + textServiceRegExp.subTask3(s3, 3, "TEST"));

            String s4 = "a!ab!bqw!erttt----ttyy-----yyyy";
            System.out.println("Subtask 4 source: " + s4);
            System.out.println("Subtask 4 noregexp: " + textServiceNoRegExp.subTask4(s4));
            System.out.println("Subtask 4 regexp  : " + textServiceRegExp.subTask4(s4));

            String s5 = " sdf sdfg . FFD dsfg йцу кен гшщ апр олд йцукен";
            System.out.println("Subtask 5 source: " + s5);
            System.out.println("Subtask 5 noregexp: " + textServiceNoRegExp.subTask5(s5, 3));
            System.out.println("Subtask 5 regexp  : " + textServiceRegExp.subTask5(s5, 3));
        } catch (Exception e) {
            System.out.println("Internal error!");
        }
    }
}
