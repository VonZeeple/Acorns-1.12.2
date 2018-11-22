package vonzeeple.acorns.common.util;

import net.minecraftforge.common.config.Config;
import vonzeeple.acorns.Acorns;

@Config(modid=Acorns.MODID)
public class Configuration {
    public static boolean disableApples = true;

    public static boolean disableDarkOakApples = true;

    public static boolean disableOakSaplings= false;

    public static boolean disableDarkOakSaplings= false;

    @Config.RangeInt(min = 0, max = 100)
    public static int AcornDropChance = 5;
    @Config.RangeInt(min = 0, max = 100)
    public static int DarkAcornDropChance = 5;

    public static boolean acornBreedsPigs = true;

    public static boolean acornTemptsPigs = true;
}
