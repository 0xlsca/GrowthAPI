package tomconn.growthapi.implementations.registry;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.growthprofile.BaseProfiles;
import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;
import tomconn.growthapi.interfaces.registry.profilebased.ProfileBasedRegistry;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.Predicate;

/**
 * Default implementation for {@link ProfileBasedRegistry}
 *
 * @since 0.0.5
 */
public class ProfileRegistry implements ProfileBasedRegistry {

    /**
     * Crops (Pre)
     */
    @Nonnull
    private Map< Class< ? extends Block >, BaseGrowthProfile< Pre, ? > > cropPreMap = new HashMap<>();

    /**
     * Saplings
     */
    @Nonnull
    private Map< Class< ? extends Block >, BaseGrowthProfile< SaplingGrowTreeEvent, ? > > saplingMap = new HashMap<>();


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public boolean registerCropGrowPreProfile(Class< ? extends Block > blockClass, BaseGrowthProfile< Pre, ? > growthProfile) {

        Objects.requireNonNull(growthProfile);
        return cropPreMap.putIfAbsent(blockClass, growthProfile) == null;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public boolean registerSaplingProfile(Class< ? extends Block > blockClass, BaseGrowthProfile< SaplingGrowTreeEvent, ? > profile) {

        Objects.requireNonNull(profile);

        return saplingMap.putIfAbsent(blockClass, profile) == null;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public Optional< Collection< ? extends Predicate< Pre > > > getRequirementsForCropPre(Class< ? extends Block > blockClass) {

        Objects.requireNonNull(blockClass);
        BaseGrowthProfile< Pre, ? > profile = cropPreMap.getOrDefault(blockClass, BaseProfiles.cropGrowPre());
        return Optional.ofNullable(profile.liquidate());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.5
     */
    @Override
    public Optional< Collection< ? extends Predicate< SaplingGrowTreeEvent > > > getRequirementsForSapling(Class< ? extends Block > blockClass) {

        Objects.requireNonNull(blockClass);
        BaseGrowthProfile< SaplingGrowTreeEvent, ? > profile = saplingMap.getOrDefault(blockClass, BaseProfiles.saplingGrowTree());
        return Optional.ofNullable(profile.liquidate());
    }

}
