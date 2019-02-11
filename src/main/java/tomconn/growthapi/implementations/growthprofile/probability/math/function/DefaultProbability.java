package tomconn.growthapi.implementations.growthprofile.probability.math.function;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.Probability;

/**
 * <p>Default implementation of {@link Probability}.</p>
 * <p>This implementation stores the value as a double within the range of 0 and 1</p>
 *
 * @since 0.0.6
 */
public class DefaultProbability implements Probability {

    private final double probability;


    /**
     * Default constructor.
     *
     * @param probability the probability within the range of 0 and 1
     *
     * @since 0.0.6
     */
    DefaultProbability(double probability) {

        if (probability < 0 || probability > 1) {
            throw new IllegalArgumentException(String.format("Received a probability as a factor, the value was however not between the bounds of 1 and 0, was %f", probability));
        }

        this.probability = probability;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public String toString() {

        return String.format("%f%%", getAsPercentage());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public double getAsPercentage() {

        return probability * 100;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public double getAsFactor() {

        return probability;
    }

}
