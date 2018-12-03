package tomconn.growthapi.prepackaged.cropgrowth.pre;

import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.prepackaged.cropgrowth.ICropGrowthRequirementParcel;

import java.util.function.Supplier;

public class DefaultCropCropGrowthPreEventParcel implements ICropGrowthRequirementParcel<Pre> {

    private Pre event;

    /**
     * Fields of this class are implemented functional / lazily!
     */

    private Supplier<Integer> lightLevel = () -> {
        try {
            int ll = event.getWorld().getLight(event.getPos());
            lightLevel = () -> ll;
            return ll;
        } catch (NullPointerException npe) {
            lightLevel = () -> null;
            return null;
        }
    };

    private Supplier<Boolean> canSeeSky = () -> {
        try {
            boolean css = event.getWorld().canBlockSeeSky(event.getPos());
            canSeeSky = () -> css;
            return css;
        } catch (Exception e) {
            canSeeSky = () -> null;
            return null;
        }
    };

    private Supplier<Float> temperature = () -> {
        try {
            float temp = getBiome().getTemperature(event.getPos());
            temperature = () -> temp;
            return temp;
        } catch (Exception e) {
            temperature = () -> null;
            return null;
        }
    };

    private Supplier<Biome> biome = () -> {
        try {
            Biome bio = event.getWorld().getBiome(event.getPos());
            biome = () -> bio;
            return bio;
        } catch (Exception e) {
            biome = () -> null;
            return null;
        }
    };

    private Supplier<Class<? extends Block>> blockClass = () -> {
        try {
            Class<? extends Block> clazz = event.getState().getBlock().getClass();
            blockClass = () -> clazz;
            return clazz;
        } catch (Exception e) {
            blockClass = () -> null;
            return null;
        }
    };

    public DefaultCropCropGrowthPreEventParcel(Pre event) {
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
