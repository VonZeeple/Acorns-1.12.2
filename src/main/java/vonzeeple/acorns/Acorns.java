package vonzeeple.acorns;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import vonzeeple.acorns.common.CommonProxy;

@Mod(modid = Acorns.MODID, name = Acorns.NAME, version = Acorns.VERSION)
public class Acorns
{
    public static final String MODID = "acorns";
    public static final String NAME = "Acorns";
    public static final String VERSION = "1.0";

    public static Logger logger;

    // On instancie la classe du mod
    @Mod.Instance
    public static Acorns instance = new Acorns();

    @SidedProxy(clientSide = "vonzeeple.acorns.client.ClientProxy", serverSide = "vonzeeple.acorns.common.CommonProxy")
    public static CommonProxy proxy;

    //Static initializer
    static {
        FluidRegistry.enableUniversalBucket(); // Must be called before preInit
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        Acorns.proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Acorns.proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Acorns.proxy.postInit(event);
    }
}
