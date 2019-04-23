package coffeecatteam.coffeecatutils;

/**
 * @author CoffeeCatRailway
 * Created: 1/12/2018
 */
public class ArgUtils {

    private static String[] ARGS;

    public static void setARGS(String[] ARGS) {
        ArgUtils.ARGS = ARGS;
    }

    public static boolean hasArgument(String arg) {
        for (String a : ARGS) {
            String regex = ":";
            if (a.contains(regex))
                a = a.split(regex)[0];

            if (a.equals(arg))
                return true;
        }
        return false;
    }

    public static String getArgument(String arg) {
        String value = null;
        for (int i = 0; i < ARGS.length; i++) {
            if (hasArgument(arg)) {
                String regex = ":";
                String argName = ARGS[i].split(regex)[0];
                String argValue = null;
                if (ARGS[i].contains(regex))
                    argValue = ARGS[i].split(regex)[1];

                if (argName.equals(arg))
                    value = argValue;
            }
        }
        return value;
    }
}
