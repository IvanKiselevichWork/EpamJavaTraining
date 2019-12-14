package by.javatr.task1.main;

/**
1.  Создать класс Hello, который будет приветствовать любого пользователя при вводе его имени 
через командную строку. 
 */
public class Hello {
    public static void main(String[] args) {
        String name = null;
        if (args.length != 0) {
            name = args[0];
        }
        if (name == null) {
            name = "anonim";
        }
        System.out.println("Hello, " + name + "!");
    }
}