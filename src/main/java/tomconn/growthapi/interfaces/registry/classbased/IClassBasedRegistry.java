package tomconn.growthapi.interfaces.registry.classbased;

/**
 * This interface provides methods which are supposed to be implemented by every registry.
 * A registry is an object which holds references to all blocks which can show up in any of the three in this API
 * covered events ({@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre},
 * {@link net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Post} and
 * {@link net.minecraftforge.event.terraingen.SaplingGrowTreeEvent}).
 */
public interface IClassBasedRegistry extends ICBRRegistrationMethods, ICBRRetrievalMethods {


}
