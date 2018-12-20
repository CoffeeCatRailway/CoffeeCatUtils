package coffeecatteam.coffeecatutils.io;

import coffeecatteam.coffeecatutils.NumberUtils;

import java.io.*;

/**
 * @author CoffeeCatRailway
 * Created: 30/11/2018
 */
public class FileUtils {

    /**
     * @param path Path to jar file inside jar
     * @return Load file from inside the jar
     */
    public static BufferedReader loadFileInSideJar(String path) {
        return new BufferedReader(new InputStreamReader(NumberUtils.class.getResourceAsStream(path)));
    }

    /**
     * @param path Path to jar file outside jar
     * @return Load file from outside the jar
     * @throws FileNotFoundException
     */
    public static BufferedReader loadFileOutSideJar(String path) throws FileNotFoundException {
        return new BufferedReader(new FileReader(path));
    }

    /**
     * @param path Path to jar file inside jar
     * @return Load file as a string from inside the jar
     */
    public static String loadFileAsStringInSideJar(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = loadFileInSideJar(path);
            String line;
            while ((line = br.readLine()) != null)
                builder.append(line + "\n");

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    /**
     * @param path Path to jar file outside jar
     * @return Load file as a string from outside the jar
     */
    public static String loadFileAsStringOutSideJar(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = loadFileOutSideJar(path);
            String line;
            while ((line = br.readLine()) != null)
                builder.append(line + "\n");

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
