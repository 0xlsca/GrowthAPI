package tomconn.growthapi.interfaces.registry.classbased;

import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.implementations.growthprofile.probability.math.function.Probabilities;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * This interface covers all the registration-specific methods of a {@link ClassBasedRegistry}
 *
 * @since 0.0.5
 */
public interface ClassRegistrationMethods {

    /**
     * This method registers a {@link Block}-{@link Class} for the {@link Pre} event with a collection of {@link
     * GrowthCondition GrowthConditions}
     *
     * @param blockClass   the class of the crop block
     * @param requirements the requirements needed for the crop to grow
     *
     * @return true if and only if the crop was successfully registered, false otherwise
     *
     * @since 0.0.5
     */
    boolean registerCropPre(Class< ? extends Block > blockClass, Collection< GrowthCondition< Pre > > requirements);


    /**
     * This method registers a {@link Block}-{@link Class} for the {@link Post} event with a {@link Consumer} for the
     * event instance
     *
     * @param blockClass the class of the crop block
     * @param consumer   the consumer to be called once a matching event is fired
     *
     * @return true if and only if the consumer was successfully registered for the block class, false otherwise
     *
     * @since 0.0.5
     */
    boolean registerCropPost(Class< ? extends Block > blockClass, Consumer< Post > consumer);


    /**
     * This method registers a {@link Block}-{@link Class} for the {@link SaplingGrowTreeEvent}  with a collection of
     * {@link GrowthCondition GrowthConditions}
     *
     * @param blockClass   the class of the crop block
     * @param requirements the requirements needed for the crop to grow
     *
     * @return true if and only if the crop was successfully registered, false otherwise
     *
     * @since 0.0.5
     */
    boolean registerSapling(Class< ? extends Block > blockClass, Collection< GrowthCondition< SaplingGrowTreeEvent > > requirements);


    /**
     * Default-wrapper for {@link #registerCropPre(Class, Collection)}
     *
     * @param blockClass  the class of the crop
     * @param probability the probability, which must be conforming to {@link Probabilities#ofFactor(double)}
     *
     * @return see {@link #registerCropPre(Class, Collection)}
     *
     * @since 0.0.6
     */
    default boolean registerCropPre(Class< ? extends Block > blockClass, double probability) {

        Objects.requireNonNull(blockClass);

        Probability prob = Probabilities.ofFactor(probability);
        return registerCropPre(blockClass, Collections.singleton(e -> prob.apply(e.getWorld().rand)));
    }

}
