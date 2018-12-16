package tomconn.growthapi.prepackaged.cropgrowth;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.base.parcel.IEventParcel;

public interface ICropGrowRequirementParcel<E extends BlockEvent.CropGrowEvent> extends IEventParcel<E> {

    int getLightLevel();

    boolean canSeeSky();

    float getTemperature();

    Biome getBiome();

    Class<? extends Block> getBlockClass();
}
