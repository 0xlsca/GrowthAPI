package tomconn.growthapi.interfaces.event.helper.base_information;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public interface BlockPosProvider {

    /**
     * Returns the {@link BlockPos} of the {@link Block} which triggered the event
     *
     * @return the {@link BlockPos}
     *
     * @since 0.0.6
     */
    BlockPos getBlockBos();

}
