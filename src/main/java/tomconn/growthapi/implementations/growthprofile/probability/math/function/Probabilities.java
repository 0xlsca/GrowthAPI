package tomconn.growthapi.implementations.growthprofile.probability.math.function;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;

/**
 * This class provies static-level entry methods for obtaining {@link Probability}-instances
 *
 * @since 0.0.6
 */
public interface Probabilities {

    /**
     * <p>Returns a new {@link Probability}-instance with the passed factor.</p>
     *
     * @param probability the probability, being in range between 0 and 1
     *
     * @return a new instance
     *
     * @throws IllegalArgumentException if the passed value was out of bounds
     * @since 0.0.6
     */
    static Probability ofFactor(double probability) {

        return new DefaultProbability(probability);
    }


    /**
     * <p>Returns a new {@link Probability}-instance with the passed percentage.</p>
     *
     * @param percentage the percentage, being between 0 and 100
     *
     * @return a new instance
     *
     * @throws IllegalArgumentException if the passed value was out of bounds
     * @since 0.0.6
     */
    static Probability ofPercentage(double percentage) {

        return new DefaultProbability(percentage / 100.0);
    }

}
