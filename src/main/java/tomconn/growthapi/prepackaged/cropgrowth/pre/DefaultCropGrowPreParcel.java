package tomconn.growthapi.prepackaged.cropgrowth.pre;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent;
import tomconn.growthapi.prepackaged.cropgrowth.ICropGrowRequirementParcel;

import java.util.function.Supplier;

public class DefaultCropGrowPreParcel implements ICropGrowRequirementParcel<BlockEvent.CropGrowEvent.Pre> {

    private Supplier<Integer> lightLevelSupplier;
    private Supplier<Boolean> canSeeSkySupplier;
    private Supplier<Float> temperatureSupplier;
    private Supplier<Biome> biomeSupplier;
    private Supplier<Class<? extends Block>> blockClassSupplier;


    public DefaultCropGrowPreParcel(BlockEvent.CropGrowEvent.Pre event) {
        this.lightLevelSupplier = () -> {
            int lightLevel = event.getWorld().getLight(event.getPos());
            lightLevelSupplier = () -> lightLevel;
            return lightLevel;
        };

        this.canSeeSkySupplier = () -> {
            boolean canSee = event.getWorld().canBlockSeeSky(event.getPos());
            canSeeSkySupplier = () -> canSee;
            return canSee;
        };

        this.temperatureSupplier = () -> {
            float temperature = biomeSupplier.get().getTemperature(event.getPos());
            temperatureSupplier = () -> temperature;
            return temperature;
        };

        this.biomeSupplier = () -> {
            Biome biome = event.getWorld().getBiome(event.getPos());
            biomeSupplier = () -> biome;
            return biome;
        };

        blockClassSupplier = () -> {
            Class<? extends Block> blockClass = event.getState().getBlock().getClass();
            blockClassSupplier = () -> blockClass;
            return blockClass;
        };
    }


    @Override
    public int getLightLevel() {
        return lightLevelSupplier.get();
    }

    @Override
    public boolean canSeeSky() {
        return canSeeSkySupplier.get();
    }

    @Override
    public float getTemperature() {
        return temperatureSupplier.get();
    }

    @Override
    public Biome getBiome() {
        return biomeSupplier.get();
    }

    @Override
    public Class<? extends Block> getBlockClass() {
        return blockClassSupplier.get();
    }

    @Override
    public Class<BlockEvent.CropGrowEvent.Pre> getEventClass() {
        return BlockEvent.CropGrowEvent.Pre.class;
    }
}
