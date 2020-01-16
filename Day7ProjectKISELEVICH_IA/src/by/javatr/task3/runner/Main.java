package by.javatr.task3.runner;

import by.javatr.task3.service.regexp.TextService;

public class Main {
    public static void main(String[] args) {

        TextService textService = new TextService();


        String s1 = "qwe ert tyurty";
        System.out.println(textService.subTask1(s1, 3, 'X'));


        String s2 = "РАБОТ РАЛИКИ РОЛЛ Р";
        System.out.println(textService.subTask2(s2));
/*
        String s3 = " sdf sdfg . FFD dsfg";
        System.out.println(textService.subTask3(s3, 3, "TEST"));

        String s4 = "a!ab!bqw!erttyy";
        System.out.println(textService.subTask4(s4));

        String s5 = " sdf sdfg . FFD dsfg йцу кен гшщ апр олд йцукен";
        System.out.println(textService.subTask5(s5, 3));

         */
    }
}
