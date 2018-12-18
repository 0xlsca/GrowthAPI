package tomconn.growthapi.interfaces;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface GAPIRegisterInterface {

    /**
     * This method registers a given {@link Block} with the passed requirements.
     * If a {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre} event is fired and the target block is
     * found to be the registered block, the requirements will be checked and in case <b>all</b> apply, the event
     * will be marked as passing.
     *
     * @param blockClass   the class of the crop
     * @param requirements the requirements which are needed to be met in order for the block to grow
     * @return <ul>
     * <li>true     -   if and only if the block was successfully registered and this block was not registered
     * before</li>
     * <li>false    -   in all other cases</li>
     * </ul>
     */
    boolean registerCropPre(Class<? extends Block> blockClass, Predicate<BlockEvent.CropGrowEvent.Pre>... requirements);

    /**
     * This method registers a given {@link Block}.
     * If a {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post} event is fired and the target block is
     * found to be the registered block, the respective event will be passed to the provided consumer.
     *
     * @param blockClass the class of the crop
     * @param consumer   the consumer which will receive respective
     *                   {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post} events
     * @return <ul>
     * <li>true     -   if and only if the block was successfully registered and this block was not registered
     * before</li>
     * <li>false    -   in all other cases</li>
     * </ul>
     */
    boolean registerCropPost(Class<? extends Block> blockClass, Consumer<BlockEvent.CropGrowEvent.Post> consumer);

    /**
     * This method registers a given {@link Block} with the assed requirements.
     * If a {@link SaplingGrowTreeEvent} is fired and the target block is found to be the registered block, the
     * requirements will be checked and in case <b>all</b> apply, the event will be marked as passing.
     *
     * @param blockClass   the class of the sapling / block
     * @param requirements the requirements
     * @return <ul>
     * *     <li>true     -   if and only if the block was successfully registered and this block was not registered
     * *     before</li>
     * *     <li>false    -   in all other cases</li>
     * * </ul>
     */
    boolean registerSamplingGrowTree(Class<? extends Block> blockClass, Predicate<SaplingGrowTreeEvent>... requirements);
}
