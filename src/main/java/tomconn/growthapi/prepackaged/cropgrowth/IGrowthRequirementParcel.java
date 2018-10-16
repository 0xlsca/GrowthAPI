package tomconn.growthapi.prepackaged.cropgrowth;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.base.IEventPackage;

public interface IGrowthRequirementParcel<E extends BlockEvent.CropGrowEvent> extends IEventPackage<E> {

    int getLightLevel();

    boolean canSeeSky();

    float getTemperature();

    Biome getBiome();

    Class<? extends Block> getBlockClass();
}
