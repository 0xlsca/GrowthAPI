package tomconn.growthapi;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tomconn.growthapi.implementations.EventManager;
import tomconn.growthapi.implementations.GAPIRegistry;
import tomconn.growthapi.interfaces.GAPIRegisterInterface;
import tomconn.growthapi.interfaces.IRegistry;

import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("WeakerAccess")
@Mod(modid = GrowthAPI.modId, name = GrowthAPI.name, version = GrowthAPI.version)
@Mod.EventBusSubscriber
public class GrowthAPI implements GAPIRegisterInterface {

    public final static String modId = "growthapi";
    public final static String name = "Growth API";
    public final static String version = "0.0.2";


    private static EventManager eventManager;
    private static IRegistry registry;


    @Mod.Instance(modId)
    public static GrowthAPI instance;


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        eventManager = EventManager.getInstance();
        registry = GAPIRegistry.getInstance();
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


    @Override
    public boolean registerCropPre(Class<? extends Block> blockClass, Predicate<BlockEvent.CropGrowEvent.Pre>... requirements) {
        return registry.registerCropPre(blockClass, requirements);
    }

    @Override
    public boolean registerCropPost(Class<? extends Block> blockClass, Consumer<BlockEvent.CropGrowEvent.Post> consumer) {
        return registry.registerCropPost(blockClass, consumer);
    }

    @Override
    public boolean registerSamplingGrowTree(Class<? extends Block> blockClass, Predicate<SaplingGrowTreeEvent>... requirements) {
        return registry.registerSapling(blockClass, requirements);
    }
}
