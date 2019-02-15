package tomconn.growthapi;

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tomconn.growthapi.implementations.event.EventManager;
import tomconn.growthapi.interfaces.registry.UnifiedRegistry;
import tomconn.growthapi.runtimetests.RuntimeTest;

@SuppressWarnings("WeakerAccess")
@Mod(modid = GrowthAPI.modId, name = GrowthAPI.name, version = GrowthAPI.version)
@Mod.EventBusSubscriber
public class GrowthAPI {

    public final static String modId = "growthapi";
    public final static String name = "Growth API";
    public final static String version = "0.0.4";


    private static EventManager eventManager;
    private static UnifiedRegistry unifiedRegistry;


    @Mod.Instance(modId)
    public static GrowthAPI instance;


    public static UnifiedRegistry getUnifiedRegistry() {

        return unifiedRegistry;
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        eventManager = new EventManager();
        unifiedRegistry = eventManager.getUnifiedRegistry();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        RuntimeTest.test();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onCropGrowthEventPre(BlockEvent.CropGrowEvent.Pre event) {
        eventManager.manage(event);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onCropGrowthEventPost(BlockEvent.CropGrowEvent.Post event) {
        eventManager.manage(event);
    }

    public static EventManager getEventManager() {
        return eventManager;
    }
}
