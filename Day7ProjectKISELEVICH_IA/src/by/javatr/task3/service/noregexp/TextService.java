package by.javatr.task3.service.noregexp;

public class TextService {

    /**
     *  В каждом слове k-ю букву заменить заданным символом. Если k больше длины слова,
     * корректировку не выполнять.
     * @param s source string
     * @param k step
     * @param c char value will be set
     * @return transformed string
     */
    public String subTask1(String s, int k, char c) {
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
}
