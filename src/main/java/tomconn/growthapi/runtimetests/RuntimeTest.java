package tomconn.growthapi.runtimetests;

import net.minecraft.block.BlockSapling;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.GrowthAPI;
import tomconn.growthapi.implementations.growthprofile.BaseProfiles;
import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;

import static net.minecraft.init.Blocks.WHEAT;

public class RuntimeTest {

    public static void test() {

        BaseGrowthProfile< Pre, ? > wheatProfile = BaseProfiles.cropGrowPre();
        wheatProfile.exactLight(13);
        GrowthAPI.getRegistry().registerCropGrowPreProfile(WHEAT.getClass(), wheatProfile);

        BaseGrowthProfile< SaplingGrowTreeEvent, ? > oakProfile = BaseProfiles.saplingGrowTree();
        oakProfile.skyAffinity(false);
        GrowthAPI.getRegistry().registerSaplingProfile(BlockSapling.class, oakProfile);

    }

}
