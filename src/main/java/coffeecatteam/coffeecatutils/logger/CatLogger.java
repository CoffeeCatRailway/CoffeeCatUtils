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
    public void print() {
        print("", true);
    }

    /**
     * Print an empty line
     */
    public void print(Throwable throwable) {
        print(throwable.getMessage(), false);
    }

    /**
     * @param msg Print a message to console
     */
    public void print(Object msg) {
        print(msg, false);
    }

    /**
     * @param msg   Print a message to console
     * @param empty Print a empty string/message
     */
    public void print(Object msg, boolean empty) {
        String msgString = CatLoggerUtils.getPrefix(loggerName) + String.valueOf(msg);
        if (empty)
            msgString = "";

        if (CatLoggerUtils.logFileIsNull())
            CatLoggerUtils.init();

        System.out.println(msgString);
        if (CatLoggerUtils.OUTPUT_LOG) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(CatLoggerUtils.LOG_FILE, true));
                writer.append(msgString);
                if (msgString.contains("\\n") || msgString.contains("\n"))
                    writer.newLine();
                writer.newLine();

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
