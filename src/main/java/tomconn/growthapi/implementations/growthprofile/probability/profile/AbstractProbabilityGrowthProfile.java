package tomconn.growthapi.implementations.growthprofile.probability.profile;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.implementations.growthprofile.probability.math.function.Probabilities;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.growthprofile.probability.ProbabilityGrowthProfile;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A probability-based profile depends on a probability of things to grow.
 * <p>Skeleton class of {@link ProbabilityGrowthProfile}.</p>
 *
 * @since 0.0.6
 */
abstract class AbstractProbabilityGrowthProfile< E extends Event > implements ProbabilityGrowthProfile< E > {

    private ProbabilityFunction< E > probabilityFunction;


    /**
     * Default constructor. The probability-function will be initialized with a 100% probability.
     *
     * @since 0.0.6
     */
    AbstractProbabilityGrowthProfile() {

        probabilityFunction = e -> () -> Probabilities.ofFactor(1.0);
    }


    /**
     * An integer-based wrapper for {@link #AbstractProbabilityGrowthProfile(double)}.
     *
     * @param probability an integer within the inclusive bounds of 0 and 100
     *
     * @since 0.0.6
     */
    public AbstractProbabilityGrowthProfile(int probability) {

        this(probability / 100.0);
    }


    /**
     * Value-based constructor. The probability-function will be derived from the passed value, which makes it a
     * constant function, meaning it will always return the provided value.
     *
     * @param probability the respective probability as a factor, meaning it is between 0 and 1
     *
     * @since 0.0.6
     */
    AbstractProbabilityGrowthProfile(double probability) {

        probabilityFunction = e -> () -> Probabilities.ofFactor(probability);
    }


    /**
     * Function-based constructor which sets the internal probability-function to the provided one
     *
     * @param probabilityFunction the probability function you wish to set for this profile
     *
     * @since 0.0.6
     */
    public AbstractProbabilityGrowthProfile(ProbabilityFunction< E > probabilityFunction) {

        this.probabilityFunction = probabilityFunction;
    }


    /**
     * Sets the probability for this profile. Will throw an exception if the value is above 1 or below 0.
     *
     * @param probability the probability, between 0 and 1
     *
     * @since 0.0.6
     */
    public void setChance(double probability) {

        probabilityFunction = e -> () -> Probabilities.ofFactor(probability);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Nonnull
    @Override
    public List< GrowthCondition< E > > liquidate() {

        List< GrowthCondition< E > > ret = new ArrayList<>();

        ret.add(this::test);

        return ret;
    }


    /**
     * This method rolls the dice and checks whether a probability-based function let the event pass or not
     *
     * @param event the event
     *
     * @return <ul>
     * <li>true  - if and only if the probability was high enough to pass</li>
     * <li>false - in all other cases</li>
     * </ul>
     */
    private boolean test(E event) {

        return getProbabilityFunction()
                .apply(event)
                .getValue()
                .apply(getRandomFromEvent(event));

    }


    /**
     * Returns the probability with which the profile will allow growth.
     *
     * @return a double within the inclusive-bounds of 0 and 1
     *
     * @since 0.0.6
     */
    public ProbabilityFunction< E > getProbabilityFunction() {

        return probabilityFunction;
    }


    /**
     * This method provides code which retrieves a {@link Random} instance form the passed event
     *
     * @param event the event
     *
     * @return the {@link Random}-instance which is associated with the event or a defined other instance of {@link
     * Random}
     *
     * @since 0.0.6
     */
    @Nonnull
    protected abstract Random getRandomFromEvent(E event);

}
