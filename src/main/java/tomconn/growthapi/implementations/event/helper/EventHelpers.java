package tomconn.growthapi.implementations.event.helper;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.jetbrains.annotations.Contract;
import tomconn.growthapi.interfaces.event.helper.BaseEventHelper;

import javax.annotation.Nonnull;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This class provides static entry-points for clients to receive new {@link AbstractBaseEventHelper} instances
 *
 * @since 0.0.6
 */
public interface EventHelpers {


    /**
     * Returns a {@link BaseEventHelper}, which is specialized for the passed event, in case there is an existing mapping
     * @param event the event
     * @param <E> any inheritor {@link Event}
     * @throws NoSuchElementException if there was no mapping found for the passed event-instance
     * @return a new instance of {@link BaseEventHelper}
     */
    @Deprecated
    @Nonnull
    static < E extends Event > AbstractBaseEventHelper< E > helperFor(@Nonnull E event) {

        Objects.requireNonNull(event);

        if (event.getClass() == Pre.class) {

            //noinspection unchecked
            return (AbstractBaseEventHelper< E >) new CropGrowPreEventHelper((Pre) event);
        }

        if (event.getClass() == SaplingGrowTreeEvent.class) {

            //noinspection unchecked
            return (AbstractBaseEventHelper< E >) new SaplingGrowTreeEventHelper((SaplingGrowTreeEvent) event);
        }

        throw new NoSuchElementException();
    }


    /**
     * Returns a new {@link BaseEventHelper} which is based on the passed event
     *
     * @param event the event from which the information shall be retrieved
     *
     * @return a new {@link BaseEventHelper} instance
     *
     * @since 0.0.6
     */
    @Nonnull
    @Contract("_ -> new")
    static BaseEventHelper cropPre(Pre event) {

        return new CropGrowPreEventHelper(event);
    }


    /**
     * Returns a new {@link BaseEventHelper} which is based on the passed event
     *
     * @param event the event from which the information shall be retrieved
     *
     * @return a new {@link BaseEventHelper} instance
     *
     * @since 0.0.6
     */
    @Nonnull
    @Contract("_ -> new")
    static BaseEventHelper saplingGrowTree(SaplingGrowTreeEvent event) {

        return new SaplingGrowTreeEventHelper(event);
    }

}
