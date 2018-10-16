package tomconn.growthapi.base;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;

public interface ICompositeBlockBasedEventProcessor<E extends Event, P extends IEventPackage<E>> extends ICompositeEventProcessor<E, P> {


    /**
     * Returns a list with all currently registered crop-block classes
     *
     * @return a {@link List} with all currently registered crop-block classes
     */
    List<Class<? extends Block>> getRegisteredBlockClasses();


}
