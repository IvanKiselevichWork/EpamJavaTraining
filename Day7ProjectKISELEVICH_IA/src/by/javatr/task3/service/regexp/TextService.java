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

    /**
     *  Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
     * Между последовательностями подряд идущих букв оставить хотя бы один пробел.
     * @param source
     * @return
     * @throws StringIsNullRuntimeException
     */
    public String subTask4(String source) throws StringIsNullRuntimeException {
        checkString(source);

        Pattern pattern = Pattern.compile("[^a-zA-Zа-яА-Я ]+");
        Matcher matcher = pattern.matcher(source);
        source = matcher.replaceAll("");

        String regexp = "([a-zA-Zа-яА-Я]{1})\\1+([a-zA-Zа-яА-Я]{1})\\2+";
        pattern = Pattern.compile(regexp);
        matcher = pattern.matcher(source);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            int spaceIndex = matcher.group(0).indexOf(matcher.group(2));
            matcher.appendReplacement(stringBuffer, new StringBuilder(matcher.group(0)).insert(spaceIndex, " ").toString());
        }
        return stringBuffer.toString();
    }

    /**
     * Из текста удалить все слова заданной длины, начинающиеся на согласную букву
     * @param source
     * @param wordLength
     * @return
     * @throws StringIsNullRuntimeException
     */
    public String subTask5(String source, int wordLength) throws StringIsNullRuntimeException {
        checkString(source);

        List<Character> chars = Arrays.asList(
                'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ');

        StringBuilder regexp = new StringBuilder();
        regexp.append("([^a-zA-Zа-яА-Я]+)([");
        for (char c : chars) {
            regexp.append(c);
        }
        regexp.append("]{1}[a-zA-Zа-яА-Я]{");
        regexp.append(wordLength - 1);
        regexp.append("})([^a-zA-Zа-яА-Я]+)");

        Pattern pattern = Pattern.compile(regexp.toString());
        Matcher matcher = pattern.matcher(source);
        return matcher.replaceAll("$1$3");
    }

    private void checkString(String s) throws StringIsNullRuntimeException {
        if (s == null) {
            throw new StringIsNullRuntimeException("string is null");
        }
    }

}
