package coffeecatteam.coffeecatutils;

import coffeecatteam.coffeecatutils.position.AABB;
import coffeecatteam.coffeecatutils.position.Vector2D;

/**
 * @author CoffeeCatRailway
 * Created: 20/12/2018
 */
public class CoffeeCatUtilsTester {

    public static void main(String[] args) {
        CatLogger.init();
        CatLogger logger = new CatLogger();
        logger.print("CatLogger initialized!");
        logger.print();

        AABB aabb = new AABB(10, 10, 20, 10);
        AABB aabb1 = new AABB(new Vector2D(15, 15), 20, 10);
        logger.print(aabb.contains(aabb1));
        logger.print("AABB");

        if (ArgUtils.hasArgument(args, "testArg"))
            logger.print("ArgUtils");
        else
            logger.print("No ArgUtils");
        logger.print();

        logger.print(NumberUtils.getRandomBoolean());
        logger.print(NumberUtils.getRandomInt(10, 20));
        logger.print("NumberUtils");
    }
}
