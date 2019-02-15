package tomconn.growthapi.interfaces.event.helper.base_information;

public interface LightLevelProvider {

    /**
     * Returns the light-level of the block. Please note that this is the fixed light-level and therefor is
     * unaffected by the day-night-cycle
     *
     * @return the day-night-cycle independent light-level of the block
     *
     * @since 0.0.6
     */
    int getLightLevel();

}
