package tomconn.growthapi.implementations.registry;

import net.minecraft.block.Block;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;
import tomconn.growthapi.interfaces.registry.IRegistry;
import tomconn.growthapi.interfaces.registry.classbased.IClassBasedRegistry;
import tomconn.growthapi.interfaces.registry.profilebased.IProfileBasedRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class delegates the respective methods to a respective instance of {@link IProfileBasedRegistry} and
 * {@link IClassBasedRegistry}
 */
public class GrowthRegistry implements IRegistry {

    private final IClassBasedRegistry classBasedRegistry = new ClassBasedRegistry();
    private final IProfileBasedRegistry profileBasedRegistry = new ProfileBasedRegistry();

    @Override
    public boolean registerCropPre(Class<? extends Block> blockClass, Predicate<BlockEvent.CropGrowEvent.Pre>... requirements) {
        return classBasedRegistry.registerCropPre(blockClass, requirements);
    }

    @Override
    public boolean registerCropPost(Class<? extends Block> blockClass, Consumer<BlockEvent.CropGrowEvent.Post> consumer) {
        return classBasedRegistry.registerCropPost(blockClass, consumer);
    }

    @Override
    public boolean registerSapling(Class<? extends Block> blockClass, Predicate<SaplingGrowTreeEvent>... requirements) {
        return classBasedRegistry.registerSapling(blockClass, requirements);
    }

    @Override
    public List<Predicate<BlockEvent.CropGrowEvent.Pre>> getRequirementsForCropPre(Class<? extends Block> blockClass) {
        List<Predicate<BlockEvent.CropGrowEvent.Pre>> ret = new ArrayList<>();

        ret.addAll(classBasedRegistry.getRequirementsForCropPre(blockClass));
        ret.addAll(profileBasedRegistry.getRequirementsForCropPre(blockClass));

        return ret;
    }

    @Override
    public List<Predicate<SaplingGrowTreeEvent>> getRequirementsForSapling(Class<? extends Block> blockClass) {
        List<Predicate<SaplingGrowTreeEvent>> ret = new ArrayList<>();

        ret.addAll(classBasedRegistry.getRequirementsForSapling(blockClass));
        ret.addAll(profileBasedRegistry.getRequirementsForSapling(blockClass));

        return ret;
    }

    @Override
    public Consumer<BlockEvent.CropGrowEvent.Post> getConsumerForCropPost(Class<? extends Block> blockClass) {
        return classBasedRegistry.getConsumerForCropPost(blockClass);
    }

    @Override
    public boolean registerCropGrowPreProfile(Class< ? extends Block > blockClass, GrowthProfile< BlockEvent.CropGrowEvent.Pre > growthProfile) {
        return profileBasedRegistry.registerCropGrowPreProfile(blockClass, growthProfile);
    }

    @Override
    public boolean[] registerCropGrowPreProfiles(Tuple< Class< ? extends Block >, GrowthProfile< BlockEvent.CropGrowEvent.Pre > >... tuples) {
        return profileBasedRegistry.registerCropGrowPreProfiles(tuples);
    }

    @Override
    public boolean registerSaplingProfile(Class< ? extends Block > blockClass, GrowthProfile< SaplingGrowTreeEvent > profile) {
        return profileBasedRegistry.registerSaplingProfile(blockClass, profile);
    }

    @Override
    public boolean[] registerSaplingProfiles(Tuple< Class< ? extends Block >, GrowthProfile< SaplingGrowTreeEvent > >... profiles) {
        return profileBasedRegistry.registerSaplingProfiles(profiles);
    }
}
