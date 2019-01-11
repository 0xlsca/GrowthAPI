package tomconn.growthapi.interfaces.registry.profilebased.pre;

import net.minecraft.block.Block;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;
import tomconn.growthapi.interfaces.registry.profilebased.ProfileBasedRegistry;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * IPBR is the abbreviation for {@link ProfileBasedRegistry}
 *
 * @since 0.0.5
 */
public interface IPBRPreRegistrationMethods {

    /**
     * Registers a profile in this registry instance.
     *
     * @param blockClass    the class of the block
     * @param growthProfile a {@link GrowthProfile} which is meant to cover the {@link Pre} event
     *
     * @return true if and only if this profile was successfully registered and did not have any secondary side-effects
     *
     * @since 0.0.5
     */
    boolean registerCropGrowPreProfile(Class< ? extends Block > blockClass, GrowthProfile< Pre, ? > growthProfile);


    /**
     * A collection-based wrapper method for {@link #registerCropGrowPreProfile(Class, GrowthProfile)} which returns all
     * tuples which could not be registered
     *
     * @param tuples a {@link Collection} of classes and their associated profiles
     *
     * @return a {@link Collection} of all tuples which could not be registered
     *
     * @since 0.0.5
     */
    default Collection< Tuple< Class< ? extends Block >, GrowthProfile< Pre, ? > > > registerCropGrowPreProfiles(@Nonnull Collection< Tuple< Class< ? extends Block >, GrowthProfile< Pre, ? > > > tuples) {

        Objects.requireNonNull(tuples);

        return tuples.stream()
                .filter(t -> !registerCropGrowPreProfile(t.getFirst(), t.getSecond()))
                .collect(Collectors.toList());
    }


    /**
     * A vararg based wrapper for {@link #registerCropGrowPreProfiles(Collection)}
     *
     * @see #registerCropGrowPreProfiles(Collection)
     * @since 0.0.5
     */
    default Collection< Tuple< Class< ? extends Block >, GrowthProfile< Pre, ? > > > registerCropGrowPreProfiles(
            Tuple< Class< ? extends Block >, GrowthProfile< Pre, ? > >... tuples
    ) {

        return registerCropGrowPreProfiles(Arrays.asList(tuples));
    }

}
