package tomconn.growthapi.interfaces.growthprofile.probability.math.function;

import java.util.Random;

/**
 * <p>A probability is the likelihood with which a certain event happens.</p>
 * <p>
 * While inheritors of this interface may allow probability-values above of 100%, these values are per definition always
 * required to equal <code>true</code>.
 * </p>
 *
 * @since 0.0.6
 */
public interface Probability {

    /**
     * Returns this probability in the form of a double within the range of {@code [ 0,0 ; 100,0 ]}
     *
     * @return the double representation between 100 and 0
     *
     * @since 0.0.6
     */
    double getAsPercentage();


    /**
     * Rolls the dice and uses the provided Random-instance to tell whether or not this probability applies.
     *
     * @param random the provided random-instance
     * @param <R>    any inheritor of {@link Random}
     *
     * @return <ul>
     * <li>true  - if, and only if, the probability applied</li>
     * <li>false - in all other cases</li>
     * </ul>
     */
    default < R extends Random > boolean apply(R random) {

        double rand = random.doubles(0, 1)
                .findFirst()
                .orElseThrow(
                        () -> new IllegalStateException("Random double-stream did not contain any values. This is not good!")
                );

        return getAsFactor() <= rand;

    }


    /**
     * Returns this probability in the form of a double within the range of {@code [ 0 ; 1 ]}
     *
     * @return the double representation of this probability between 1 and 0
     *
     * @since 0.0.6
     */
    double getAsFactor();

}
