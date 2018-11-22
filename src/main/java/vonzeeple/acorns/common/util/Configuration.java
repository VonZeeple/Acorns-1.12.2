package vonzeeple.acorns.common.util;

import net.minecraftforge.common.config.Config;
import vonzeeple.acorns.Acorns;

@Config(modid=Acorns.MODID)
public class Configuration {
    public static boolean disableApples = true;

    public static boolean disableDarkOakApples = true;

    public static boolean disableOakSaplings= false;

    public static boolean disableDarkOakSaplings= false;

    public static int AcornDropChance = 5;

    public static int DarkAcornDropChance = 5;

    public static boolean acornsBreedPigs = true;

    public static boolean acornsTemptPigs = true;
}
