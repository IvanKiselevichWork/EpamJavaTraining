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

        String regexp = "\\b.+\\b";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(s);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String regexp1 = "([a-zA-Zа-яА-Я]{" + (k - 1) + "})([a-zA-Zа-яА-Я])";
            Pattern pattern1 = Pattern.compile(regexp1);
            Matcher matcher1 = pattern1.matcher(matcher.group(0));
            matcher.appendReplacement(stringBuffer, matcher1.replaceAll("$1" + c));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
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
     * @param source string
     * @param wordLength len
     * @param subString substring
     * @return transformed string
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

    /**
     *  Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
     * Между последовательностями подряд идущих букв оставить хотя бы один пробел.
     * @param source string
     * @return transformed string
     * @throws StringIsNullRuntimeException is source is null
     */
    public String subTask4(String source) throws StringIsNullRuntimeException {
        checkString(source);

        Pattern pattern = Pattern.compile("(\\b)([^a-zA-Zа-яА-Я ]+)(\\b)");
        Matcher matcher = pattern.matcher(source);
        source = matcher.replaceAll("$1 $3");

        return source;
    }

    /**
     * Из текста удалить все слова заданной длины, начинающиеся на согласную букву
     * @param source string
     * @param wordLength len
     * @return transformed string
     * @throws StringIsNullRuntimeException is source is null
     */
    public String subTask5(String source, int wordLength) throws StringIsNullRuntimeException {
        checkString(source);

        List<Character> chars = Arrays.asList(
                'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ');

        String regexp = "\\b[a-zA-Zа-яА-Я]{" + wordLength + "}\\b";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(source);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            if (chars.contains(matcher.group(0).charAt(0))) {
                matcher.appendReplacement(stringBuffer, "");
            } else {
                matcher.appendReplacement(stringBuffer, "$0");
            }

        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private void checkString(String s) throws StringIsNullRuntimeException {
        if (s == null) {
            throw new StringIsNullRuntimeException("string is null");
        }
    }

}
