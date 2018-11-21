package vonzeeple.acorns.client;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import vonzeeple.acorns.Content;
import vonzeeple.acorns.common.CommonProxy;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Content.itemAcorns, 0, new ModelResourceLocation( Content.itemAcorns.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Content.itemAcorns, 5, new ModelResourceLocation( Content.itemAcorns.getRegistryName()+"_dark", "inventory"));
    }

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent e) {


    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
