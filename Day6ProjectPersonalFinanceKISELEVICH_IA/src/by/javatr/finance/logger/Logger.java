package by.javatr.finance.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Logger {

    public enum LogLevel {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private Class<?> targetClass;
    private LogWriter logWriter;

    public static Logger getLogger(Class<?> targetClass) {
        //todo make loggers list (map), and if logger for class exist not create, but return reference
        return new Logger(targetClass);
    }

    private Logger(Class<?> targetClass) {
        this.targetClass = targetClass;
        logWriter = LogWriter.getInstance();
    }

    public void debug(String message) {
        writeLog(message, LogLevel.DEBUG);
    }

    public void info(String message) {
        writeLog(message, LogLevel.INFO);
    }

    public void warning(String message) {
        writeLog(message, LogLevel.WARNING);
    }

    public void error(String message) {
        writeLog(message, LogLevel.ERROR);
    }

    public void writeLog(String message, LogLevel logLevel) {
        StringBuffer stringBuffer = createMessage(message, logLevel);
        logWriter.write(stringBuffer.toString());
    }

    private StringBuffer createMessage(String message, LogLevel logLevel) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(logLevel.toString());
        stringBuffer.append(" ; ");
        stringBuffer.append(LocalDateTime.now());
        stringBuffer.append(" ; ");
        stringBuffer.append("Class name: ");
        stringBuffer.append(targetClass.getName());
        stringBuffer.append(" ; ");
        stringBuffer.append(message);
        stringBuffer.append(" ; \n");
        return stringBuffer;
    }

    private static class LogWriter {
        private static class LogWriterHolder {
            private static LogWriter instance = new LogWriter();
        }

        public static LogWriter getInstance() {
            return LogWriterHolder.instance;
        }

        private static final String LOG_FILEPATH = "log.txt";

        private LogWriter() {
        }

        public void write(String message) {
            try {
                Files.write(Paths.get(LOG_FILEPATH), message.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException ignored) {

            }
        }
    }
}
