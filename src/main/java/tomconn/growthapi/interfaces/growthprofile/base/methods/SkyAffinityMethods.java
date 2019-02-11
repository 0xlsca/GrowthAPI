package tomconn.growthapi.interfaces.growthprofile.base.methods;


import org.jetbrains.annotations.Nullable;
import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;

import java.util.Optional;

/**
 * This interface provides methods which concern themselves with the sky-affinity of a block.
 * <br>
 * <br>
 * A block is considered sky-affine in case a passed {@link Boolean Boolean-object} value is effectively
 * <code>true</code>
 * <br>
 * A block is considered to be <b>not</b> sky-affine in case a passed {@link Boolean Boolean-object} is effectively
 * <code>false</code>
 * <br>
 * A block is considered to <b>not be caring</b> about its LOS to the sky in case a passed {@link Boolean
 * Boolean-object} is <code>null</code>
 *
 * @param <P> The implementing method
 */
public interface SkyAffinityMethods< P extends BaseGrowthProfile< ?, P > > extends ChainingMethods< P > {

    /**
     * Sets the sky affinity
     *
     * @param skyAffinity a nullable {@link Boolean Boolean object}
     *
     * @since 0.0.6
     */
    void setSkyAffinity(@Nullable Boolean skyAffinity);


    /**
     * Returns the sky affinity in the form of an optional
     *
     * @return the sky affinity
     *
     * @since 0.0.6
     */
    Optional< Boolean > getSkyAffinity();


    /**
     * A chaining-wrapper for {@link #setSkyAffinity(Boolean)}
     *
     * @param skyAffinity the affinity to set
     *
     * @return the current instance, for chaining purposes
     *
     * @since 0.0.6
     */
    default P skyAffinity(Boolean skyAffinity) {

        setSkyAffinity(skyAffinity);

        return getThis();
    }

}
