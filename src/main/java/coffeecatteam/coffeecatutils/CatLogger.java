package coffeecatteam.coffeecatutils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CoffeeCatRailway
 * Created: 20/12/2018
 */
public class CatLogger {

    private String loggerName;

    private static File logFile;

    private static boolean OUTPUT_LOG = true;
    private static String OUTPUT_PATH = "./logs/log_";

    public static String TF_DATE_TIME = "dd-MM-yyyy_HH-mm-ss";
    public static String TF_TIME_DATE = "HH-mm-ss_dd-MM-yyyy";
    private static String TIME_FORMAT = TF_DATE_TIME;

    public CatLogger() {
        this(Thread.currentThread());
    }

    public CatLogger(Thread thread) {
        this(thread.getName());
    }

    public CatLogger(String loggerName) {
        this.loggerName = loggerName;
        if (logFile == null)
            init();
    }

    /**
     * Initialize the logger
     */
    public static void init() {
        logFile = new File(OUTPUT_PATH + getTime() + ".tutlog");
        logFile.getParentFile().mkdirs();
    }

    private static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat(TIME_FORMAT);
        Date date = new Date();
        return formatter.format(date);
    }

    public static void setTimeFormat(String timeFormat) {
        TIME_FORMAT = timeFormat;
    }

    public static void setOutputLog(boolean outputLog) {
        OUTPUT_LOG = outputLog;
    }

    public static void setOutputPath(String outputPath) {
        OUTPUT_PATH = outputPath;
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
     * @param msg Print a message to console
     * @param empty Print a empty string/message
     */
    public void print(Object msg, boolean empty) {
        String msgString = "[" + loggerName + ":" + getTime() + "] " + String.valueOf(msg);
        if (empty)
            msgString = "";
        System.out.println(msgString);
        if (OUTPUT_LOG) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
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
