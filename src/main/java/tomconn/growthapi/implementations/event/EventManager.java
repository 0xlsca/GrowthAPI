package tomconn.growthapi.implementations.event;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import tomconn.growthapi.implementations.event.handlers.SaplingGrowTreeEventHandler;
import tomconn.growthapi.implementations.event.helpers.CropGrowPostEventHelper;
import tomconn.growthapi.implementations.event.helpers.EventHelpers;
import tomconn.growthapi.implementations.registry.GrowthRegistry;
import tomconn.growthapi.interfaces.event.helpers.BaseEventHelper;
import tomconn.growthapi.interfaces.registry.UnifiedRegistry;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This class handles {@link CropGrowEvent} sub-events and {@link SaplingGrowTreeEvent}s.
 * <br>
 *
 * @since 0.0.5
 */
public class EventManager {

    static {
        MinecraftForge.TERRAIN_GEN_BUS.register(SaplingGrowTreeEventHandler.class);
    }


    /*
        Attributes go here
         */
    @Nonnull
    private UnifiedRegistry unifiedRegistry = new GrowthRegistry();


    /**
     * Returns the currently help {@link UnifiedRegistry}
     *
     * @return the unifiedRegistry
     *
     * @since 0.0.5
     */
    @Nonnull
    public UnifiedRegistry getUnifiedRegistry() {

        return unifiedRegistry;
    }


    /*
    Methods go here
     */


    /**
     * Manages {@link SaplingGrowTreeEvent}s which are passed from the main mod class
     *
     * @param event the event
     *
     * @since 0.0.5
     */
    public void manage(@Nonnull SaplingGrowTreeEvent event) {

        BaseEventHelper helper = EventHelpers.saplingGrowTree(event);

        Optional< Collection< ? extends Predicate< SaplingGrowTreeEvent > > > predicates = unifiedRegistry.getRequirementsForSapling(helper.getBlockClass());

        if (predicates.isPresent()) {
            event.setResult(
                    processEventAnd(
                            predicates.get(),
                            event,
                            Event.Result.ALLOW,
                            Event.Result.DENY
                    )
            );
        } else {
            event.setResult(Result.DEFAULT);
        }


    }


    /**
     * This method processes an array of predicates
     *
     * @param predicates the predicates of which all shall be met
     * @param instance   the instance of the event
     * @param positive   returned if all predicates were met
     * @param negative   returned if at least one predicates wasn't met
     *
     * @return either the passed <b>positive</b> or <b>negative</b> value
     *
     * @since 0.0.5
     */
    private < E > Event.Result processEventAnd(Collection< ? extends Predicate< E > > predicates, E instance, Event.Result positive, Event.Result negative) {

        boolean passing = predicates.stream()
                .allMatch(p -> p.test(instance));      // checks whether all predicates are true. If not, it returns false

        if (passing) {
            return positive;
        } else {
            return negative;
        }
    }


    /**
     * Manages {@link CropGrowEvent.Post} events which are passed from the main mod instance
     *
     * @param event the event
     *
     * @since 0.0.5
     */
    public void manage(BlockEvent.CropGrowEvent.Post event) {

        CropGrowPostEventHelper helper = new CropGrowPostEventHelper(event);

        Optional< Consumer< Post > > consumer = unifiedRegistry.getConsumerForCropPost(helper.getBlockClass());

        consumer.ifPresent(c -> c.accept(event));
    }


    /**
     * Manages {@link Pre} events which are passed from the main mod instance.
     *
     * @param event the event
     *
     * @since 0.0.5
     */
    public void manage(@Nonnull Pre event) {

        BaseEventHelper helper = EventHelpers.cropPre(event);

        Optional< Collection< ? extends Predicate< Pre > > > predicates = unifiedRegistry.getRequirementsForCropPre(helper.getBlockClass());

        if (predicates.isPresent()) {
            event.setResult(
                    processEventAnd(
                            predicates.get(),
                            event,
                            Event.Result.ALLOW,
                            Event.Result.DENY
                    )
            );
        } else {
            event.setResult(Result.DEFAULT);
        }
    }

}
