package coffeecatteam.coffeecatutils;

import coffeecatteam.coffeecatutils.logger.CatLogger;
import coffeecatteam.coffeecatutils.logger.CatLoggerUtils;
import coffeecatteam.coffeecatutils.position.AABB;
import coffeecatteam.coffeecatutils.position.Vector2D;

/**
 * @author CoffeeCatRailway
 * Created: 20/12/2018
 */
public class CoffeeCatUtilsTester {

    public static void main(String[] args) {
        CatLoggerUtils.init();
        CatLogger logger = new CatLogger();
        logger.info("CatLogger initialized!");
        logger.println();

        int width = 20, height = 10;
        Vector2D vector = new Vector2D(15, 15);

        AABB aabb = new AABB(10, 10, width, height);
        AABB aabb1 = new AABB(vector, width, height);

        logger.warn(aabb.contains(aabb1));
        logger.info("AABB");

        if (ArgUtils.hasArgument(args, "-testArg"))
            logger.info("ArgUtils");
        else
            logger.warn("No ArgUtils");
        logger.println();

        logger.info(NumberUtils.getRandomBoolean());
        logger.info(NumberUtils.getRandomInt(10, 20));
        logger.error(new Exception("Test Exception"));
        logger.info("NumberUtils");
    }
}
