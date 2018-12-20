package coffeecatteam.coffeecatutils.io;

import coffeecatteam.coffeecatutils.NumberUtils;

import java.awt.*;
import java.io.IOException;

/**
 * @author CoffeeCatRailway
 * Created: 29/11/2018
 */
public class FontLoader {

    /**
     * @param path Path to font file
     * @param size Font size to load at
     * @return The loaded font
     */
    public static Font loadTrueTypeFont(String path, float size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, NumberUtils.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
