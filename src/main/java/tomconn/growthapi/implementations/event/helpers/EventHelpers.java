package tomconn.growthapi.implementations.event.helpers;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.implementations.event.helpers.crop.CropGrowPreEventHelper;
import tomconn.growthapi.implementations.event.helpers.sapling.SaplingGrowTreeEventHelper;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This class provides static entry-points for clients to receive new {@link PrimitiveEventHelper} instances
 *
 * @since 0.0.6
 */
public interface EventHelpers {

    /**
     * @param event
     * @param <E>
     *
     * @return
     *
     * @throws NoSuchElementException
     * @since 0.0.6
     */
    static < E extends Event > PrimitiveEventHelper< E > primitiveHelperFor(E event) {

        Objects.requireNonNull(event);

        if (event.getClass() == Pre.class) {

            //noinspection unchecked
            return (PrimitiveEventHelper< E >) new CropGrowPreEventHelper((Pre) event);
        }

        if (event.getClass() == SaplingGrowTreeEvent.class) {

            //noinspection unchecked
            return (PrimitiveEventHelper< E >) new SaplingGrowTreeEventHelper((SaplingGrowTreeEvent) event);
        }

        throw new NoSuchElementException();
    }

}
