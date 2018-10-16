package tomconn.growthapi.prepackaged.cropgrowth.pre;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.prepackaged.cropgrowth.IGrowthRequirementParcel;

import java.util.function.Supplier;

public class DefaultCropGrowthPreEventPackage implements IGrowthRequirementParcel<Pre> {

    private Pre event;

    /**
     * Fields of this class are implemented functional / lazily!
     */

    private Supplier<Integer> lightLevel = () -> {
        int ll = event.getWorld().getLight(event.getPos());
        lightLevel = () -> ll;
        return ll;
    };

    private Supplier<Boolean> canSeeSky = () -> {
        boolean css = event.getWorld().canBlockSeeSky(event.getPos());
        canSeeSky = () -> css;
        return css;
    };

    private Supplier<Float> temperature = () -> {
        float temp = getBiome().getTemperature(event.getPos());
        temperature = () -> temp;
        return temp;
    };

    private Supplier<Biome> biome = () -> {
        Biome bio = event.getWorld().getBiome(event.getPos());
        biome = () -> bio;
        return bio;
    };

    private Supplier<Class<? extends Block>> blockClass = () -> {
        Class<? extends Block> clazz = event.getState().getBlock().getClass();
        blockClass = () -> clazz;
        return clazz;
    };

    public DefaultCropGrowthPreEventPackage(Pre event) {
        this.event = event;
    }

    @Override
    public int getLightLevel() {
        return lightLevel.get();
    }

    @Override
    public boolean canSeeSky() {
        return canSeeSky.get();
    }

    @Override
    public float getTemperature() {
        return temperature.get();
    }

    @Override
    public Biome getBiome() {
        return biome.get();
    }

    @Override
    public Class<? extends Block> getBlockClass() {
        return blockClass.get();
    }

    @Override
    public Class<Pre> getEventClass() {
        return Pre.class;
    }
}
