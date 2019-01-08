package tomconn.growthapi.implementations.registry;

import net.minecraft.block.Block;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.growthprofile.crop.CropGrowthProfile;
import tomconn.growthapi.implementations.growthprofile.sapling.SaplingGrowthProfile;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;
import tomconn.growthapi.interfaces.registry.profilebased.IProfileBasedRegistry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ProfileBasedRegistry implements IProfileBasedRegistry {

    /**
     *          Crops (Pre)
     */
    private Map< Class< ? extends Block >, GrowthProfile< Pre > > cropPreMap = new HashMap<>();

    /**
     *          Saplings
     */
    private Map< Class< ? extends Block >, GrowthProfile< SaplingGrowTreeEvent > > saplingMap = new HashMap<>();



    @Override
    public boolean registerCropGrowPreProfile(Class< ? extends Block > blockClass, GrowthProfile< Pre > growthProfile) {
        return cropPreMap.putIfAbsent(blockClass, growthProfile) == null;
    }

    @Override
    public boolean[] registerCropGrowPreProfiles(Tuple< Class< ? extends Block >, GrowthProfile< Pre > >... tuples) {

        boolean[] ret = new boolean[tuples.length];

        for (int i = 0; i < tuples.length; i++) {
            Tuple< Class< ? extends Block >, GrowthProfile< Pre > > tuple = tuples[i];
            ret[i] = registerCropGrowPreProfile(tuple.getFirst(),tuple.getSecond());
        }

        return ret;
    }

    @Override
    public boolean registerSaplingProfile(Class< ? extends Block > blockClass, GrowthProfile< SaplingGrowTreeEvent > profile) {
        return saplingMap.putIfAbsent(blockClass, profile) == null;
    }

    @Override
    public boolean[] registerSaplingProfiles(Tuple< Class< ? extends Block >, GrowthProfile< SaplingGrowTreeEvent > >... tuples) {
        boolean[] ret = new boolean[tuples.length];

        for (int i = 0; i < tuples.length; i++) {
            Tuple< Class< ? extends Block >, GrowthProfile< SaplingGrowTreeEvent > > tuple = tuples[i];
            ret[i] = registerSaplingProfile(tuple.getFirst(),tuple.getSecond());
        }

        return ret;
    }

    @Override
    public List<Predicate<Pre>> getRequirementsForCropPre(Class<? extends Block> blockClass) {

        GrowthProfile< Pre > profile = cropPreMap.getOrDefault(blockClass, new CropGrowthProfile());

        return profile.liquidate();
    }

    @Override
    public List<Predicate<SaplingGrowTreeEvent>> getRequirementsForSapling(Class<? extends Block> blockClass) {

        GrowthProfile< SaplingGrowTreeEvent > profile = saplingMap.getOrDefault(blockClass, new SaplingGrowthProfile());

        return profile.liquidate();
    }
}
