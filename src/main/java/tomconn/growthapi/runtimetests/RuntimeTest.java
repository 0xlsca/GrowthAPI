package tomconn.growthapi.runtimetests;

import tomconn.growthapi.GrowthAPI;
import tomconn.growthapi.implementations.growthprofile.CropGrowthProfile;

import static net.minecraft.init.Blocks.WHEAT;

public class RuntimeTest {

    public static void test() {
        CropGrowthProfile wheatProfile = new CropGrowthProfile();

        wheatProfile.exactLight(13);

        GrowthAPI.getRegistry().registerCropGrowPreProfile(WHEAT.getClass(), wheatProfile);
    }

}
