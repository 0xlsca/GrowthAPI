package tomconn.growthapi.interfaces.registry.classbased;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;

/**
 * This interface provides methods which are supposed to be implemented by every registry.
 * A registry is an object which holds references to all blocks which can show up in any of the three in this API
 * covered events ({@link CropGrowEvent.Pre},
 * {@link CropGrowEvent.Post} and
 * {@link SaplingGrowTreeEvent}).
 */
public interface IClassBasedRegistry extends ICBRRegistrationMethods, ICBRRetrievalMethods {


}
