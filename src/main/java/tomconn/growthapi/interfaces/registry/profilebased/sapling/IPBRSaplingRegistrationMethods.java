package tomconn.growthapi.interfaces.registry.profilebased.sapling;

import net.minecraft.block.Block;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
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
public interface IPBRSaplingRegistrationMethods {

    /**
     * Registers a profile in this registry instance.
     *
     * @param blockClass the class of the sapling
     * @param profile    its respective growth profile
     *
     * @return true if and only if this sapling was registered and no secondary side-effects were encountered
     *
     * @since 0.0.5
     */
    boolean registerSaplingProfile(Class< ? extends Block > blockClass, GrowthProfile< SaplingGrowTreeEvent, ? > profile);


    /**
     * A {@link Collection} based wrapper for {@link #registerSaplingProfile(Class, GrowthProfile)} which returns a
     * collection of tuples which could not be registered
     *
     * @param tuples a {@link Collection} of {@link Tuple Tuples}
     *
     * @return a {@link Collection} of the {@link Tuple Tuples} which could not be registered
     *
     * @since 0.0.5
     */
    default Collection< Tuple< Class< ? extends Block >, GrowthProfile< SaplingGrowTreeEvent, ? > > >
    registerSaplingProfiles(@Nonnull Collection< Tuple< Class< ? extends Block >, GrowthProfile< SaplingGrowTreeEvent, ? > > > tuples) {

        Objects.requireNonNull(tuples);

        return tuples.stream()
                .filter(t -> !registerSaplingProfile(t.getFirst(), t.getSecond()))
                .collect(Collectors.toList());
    }


    /**
     * A vararg based wrapper for {@link #registerSaplingProfiles(Collection)}
     *
     * @see #registerSaplingProfiles(Collection)
     * @since 0.0.5
     */
    default Collection< Tuple< Class< ? extends Block >, GrowthProfile< SaplingGrowTreeEvent, ? > > >
    registerSaplingProfiles(Tuple< Class< ? extends Block >, GrowthProfile< SaplingGrowTreeEvent, ? > >... profiles) {

        Objects.requireNonNull(profiles);
        return registerSaplingProfiles(Arrays.asList(profiles));
    }

}
