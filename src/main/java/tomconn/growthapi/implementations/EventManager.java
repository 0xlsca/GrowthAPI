package tomconn.growthapi.implementations;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.implementations.eventhelpers.SaplingGrowTreeEventHelper;
import tomconn.growthapi.interfaces.IRegistry;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * This class handles {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent} sub-events and {@link net.minecraftforge.event.terraingen.SaplingGrowTreeEvent}s.
 * <br>
 * This class is a singleton.
 */
public class EventManager {

    /*
    Singleton stuff
     */
    private static EventManager instance = new EventManager();

    private EventManager() {
    }

    public static EventManager getInstance() {
        return instance;
    }


    /*
    Attributes go here
     */
    private IRegistry registry = GAPIRegistry.getInstance();


    /*
    Methods go here
     */

    /**
     * Manages {@link SaplingGrowTreeEvent}s which are passed from the main mod class
     *
     * @param event the event
     */
    public void manage(SaplingGrowTreeEvent event) {

        SaplingGrowTreeEventHelper helper = new SaplingGrowTreeEventHelper(event);

        Predicate<SaplingGrowTreeEvent>[] predicates = registry.getRequirementsForSapling(helper.getBlockClass());

        //test the predicate
        boolean passing = Arrays.stream(predicates)
                .allMatch(p -> p.test(event));      // checks whether all predicates are true. If not, it returns false

        if (passing) {
            event.setResult(Event.Result.ALLOW);
        } else {
            event.setResult(Event.Result.DENY);
        }

    }

    /**
     * Manages {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post} events which are passed form the
     * main mod instance
     *
     * @param event the event
     */
    public void manage(BlockEvent.CropGrowEvent.Post event) {

    }

    public void manage(BlockEvent.CropGrowEvent.Pre event) {

    }
}
