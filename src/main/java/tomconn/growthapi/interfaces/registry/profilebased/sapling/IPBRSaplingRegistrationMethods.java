package tomconn.growthapi.interfaces.registry.profilebased.sapling;

import net.minecraft.block.Block;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;
import tomconn.growthapi.interfaces.registry.profilebased.IProfileBasedRegistry;

/**
 * IPBR is the abbreviation for {@link IProfileBasedRegistry}
 */
public interface IPBRSaplingRegistrationMethods {

    /**
     * Registers a profile in this registry instance.
     *
     * @param blockClass the class of the sapling
     * @param profile its respective growth profile
     * @return true if and only if this sapling was registered and no secondary side-effects were encountered
     */
    boolean registerSaplingProfile(Class< ? extends Block > blockClass, GrowthProfile< SaplingGrowTreeEvent > profile);

    /**
     * A {@link Tuple}-array based wrapper for {@link #registerSaplingProfile(Class, GrowthProfile)} (Class, BaseGrowthProfile)}
     * @see #registerSaplingProfile(Class, GrowthProfile)
     *
     * @return an array of booleans which are index-associated with the respective inputs in the parameter
     */
    boolean[] registerSaplingProfiles(
            Tuple<
                    Class<? extends Block>,
                    GrowthProfile< SaplingGrowTreeEvent >
                    >... profiles
    );
}
