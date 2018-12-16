package tomconn.growthapi.base.processor;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.base.parcel.IEventParcel;

import java.util.List;

public interface ICompositeBlockBasedEventProcessor<E extends Event, P extends IEventParcel<E>> extends ICompositeEventProcessor<E, P> {


    /**
     * Returns a list with all currently registered crop-block classes
     *
     * @return a {@link List} with all currently registered crop-block classes
     */
    List<Class<? extends Block>> getRegisteredBlockClasses();


}
