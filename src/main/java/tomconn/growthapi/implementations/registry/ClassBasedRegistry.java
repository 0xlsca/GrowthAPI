package tomconn.growthapi.implementations.registry;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.registry.classbased.IClassBasedRegistry;
import tomconn.growthapi.interfaces.registry.profilebased.ProfileBasedRegistry;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class is our default implementation of the {@link IClassBasedRegistry} interface.
 */
public class ClassBasedRegistry implements IClassBasedRegistry {

    /**
     *      Pre
     */
    @Nonnull
    private Map<Class<? extends Block>, Predicate<Pre>[]> cropPreMap = new HashMap<>();

    /**
     *      Post
     */
    @Nonnull
    private Map<Class<? extends Block>, Consumer<BlockEvent.CropGrowEvent.Post>> cropPostMap = new HashMap<>();

    /**
     *      Saplings
     */
    @Nonnull
    private Map<Class<? extends Block>, Predicate<SaplingGrowTreeEvent>[]> saplingMap = new HashMap<>();

    /**
     *      Profiles
     */
    @Nonnull
    private ProfileBasedRegistry profileRegistry = new ProfileRegistry();

    @Override
    public boolean registerCropPre(Class<? extends Block> blockClass, Predicate<Pre>... requirements) {
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


    @Nonnull
    @Override
    public List<Predicate<Pre>> getRequirementsForCropPre(Class<? extends Block> blockClass) {

        Predicate<Pre>[] predicates = cropPreMap.get(blockClass);

        if (predicates != null) {
            List<Predicate<Pre>> ret = Arrays.asList(predicates);
            ret.addAll(profileRegistry.getRequirementsForCropPre(blockClass));
        }


        return Collections.emptyList();
    }


    @Nonnull
    @Override
    public List<Predicate<SaplingGrowTreeEvent>> getRequirementsForSapling(Class<? extends Block> blockClass) {

        Predicate<SaplingGrowTreeEvent>[] predicates = saplingMap.get(blockClass);

        if (predicates != null) {
            List<Predicate<SaplingGrowTreeEvent>> ret = Arrays.asList(predicates);
            ret.addAll(profileRegistry.getRequirementsForSapling(blockClass));
            return ret;
        }

        return Collections.emptyList();
    }

    @Override
    public Consumer<BlockEvent.CropGrowEvent.Post> getConsumerForCropPost(Class<? extends Block> blockClass) {
        return cropPostMap.get(blockClass);
    }
}
