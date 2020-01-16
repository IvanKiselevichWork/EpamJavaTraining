package by.javatr.task3.service.noregexp;

import by.javatr.task3.service.exception.StringIsNullRuntimeException;

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

        if (k >= s.length()) {
            return s;
        }
        StringBuilder stringBuilder = getStringBuilder(s);
        for(int i = k; i < s.length(); i += k) {
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

    private void checkString(String s) throws StringIsNullRuntimeException {
        if (s == null) {
            throw new StringIsNullRuntimeException("string is null");
        }
    }

    /**
     * for lower memory use
     * (if we use new StringBuilder(s) allocates s.length() + 16 elements)
     * @param s
     * @return
     */
    private StringBuilder getStringBuilder(String s) {
        StringBuilder stringBuilder = new StringBuilder(s.length());
        stringBuilder.append(s);
        return stringBuilder;
    }

}
