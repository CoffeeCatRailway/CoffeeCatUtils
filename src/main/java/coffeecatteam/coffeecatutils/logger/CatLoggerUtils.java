package coffeecatteam.coffeecatutils.logger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CoffeeCatRailway
 * Created: 21/12/2018
 */
public class CatLoggerUtils {

    static File LOG_FILE;

    static boolean OUTPUT_LOG = true;
    static String OUTPUT_PATH = "./logs/log_";

    public static String TF_DATE_TIME = "dd-MM-yyyy_HH-mm-ss";
    public static String TF_TIME_DATE = "HH-mm-ss_dd-MM-yyyy";
    static String TIME_FORMAT = TF_TIME_DATE;

    public static void init() {
        LOG_FILE = new File(OUTPUT_PATH + getTime() + ".tutlog");
        LOG_FILE.getParentFile().mkdirs();
    }

    static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat(TIME_FORMAT);
        Date date = new Date();
        return formatter.format(date);
    }

    static String getPrefix(String loggerName) {
        String prefix = "[" + loggerName + ":" + getTime() + "] ";
        return prefix;
    }

    public static boolean logFileIsNull() {
        return LOG_FILE == null;
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
}
