package tomconn.growthapi.runtimetests;

import net.minecraft.block.BlockSapling;
import tomconn.growthapi.GrowthAPI;
import tomconn.growthapi.implementations.growthprofile.crop.CropGrowthProfile;
import tomconn.growthapi.implementations.growthprofile.sapling.SaplingGrowthProfile;

import static net.minecraft.init.Blocks.WHEAT;

public class RuntimeTest {

    public static void test() {
        CropGrowthProfile wheatProfile = new CropGrowthProfile();

        wheatProfile.exactLight(13);

        GrowthAPI.getRegistry().registerCropGrowPreProfile(WHEAT.getClass(), wheatProfile);

        SaplingGrowthProfile oakProfile = new SaplingGrowthProfile();

        oakProfile.setMustntSeeSky(true);

        GrowthAPI.getRegistry().registerSaplingProfile(BlockSapling.class, oakProfile);
    }

}
