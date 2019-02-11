package tomconn.growthapi.implementations.registry;

import net.minecraft.block.Block;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;
import tomconn.growthapi.interfaces.registry.Registry;
import tomconn.growthapi.interfaces.registry.classbased.ClassBasedRegistry;
import tomconn.growthapi.interfaces.registry.profilebased.ProfileBasedRegistry;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class delegates the respective methods to a respective instance of {@link ProfileBasedRegistry} and
 * {@link ClassBasedRegistry}
 *
 * @since 0.0.5
 */
public class GrowthRegistry implements Registry {

    private final ClassBasedRegistry classBasedRegistry = new tomconn.growthapi.implementations.registry.ClassBasedRegistry();
    private final ProfileBasedRegistry profileBasedRegistry = new ProfileRegistry();

    @Override
    public boolean registerCropPre(Class< ? extends Block > blockClass, Collection< GrowthCondition< Pre > > requirements) {
        return classBasedRegistry.registerCropPre(blockClass, requirements);
    }

    @Override
    public boolean registerCropPost(Class<? extends Block> blockClass, Consumer<BlockEvent.CropGrowEvent.Post> consumer) {
        return classBasedRegistry.registerCropPost(blockClass, consumer);
    }

    @Override
    public boolean registerSapling(Class< ? extends Block > blockClass, Collection< GrowthCondition< SaplingGrowTreeEvent > > requirements) {
        return classBasedRegistry.registerSapling(blockClass, requirements);
    }


    @Nonnull
    @Override
    public Optional< Collection< ? extends Predicate< Pre > > > getRequirementsForCropPre(Class< ? extends Block > blockClass) {

        ArrayList< Predicate< Pre > > ret = new ArrayList<>();

        classBasedRegistry.getRequirementsForCropPre(blockClass).ifPresent(ret::addAll);
        profileBasedRegistry.getRequirementsForCropPre(blockClass).ifPresent(ret::addAll);

        return Optional.of(ret);
    }


    @Nonnull
    @Override
    public Optional< Collection< ? extends Predicate< SaplingGrowTreeEvent > > > getRequirementsForSapling(Class< ? extends Block > blockClass) {

        ArrayList< Predicate< SaplingGrowTreeEvent > > ret = new ArrayList<>();

        classBasedRegistry.getRequirementsForSapling(blockClass).ifPresent(ret::addAll);
        profileBasedRegistry.getRequirementsForSapling(blockClass).ifPresent(ret::addAll);

        return Optional.of(ret);
    }

    @Override
    public Optional< Consumer< Post > > getConsumerForCropPost(Class< ? extends Block > blockClass) {
        return classBasedRegistry.getConsumerForCropPost(blockClass);
    }

    @Override
    public boolean registerCropGrowPreProfile(Class< ? extends Block > blockClass, BaseGrowthProfile< Pre, ? > growthProfile) {
        return profileBasedRegistry.registerCropGrowPreProfile(blockClass, growthProfile);
    }


    @SafeVarargs
    @Override
    public final Collection< Tuple< Class< ? extends Block >, BaseGrowthProfile< Pre, ? > > > registerCropGrowPreProfiles(Tuple< Class< ? extends Block >, BaseGrowthProfile< Pre, ? > >... tuples) {

        return profileBasedRegistry.registerCropGrowPreProfiles(tuples);
    }

    @Override
    public boolean registerSaplingProfile(Class< ? extends Block > blockClass, BaseGrowthProfile< SaplingGrowTreeEvent, ? > profile) {
        return profileBasedRegistry.registerSaplingProfile(blockClass, profile);
    }


    @SafeVarargs
    @Override
    public final Collection< Tuple< Class< ? extends Block >, BaseGrowthProfile< SaplingGrowTreeEvent, ? > > > registerSaplingProfiles(Tuple< Class< ? extends Block >, BaseGrowthProfile< SaplingGrowTreeEvent, ? > >... profiles) {

        return profileBasedRegistry.registerSaplingProfiles(profiles);
    }
}
