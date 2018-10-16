package tomconn.growthapi.runtime_tests;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.GrowthAPI;
import tomconn.growthapi.prepackaged.cropgrowth.pre.DefaultCropGrowthPreEventHandler;
import tomconn.growthapi.prepackaged.cropgrowth.pre.DefaultCropGrowthPreEventPackage;
import tomconn.growthapi.prepackaged.cropgrowth.pre.DefaultCropGrowthPreProcessor;

import static net.minecraft.init.Blocks.WHEAT;

public class RuntimeTest {
    static {

        DefaultCropGrowthPreEventHandler handler = new DefaultCropGrowthPreEventHandler();
        GrowthAPI.instance.getEventManager().registerEventHandler(handler, BlockEvent.CropGrowEvent.Pre.class);

        DefaultCropGrowthPreProcessor<DefaultCropGrowthPreEventPackage> wheatProcessor =
                new DefaultCropGrowthPreProcessor<>(DefaultCropGrowthPreEventPackage::new);

        wheatProcessor.setResultingAssessmentConsumer(ass -> Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Wheat grew! Hooray!")));
        wheatProcessor.registerCrop(WHEAT.getClass(), p -> true);

        handler.registerProcessor(wheatProcessor);

    }
}
