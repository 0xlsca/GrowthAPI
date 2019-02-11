package tomconn.growthapi.implementations.registry;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.registry.profilebased.ProfileBasedRegistry;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class is our default implementation of the {@link tomconn.growthapi.interfaces.registry.classbased.ClassBasedRegistry} interface.
 *
 * @since 0.0.5
 */
public class ClassBasedRegistry implements tomconn.growthapi.interfaces.registry.classbased.ClassBasedRegistry {

    /**
     * Pre
     */
    @Nonnull
    private Map< Class< ? extends Block >, Collection< GrowthCondition< Pre > > > cropPreMap = new HashMap<>();

    /**
     * Post
     */
    @Nonnull
    private Map< Class< ? extends Block >, Consumer< BlockEvent.CropGrowEvent.Post > > cropPostMap = new HashMap<>();

    /**
     * Saplings
     */
    @Nonnull
    private Map< Class< ? extends Block >, Collection< GrowthCondition< SaplingGrowTreeEvent > > > saplingMap = new HashMap<>();

    /**
     * Profiles
     */
    @Nonnull
    private ProfileBasedRegistry profileRegistry = new ProfileRegistry();


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public boolean registerCropPre(Class< ? extends Block > blockClass, Collection< GrowthCondition< Pre > > requirements) {

        return cropPreMap.putIfAbsent(blockClass, requirements) == null;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public boolean registerCropPost(Class< ? extends Block > blockClass, Consumer< BlockEvent.CropGrowEvent.Post > consumer) {

        return cropPostMap.putIfAbsent(blockClass, consumer) == null;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public boolean registerSapling(Class< ? extends Block > blockClass, Collection< GrowthCondition< SaplingGrowTreeEvent > > requirements) {

        return saplingMap.putIfAbsent(blockClass, requirements) == null;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Nonnull
    @Override
    public Optional< Collection< ? extends Predicate< Pre > > > getRequirementsForCropPre(Class< ? extends Block > blockClass) {

        return Optional.ofNullable(cropPreMap.get(blockClass));
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Nonnull
    @Override
    public Optional< Collection< ? extends Predicate< SaplingGrowTreeEvent > > > getRequirementsForSapling(Class< ? extends Block > blockClass) {

        return Optional.ofNullable(saplingMap.get(blockClass));
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public Optional< Consumer< Post > > getConsumerForCropPost(Class< ? extends Block > blockClass) {

        return Optional.ofNullable(cropPostMap.get(blockClass));
    }

}
