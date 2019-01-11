package tomconn.growthapi.implementations.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.implementations.event.handlers.SaplingGrowTreeEventHandler;
import tomconn.growthapi.implementations.event.helpers.crop.CropGrowPostEventHelper;
import tomconn.growthapi.implementations.event.helpers.crop.CropGrowPreEventHelper;
import tomconn.growthapi.implementations.event.helpers.sapling.SaplingGrowTreeEventHelper;
import tomconn.growthapi.implementations.registry.GrowthRegistry;
import tomconn.growthapi.interfaces.registry.Registry;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class handles {@link CropGrowEvent} sub-events and {@link SaplingGrowTreeEvent}s.
 * <br>
 */
public class EventManager {

    static {
        MinecraftForge.TERRAIN_GEN_BUS.register(SaplingGrowTreeEventHandler.class);
    }


    @Nonnull
    public Registry getRegistry() {
        return registry;
    }

    /*
        Attributes go here
         */
    @Nonnull
    private Registry registry = new GrowthRegistry();


    /*
    Methods go here
     */

    /**
     * Manages {@link SaplingGrowTreeEvent}s which are passed from the main mod class
     *
     * @param event the event
     */
    public void manage(@Nonnull SaplingGrowTreeEvent event) {

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
     * Manages {@link CropGrowEvent.Post} events which are passed from the
     * main mod instance
     *
     * @param event the event
     */
    public void manage(BlockEvent.CropGrowEvent.Post event) {

        CropGrowPostEventHelper helper = new CropGrowPostEventHelper(event);

        Consumer<BlockEvent.CropGrowEvent.Post> consumer = registry.getConsumerForCropPost(helper.getBlockClass());

        if (consumer != null) {
            consumer.accept(event);
        }
    }


    /**
     * Manages {@link CropGrowEvent.Pre} events which are passed from the
     * main mod instance.
     *
     * @param event the event
     */
    public void manage(@Nonnull BlockEvent.CropGrowEvent.Pre event) {
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
