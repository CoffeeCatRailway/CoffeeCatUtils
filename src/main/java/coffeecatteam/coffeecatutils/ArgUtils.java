package coffeecatteam.coffeecatutils;

/**
 * @author CoffeeCatRailway
 * Created: 1/12/2018
 */
public class ArgUtils {

    public static boolean hasArgument(String[] args, String arg) {
        for (String a : args) {
            String regex = ":";
            if (a.contains(regex))
                a = a.split(regex)[0];

            if (a.equals(arg))
                return true;
        }
        return false;
    }

    public static String getArgument(String[] args, String arg) {
        String value = null;
        for (int i = 0; i < args.length; i++) {
            if (hasArgument(args, arg)) {
                String regex = ":";
                String argName = args[i].split(regex)[0];
                String argValue = null;
                if (args[i].contains(regex))
                    argValue = args[i].split(regex)[1];

                if (argName.equals(arg))
                    value = argValue;
            }
        }
        return value;
    }
}
