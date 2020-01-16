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
        StringBuilder stringBuilder = new StringBuilder(s.length());
        stringBuilder.append(s);
        for(int i = k; i < s.length(); i += k) {
            stringBuilder.setCharAt(i, c);
        }
        return stringBuilder.toString();
    }

    private void checkString(String s) throws StringIsNullRuntimeException {
        if (s == null) {
            throw new StringIsNullRuntimeException("string is null");
        }
    }

}
