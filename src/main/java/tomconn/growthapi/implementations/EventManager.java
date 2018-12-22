package tomconn.growthapi.implementations;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.implementations.eventhelpers.CropGrowPostEventHelper;
import tomconn.growthapi.implementations.eventhelpers.CropGrowPreEventHelper;
import tomconn.growthapi.implementations.eventhelpers.SaplingGrowTreeEventHelper;
import tomconn.growthapi.interfaces.registry.classbased.IRegistry;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class handles {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent} sub-events and {@link net.minecraftforge.event.terraingen.SaplingGrowTreeEvent}s.
 * <br>
 */
public class EventManager {

    /*
    Attributes go here
     */
    private IRegistry registry = new GAPIRegistry();


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

        List<Predicate<SaplingGrowTreeEvent>> predicates = registry.getRequirementsForSapling(helper.getBlockClass());

        event.setResult(
                processEventAnd(
                        predicates,
                        event,
                        Event.Result.ALLOW,
                        Event.Result.DENY
                )
        );

    }


    /**
     * Manages {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post} events which are passed from the
     * main mod instance
     *
     * @param event the event
     */
    public void manage(BlockEvent.CropGrowEvent.Post event) {

        CropGrowPostEventHelper helper = new CropGrowPostEventHelper(event);

        Consumer<BlockEvent.CropGrowEvent.Post> consumer = registry.getConsumerForCropPost(helper.getBlockClass());

        consumer.accept(event);
    }


    /**
     * Manages {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre} events which are passed from the
     * main mod instance.
     *
     * @param event the event
     */
    public void manage(BlockEvent.CropGrowEvent.Pre event) {
        CropGrowPreEventHelper helper = new CropGrowPreEventHelper(event);

        List<Predicate<BlockEvent.CropGrowEvent.Pre>> predicates = registry.getRequirementsForCropPre(helper.getBlockClass());

        event.setResult(
                processEventAnd(
                        predicates,
                        event,
                        Event.Result.ALLOW,
                        Event.Result.DENY
                )
        );
    }


    /**
     * This method processes an array of predicates
     *
     * @param predicates the predicates of which all shall be met
     * @param instance   the instance of the event
     * @param positive   returned if all predicates were met
     * @param negative   returned if at least one predicates wasn't met
     * @return either the passed <b>positive</b> or <b>negative</b> value
     */
    private <E> Event.Result processEventAnd(List<Predicate<E>> predicates, E instance, Event.Result positive, Event.Result negative) {
        boolean passing = predicates.stream()
                .allMatch(p -> p.test(instance));      // checks whether all predicates are true. If not, it returns false

        if (passing) {
            return positive;
        } else {
            return negative;
        }
    }
}
