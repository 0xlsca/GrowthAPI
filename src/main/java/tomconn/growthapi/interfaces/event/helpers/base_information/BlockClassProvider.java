package tomconn.growthapi.interfaces.event.helpers.base_information;

import net.minecraft.block.Block;

public interface BlockClassProvider {

    /**
     * Returns the class of the block which triggered the event.
     *
     * @return the block's class
     *
     * @since 0.0.6
     */
    Class< ? extends Block > getBlockClass();


}
