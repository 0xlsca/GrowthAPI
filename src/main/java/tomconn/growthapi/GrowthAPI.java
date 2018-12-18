package tomconn.growthapi;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tomconn.growthapi.implementations.EventManager;

@SuppressWarnings("WeakerAccess")
@Mod(modid = GrowthAPI.modId, name = GrowthAPI.name, version = GrowthAPI.version)
@Mod.EventBusSubscriber
public class GrowthAPI {

    public final static String modId = "growthapi";
    public final static String name = "Growth API";
    public final static String version = "0.0.2";


    private static EventManager eventManager;


    @Mod.Instance(modId)
    public static GrowthAPI instance;


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        eventManager = EventManager.getInstance();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void onCropGrowthEventPre(BlockEvent.CropGrowEvent.Pre event) {
        eventManager.manage(event);
    }

    @SubscribeEvent
    public static void onCropGrowthEventPost(BlockEvent.CropGrowEvent.Post event) {
        eventManager.manage(event);
    }

    @SubscribeEvent
    public static void onSaplingGrowthTreeEvent(SaplingGrowTreeEvent event) {
        eventManager.manage(event);
    }
}
