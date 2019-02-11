package tomconn.growthapi.interfaces.growthprofile.base.methods;

import tomconn.growthapi.interfaces.growthprofile.base.BaseGrowthProfile;

/**
 * This method is crucial for chaining methods. It adds the {@link #getThis()} method, which provides a parameterized
 * return value and helps with precise chaining
 *
 * @param <P> the class which implements {@link BaseGrowthProfile}
 *
 * @since 0.0.6
 */
public interface ChainingMethods< P extends BaseGrowthProfile< ?, P > > {

    /**
     * Returns the reference to the current instance
     *
     * @return the current instance
     *
     * @since 0.0.6
     */
    P getThis();

}
