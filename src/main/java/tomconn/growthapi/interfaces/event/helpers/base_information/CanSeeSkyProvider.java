package tomconn.growthapi.interfaces.event.helpers.base_information;

public interface CanSeeSkyProvider {

    /**
     * Returns whether the triggering block can see the sky
     *
     * @return true iof the block has a line of sight to the sky, false otherwise
     *
     * @since 0.0.6
     */
    boolean canSeeSky();

}
