package coffeecatteam.coffeecatutils;

/**
 * @author CoffeeCatRailway
 * Created: 3/01/2019
 */
public class DevEnvUtils {

    public static boolean isRunningFromIntelliJ() {
        String classPath = System.getProperty("java.class.path").toLowerCase();
        return classPath.contains("idea_rt.jar");
    }

    public static boolean isRunningFromEclipse() {
        String classPath = System.getProperty("java.class.path").toLowerCase();
        return classPath.contains("eclipse");
    }

    public static boolean isRunningFromDevEnviroment() {
        return isRunningFromIntelliJ() || isRunningFromEclipse();
    }
}
