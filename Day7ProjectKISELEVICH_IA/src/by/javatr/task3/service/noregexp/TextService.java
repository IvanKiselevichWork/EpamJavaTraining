package by.javatr.task3.service.noregexp;

import by.javatr.task1.entity.Array;
import by.javatr.task3.service.exception.StringIsNullRuntimeException;

import java.util.Arrays;
import java.util.List;

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

        if (k > s.length()) {
            return s;
        }
        StringBuilder stringBuilder = getStringBuilder(s);
        for(int i = k - 1; i < s.length(); i += k) {
            stringBuilder.setCharAt(i, c);
        }
        return stringBuilder.toString();
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

        StringBuilder stringBuilder = getStringBuilder(s);
        for(int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1) {
                if (s.charAt(i) == 'Р' && s.charAt(i + 1) == 'А') {
                    stringBuilder.setCharAt(i + 1, 'О');
                }
            }
        }
        return stringBuilder.toString();
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

        StringBuilder stringBuilder = new StringBuilder(source);

        String[] stringList = source.split("[ ,.!?]+");

        for (String s : stringList) {
            if (s.length() == wordLength) {
                int index = stringBuilder.indexOf(s);
                stringBuilder.replace(index, index + s.length(), subString);
            }
        }

        return stringBuilder.toString();
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

        StringBuilder stringBuilder = getStringBuilder(source);

        for(int i = 0; i < stringBuilder.length(); i++) {
            char c = stringBuilder.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                stringBuilder.deleteCharAt(i--);
            }
        }

        int oldCount = 0;
        for(int i = 0; i < stringBuilder.length(); i++) {
            char c = stringBuilder.charAt(i);
            if (c == ' ') {
                oldCount = 0;
                continue;
            }
            int index = i;
            int newCount = 1;
            i++;
            while (i < stringBuilder.length() && c == stringBuilder.charAt(i)) {
                i++;
                newCount++;
            }
            if (newCount != 1) {
                i--;
            }
            if (newCount > 1 && oldCount > 1) {
                stringBuilder.insert(index, ' ');
                i++;
            }

            oldCount = newCount;
        }

        return stringBuilder.toString();
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

        StringBuilder stringBuilder = getStringBuilder(source);
        List<Character> chars = Arrays.asList(
        'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
        'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ');


        String[] stringList = source.split("[ ,.!?]+");

        for (String s : stringList) {
            if (s.length() == wordLength && s.length() > 0 && chars.contains(s.charAt(0)) ) {
                int index = stringBuilder.indexOf(s);
                stringBuilder.delete(index, index + s.length());
            }
        }

        return stringBuilder.toString();


    }

    private void checkString(String s) throws StringIsNullRuntimeException {
        if (s == null) {
            throw new StringIsNullRuntimeException("string is null");
        }
    }

    /**
     * for lower memory use
     * (if we use new StringBuilder(s) allocates s.length() + 16 elements)
     * @param s source string
     * @return StringBiulder object of source string
     */
    private StringBuilder getStringBuilder(String s) {
        StringBuilder stringBuilder = new StringBuilder(s.length());
        stringBuilder.append(s);
        return stringBuilder;
    }

}
