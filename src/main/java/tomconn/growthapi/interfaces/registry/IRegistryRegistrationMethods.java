package tomconn.growthapi.interfaces.registry;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This interface covers all the registration-specific methods of an {@link IRegistry}
 */
public interface IRegistryRegistrationMethods {

    /**
     * This method registers a crop block for consideration if a
     * {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre} event is fired.
     *
     * @param blockClass   the class of the crop block
     * @param requirements the requirements needed for the crop to grow (all need to be matched)
     * @return true if and only if the crop was successfully registered, false otherwise
     */
    boolean registerCropPre(Class<? extends Block> blockClass, Predicate<BlockEvent.CropGrowEvent.Pre>... requirements);

    /**
     * Registers a consumer which will receive a {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post}
     * event instance in case the respective class was found to be present on the event
     *
     * @param blockClass the class of the crop
     * @param consumer   the consumer
     * @return true if and only if the consumer was registered, false otherwise
     */
    boolean registerCropPost(Class<? extends Block> blockClass, Consumer<BlockEvent.CropGrowEvent.Post> consumer);

    /**
     * Registers a sapling to be considered in case a {@link SaplingGrowTreeEvent} is fired.
     *
     * @param blockClass   the class of the sapling
     * @param requirements the requirements of which all need to be met for the sapling to grow
     * @return true ifg and only if the sapling was successfully registered, false otherwise
     */
    boolean registerSapling(Class<? extends Block> blockClass, Predicate<SaplingGrowTreeEvent>... requirements);

}
