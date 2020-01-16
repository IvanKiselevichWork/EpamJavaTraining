package by.javatr.task3.service.regexp;

import by.javatr.task3.service.exception.StringIsNullRuntimeException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService {

    /**
     *  В каждом слове k-ю букву заменить заданным символом. Если k больше длины слова,
     * корректировку не выполнять.
     * @param s source string
     * @param k step
     * @param c char value will be set
     * @return transformed string
     * @throws StringIsNullRuntimeException if string is null
     */
    public String subTask1(String s, int k, char c) throws StringIsNullRuntimeException {
        checkString(s);

        String regexp = "([a-zA-Zа-яА-Я]{" + (k - 1) + "})([a-zA-Zа-яА-Я]{1})";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(s);
        return matcher.replaceAll("$1" + c);
    }

    /**
     * В тексте после буквы Р, если она не последняя в слове, ошибочно напечатана буква А
     * вместо О. Внести исправления в текст.
     * @param s source string
     * @return transformed string
     * @throws StringIsNullRuntimeException if string is null
     */
    public String subTask2(String s) throws StringIsNullRuntimeException {
        checkString(s);

        Pattern pattern = Pattern.compile("(Р)(А)");
        Matcher matcher = pattern.matcher(s);
        return matcher.replaceAll("$1" + 'О');
    }

    /**
     * В тексте слова заданной длины заменить указанной подстрокой, длина которой может
     * не совпадать с длиной слова.
     * @param source
     * @param wordLength
     * @param subString
     * @return
     * @throws StringIsNullRuntimeException if source or subString is null
     */
    public String subTask3(String source, int wordLength, String subString) throws StringIsNullRuntimeException {
        checkString(source);
        checkString(subString);

        String regexp = "([^a-zA-Zа-яА-Я]+)([a-zA-Zа-яА-Я]{" + wordLength + "})([^a-zA-Zа-яА-Я]+)";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(source);
        return matcher.replaceAll("$1" + subString + "$3");
    }

    private void checkString(String s) throws StringIsNullRuntimeException {
        if (s == null) {
            throw new StringIsNullRuntimeException("string is null");
        }
    }

}
