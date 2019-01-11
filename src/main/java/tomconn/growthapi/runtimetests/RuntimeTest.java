package tomconn.growthapi.runtimetests;

import net.minecraft.block.BlockSapling;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.GrowthAPI;
import tomconn.growthapi.implementations.growthprofile.GrowthProfiles;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;

import static net.minecraft.init.Blocks.WHEAT;

public class RuntimeTest {

    public static void test() {

        GrowthProfile< Pre, ? > wheatProfile = GrowthProfiles.cropGrowPre();
        wheatProfile.exactLight(13);
        GrowthAPI.getRegistry().registerCropGrowPreProfile(WHEAT.getClass(), wheatProfile);

        GrowthProfile< SaplingGrowTreeEvent, ? > oakProfile = GrowthProfiles.saplingGrowTree();
        oakProfile.skyAffinity(false);
        GrowthAPI.getRegistry().registerSaplingProfile(BlockSapling.class, oakProfile);

    }

}
