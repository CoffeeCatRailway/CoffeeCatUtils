package coffeecatteam.coffeecatutils.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author CoffeeCatRailway
 * Created: 20/12/2018
 */
public class CatLogger {

    private String loggerName;

    public CatLogger() {
        this(Thread.currentThread());
    }

    public CatLogger(Thread thread) {
        this(thread.getName());
    }

    public CatLogger(String loggerName) {
        this.loggerName = loggerName.replace("\\s+", "_");
        if (CatLoggerUtils.logFileIsNull())
            CatLoggerUtils.init();
    }

    /**
     * Print an empty line
     */
    public void println() {
        print(MessageType.NONE, "");
    }

    /**
     * Print an exception
     */
    public void error(Throwable throwable) {
        print(MessageType.ERROR, throwable.getMessage());
    }

    /**
     * @param msg Print a error message to console
     */
    public void error(Object msg) {
        print(MessageType.ERROR, msg);
    }

    /**
     * @param msg Print a message to console
     */
    public void info(Object msg) {
        print(MessageType.INFO, msg);
    }

    /**
     * @param msg Print a warning message to console
     */
    public void warn(Object msg) {
        print(MessageType.WARN, msg);
    }

    /**
     * @param msg   Print a message to console
     */
    public void print(MessageType type, Object msg) {
        String msgString = CatLoggerUtils.getPrefix(loggerName) + "[" + type + "] " + String.valueOf(msg);

        if (CatLoggerUtils.logFileIsNull())
            CatLoggerUtils.init();

        String border = "---------------" + type + "---------------";
        switch (type) {
            case NONE:
                System.out.println();
                break;
            case INFO:
                System.out.println(msgString);
                writeLog(msgString);
                break;
            case WARN:
                System.out.println(border);
                writeLog(border);

                System.out.println(msgString);
                writeLog(msgString);
                break;
            case ERROR:
                System.out.println(border);
                writeLog(border);

                System.out.println(msgString);
                writeLog(msgString);
                break;
        }
    }

    private void writeLog(String msg) {
        if (CatLoggerUtils.OUTPUT_LOG) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(CatLoggerUtils.LOG_FILE, true));
                writer.append(msg);
                if (msg.contains("\\n") || msg.contains("\n"))
                    writer.newLine();
                writer.newLine();

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private enum MessageType {
        NONE, INFO, WARN, ERROR
    }
}
