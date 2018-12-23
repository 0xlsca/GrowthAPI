package tomconn.growthapi.implementations;

import net.minecraft.block.Block;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.growthprofile.CropGrowthProfile;
import tomconn.growthapi.implementations.growthprofile.SaplingGrowthProfile;
import tomconn.growthapi.interfaces.growthprofile.IGrowthProfile;
import tomconn.growthapi.interfaces.registry.profilebased.IProfileBasedRegistry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ProfileBasedRegistry implements IProfileBasedRegistry {

    /**
     *          Crops (Pre)
     */
    private Map<Class<? extends Block>, IGrowthProfile<Pre>> cropPreMap = new HashMap<>();

    /**
     *          Saplings
     */
    private Map<Class<? extends Block>, IGrowthProfile<SaplingGrowTreeEvent>> saplingMap = new HashMap<>();



    @Override
    public boolean registerCropGrowPreProfile(Class<? extends Block> blockClass, IGrowthProfile<Pre> growthProfile) {
        return cropPreMap.putIfAbsent(blockClass, growthProfile) == null;
    }

    @Override
    public boolean[] registerCropGrowPreProfiles(Tuple<Class<? extends Block>, IGrowthProfile<Pre>>... tuples) {

        boolean[] ret = new boolean[tuples.length];

        for (int i = 0; i < tuples.length; i++) {
            Tuple<Class<? extends Block>, IGrowthProfile<Pre>> tuple = tuples[i];
            ret[i] = registerCropGrowPreProfile(tuple.getFirst(),tuple.getSecond());
        }

        return ret;
    }

    @Override
    public boolean registerSaplingProfile(Class<? extends Block> blockClass, IGrowthProfile<SaplingGrowTreeEvent> profile) {
        return saplingMap.putIfAbsent(blockClass, profile) == null;
    }

    @Override
    public boolean[] registerSaplingProfiles(Tuple<Class<? extends Block>, IGrowthProfile<SaplingGrowTreeEvent>>... tuples) {
        boolean[] ret = new boolean[tuples.length];

        for (int i = 0; i < tuples.length; i++) {
            Tuple<Class<? extends Block>, IGrowthProfile<SaplingGrowTreeEvent>> tuple = tuples[i];
            ret[i] = registerSaplingProfile(tuple.getFirst(),tuple.getSecond());
        }

        return ret;
    }

    @Override
    public List<Predicate<Pre>> getRequirementsForCropPre(Class<? extends Block> blockClass) {
        IGrowthProfile<Pre> profile = cropPreMap.getOrDefault(blockClass, new CropGrowthProfile());

        return profile.liquidate();
    }

    @Override
    public List<Predicate<SaplingGrowTreeEvent>> getRequirementsForSapling(Class<? extends Block> blockClass) {
        IGrowthProfile<SaplingGrowTreeEvent> profile = saplingMap.getOrDefault(blockClass, new SaplingGrowthProfile());

        return profile.liquidate();
    }
}
