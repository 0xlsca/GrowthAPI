package tomconn.growthapi;

import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tomconn.growthapi.implementations.event.EventManager;
import tomconn.growthapi.implementations.growthprofile.probability.math.function.Probabilities;
import tomconn.growthapi.interfaces.registry.UnifiedRegistry;
import tomconn.growthapi.runtimetests.RuntimeTest;

import java.util.Objects;

/**
 * The main mod class.
 *
 * @since 0.0.5
 */
@Mod(modid = GrowthAPI.modId, name = GrowthAPI.name, version = GrowthAPI.version)
@Mod.EventBusSubscriber
public class GrowthAPI {


    public final static String modId = "growthapi";
    public final static String name = "Growth API";
    public final static String version = "0.0.6";


    private static EventManager eventManager;


    @Mod.Instance(modId)
    public static GrowthAPI instance;


    /**
     * A getter for the internally held {@link EventManager}
     *
     * @return the internally held {@link EventManager} instance
     *
     * @since 0.0.5
     */
    public static EventManager getEventManager() {

        return eventManager;
    }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onCropGrowthEventPre(BlockEvent.CropGrowEvent.Pre event) {

        eventManager.manage(event);
    }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onCropGrowthEventPost(BlockEvent.CropGrowEvent.Post event) {

        eventManager.manage(event);
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        RuntimeTest.test();
    }


    /**
     * This is an easy-access method which registers a crop with the passed probability.
     *
     * @param blockClass  the class of the crop
     * @param probability a probability which is required to adhere to {@link Probabilities#ofFactor(double)}
     *                    conventions
     *
     * @return {@link UnifiedRegistry#registerCropPre(Class, double)}
     */
    public static boolean registerCropPre(Class< ? extends Block > blockClass, double probability) {

        Objects.requireNonNull(blockClass);
        return getUnifiedRegistry().registerCropPre(blockClass, probability);
    }


    /**
     * A getter for the internally held registry
     *
     * @return the held {@link UnifiedRegistry} instance
     *
     * @since 0.0.5
     */
    public static UnifiedRegistry getUnifiedRegistry() {

        return eventManager.getUnifiedRegistry();
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        eventManager = new EventManager();
    }

}
