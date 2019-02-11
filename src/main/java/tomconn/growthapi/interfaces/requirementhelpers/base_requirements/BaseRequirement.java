package tomconn.growthapi.interfaces.requirementhelpers.base_requirements;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.event.helpers.BaseEventHelper;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Provides methods which all base-requirements can rely on
 *
 * @param <E> any inheritor of {@link Event}
 *
 * @since 0.0.6
 */
public interface BaseRequirement< E extends Event > {

    /**
     * Returns an instance of {@link BaseEventHelper} which is specialized for the event
     *
     * @param event an instance of the event
     *
     * @return a specialized {@link BaseEventHelper}
     *
     * @since 0.0.6
     */
    BaseEventHelper supplyHelper(E event);


    /**
     * This method helps with tailoring conditions based on a supplier -> predicate flow
     *
     * @param predicate the predicate which shall be met
     * @param supplier  a supplier, which takes in an instance of the event-type and returns the type of the predicate
     * @param <T>       any type
     *
     * @return a new {@link GrowthCondition} which is tailored to the passed predicate and supplier
     *
     * @since 0.0.6
     */
    default < T > GrowthCondition< E > tailorCondition(Predicate< T > predicate, Function< E, T > supplier) {

        return e -> predicate.test(supplier.apply(e));
    }

}
