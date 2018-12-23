package tomconn.growthapi.interfaces.registry.profilebased.pre;

import net.minecraft.block.Block;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.growthprofile.IGrowthProfile;
import tomconn.growthapi.interfaces.registry.profilebased.IProfileBasedRegistry;

/**
 * IPBR is the abbreviation for {@link IProfileBasedRegistry}
 */
public interface IPBRPreRegistrationMethods {

    /**
     * Registers a profile in this registry instance.
     *
     * @param blockClass    the class of the block
     * @param growthProfile a {@link IGrowthProfile} which is meant to cover the
     *                      {@link Pre} event
     * @return true if and only if this profile was successfully registered and did not have any secondary side-effects
     */
    boolean registerCropGrowPreProfile(Class<? extends Block> blockClass,
                                       IGrowthProfile<Pre> growthProfile);

    /**
     * A {@link Tuple}-array based wrapper for {@link #registerCropGrowPreProfile(Class, IGrowthProfile)}
     * @see #registerCropGrowPreProfile(Class, IGrowthProfile)
     *
     * @return an array of booleans which are index-associated with the respective inputs in the parameter
     */
    boolean[] registerCropGrowPreProfiles(
            Tuple<
                    Class<? extends Block>,
                    IGrowthProfile<Pre>
                    >... tuples
    );
}
