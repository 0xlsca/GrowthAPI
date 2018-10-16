package tomconn.growthapi;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tomconn.growthapi.base.IEventManager;
import tomconn.growthapi.prepackaged.DefaultEventManager;
import tomconn.growthapi.runtime_tests.RuntimeTest;

@SuppressWarnings("WeakerAccess")
@Mod(modid = GrowthAPI.modId, name = GrowthAPI.name, version = GrowthAPI.version)
@Mod.EventBusSubscriber
public class GrowthAPI {

    public final static String modId = "growthapi";
    public final static String name = "Growth API";
    public final static String version = "0.0.1";


    private static IEventManager eventManager;


    @Mod.Instance(modId)
    public static GrowthAPI instance;


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        eventManager = new DefaultEventManager();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        new RuntimeTest();

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

    public IEventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(IEventManager eventManager) {
        GrowthAPI.eventManager = eventManager;
    }
}
