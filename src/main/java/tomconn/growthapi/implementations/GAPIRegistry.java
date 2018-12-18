package tomconn.growthapi.implementations;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.interfaces.registry.IRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class is our default implementation of the {@link IRegistry} interface.
 * It is a singleton.
 */
public class GAPIRegistry implements IRegistry {

    private static GAPIRegistry instance = new GAPIRegistry();

    private GAPIRegistry() {
    }

    public static GAPIRegistry getInstance() {
        return instance;
    }

    /**
     * We store the requirements for crops in this map
     */
    private Map<Class<? extends Block>, Predicate<BlockEvent.CropGrowEvent.Pre>[]> cropPreMap = new HashMap<>();

    /**
     * We store the consumers for crops in this map
     */
    private Map<Class<? extends Block>, Consumer<BlockEvent.CropGrowEvent.Post>> cropPostMap = new HashMap<>();

    /**
     * We store the saplings in this map
     */
    private Map<Class<? extends Block>, Predicate<SaplingGrowTreeEvent>[]> saplingMap = new HashMap<>();

    @Override
    public boolean registerCropPre(Class<? extends Block> blockClass, Predicate<BlockEvent.CropGrowEvent.Pre>... requirements) {
        return cropPreMap.putIfAbsent(blockClass, requirements) == null;
    }

    @Override
    public boolean registerCropPost(Class<? extends Block> blockClass, Consumer<BlockEvent.CropGrowEvent.Post> consumer) {
        return cropPostMap.putIfAbsent(blockClass, consumer) == null;
    }

    @Override
    public boolean registerSapling(Class<? extends Block> blockClass, Predicate<SaplingGrowTreeEvent>... requirements) {
        return saplingMap.putIfAbsent(blockClass, requirements) == null;
    }

    @Override
    public Predicate<BlockEvent.CropGrowEvent.Pre>[] getRequirementsForCropPre(Class<? extends Block> blockClass) {
        return cropPreMap.get(blockClass);
    }

    @Override
    public Predicate<SaplingGrowTreeEvent>[] getRequirementsForSapling(Class<? extends Block> blockClass) {
        return saplingMap.get(blockClass);
    }

    @Override
    public Consumer<BlockEvent.CropGrowEvent.Post> getConsumerForCropPost(Class<? extends Block> blockClass) {
        return cropPostMap.get(blockClass);
    }
}
