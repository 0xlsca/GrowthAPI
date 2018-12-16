package tomconn.growthapi.runtime_tests;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.GrowthAPI;

import static net.minecraft.init.Blocks.WHEAT;

public class RuntimeTest {
    static {

        DefaultCropGrowthPreEventHandler handler = new DefaultCropGrowthPreEventHandler();
        GrowthAPI.instance.getEventManager().registerEventHandler(handler, BlockEvent.CropGrowEvent.Pre.class);

        DefaultCropGrowthPreProcessor<DefaultCropCropGrowthPreEventParcel> wheatProcessor =
                new DefaultCropGrowthPreProcessor<>(DefaultCropCropGrowthPreEventParcel::new);

        wheatProcessor.setResultingAssessmentConsumer(ass -> Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Wheat grew! Hooray!")));
        wheatProcessor.registerCrop(WHEAT.getClass(), p -> true);

        handler.registerProcessor(wheatProcessor);

    }
}
