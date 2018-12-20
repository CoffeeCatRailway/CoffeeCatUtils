package coffeecatteam.coffeecatutils;

import java.util.Random;

/**
 * @author CoffeeCatRailway
 * Created: 29/11/2018
 */
public class NumberUtils {

    /**
     * @param max The max number to get a random int from
     * @return Random value between 0 and max
     */
    public static int getRandomInt(int max) {
        return getRandomInt(0, max);
    }

    /**
     * @param min The min number to get a random int from
     * @param max The max number to get a random int from
     * @return Random value between min and max
     */
    public static int getRandomInt(int min, int max) {
        if (min >= max)
            throw new IllegalArgumentException("max must be greater than min");

        int out = 0;
        for (int i = 0; i < 50; i++)
            out = new Random().nextInt((max - min) + 1) + min;
        return out;
    }

    /**
     * @param max The max number to get a random float from
     * @return Random value between 0 and max
     */
    public static float getRandomFloat(float max) {
        return getRandomFloat(0.0f, max);
    }

    /**
     * @param min The min number to get a random float from
     * @param max The max number to get a random float from
     * @return Random value between min and max
     */
    public static float getRandomFloat(float min, float max) {
        if (min >= max)
            throw new IllegalArgumentException("max must be greater than min");

        float out = 0;
        for (int i = 0; i < 50; i++)
            out = new Random().nextFloat() * (max - min) + min;
        return out;
    }

    /**
     * @return Random value of true/false
     */
    public static boolean getRandomBoolean() {
        return getRandomInt(0, 1) == 0;
    }

    /**
     * @param number The string to parse
     * @return Parse a string to a int safely
     */
    public static int parseInt(Object number) {
        try {
            return Integer.parseInt(String.valueOf(number));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @param number The string to parse
     * @return Parse a string to a flout safely
     */
    public static float parseFloat(Object number) {
        try {
            return Float.parseFloat(String.valueOf(number));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0f;
        }
    }

    /**
     * @param number The string to parse
     * @return Parse a string to a double safely
     */
    public static double parseDouble(Object number) {
        try {
            return Double.parseDouble(String.valueOf(number));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0d;
        }
    }

    /**
     * @param from    The number to map
     * @param fromMin Map from min
     * @param fromMax Map from max
     * @param toMin   Map to min
     * @param toMax   Map to max
     * @return Map a value from 'fromMin' and 'fromMax' to 'toMin' and 'toMax'
     */
    public static float map(float from, float fromMin, float fromMax, float toMin, float toMax) {
        float fromAbs = from - fromMin;
        float fromMaxAbs = fromMax - fromMin;

        float normal = fromAbs / fromMaxAbs;

        float toMaxAbs = toMax - toMin;
        float toAbs = toMaxAbs * normal;

        float to = toAbs + toMin;

        return to;
    }
}
