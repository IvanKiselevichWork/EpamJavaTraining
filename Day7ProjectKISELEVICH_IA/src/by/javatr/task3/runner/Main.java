package by.javatr.task3.runner;

import by.javatr.task3.input.TextInput;
import by.javatr.task3.service.regexp.TextService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            TextService textService = new TextService();
            TextInput textInput = new TextInput();

            String s1 = textInput.inputTextFromConsole();//"qwe ert tyurty";
            System.out.println(textService.subTask1(s1, 3, 'X'));


            String s2 = textInput.inputTextFromFile("2.txt");//"РАБОТ РАЛИКИ РОЛЛ Р";
            System.out.println(textService.subTask2(s2));

            String s3 = " sdf sdfg . FFD dsfg";
            System.out.println(textService.subTask3(s3, 3, "TEST"));

            String s4 = "a!ab!bqw!ertttttyyyyyy";
            System.out.println(textService.subTask4(s4));

            String s5 = " sdf sdfg . FFD dsfg йцу кен гшщ апр олд йцукен";
            System.out.println(textService.subTask5(s5, 3));
        } catch (IOException e) {
            System.out.println("Internal error!");
        }
    }
}
