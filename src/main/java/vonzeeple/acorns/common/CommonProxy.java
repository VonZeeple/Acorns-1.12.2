package vonzeeple.acorns.common;

import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vonzeeple.acorns.common.items.ItemAcorns;


@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        //MinecraftForge.EVENT_BUS.register(EventHandler.class);
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemAcorns());
    }




}
