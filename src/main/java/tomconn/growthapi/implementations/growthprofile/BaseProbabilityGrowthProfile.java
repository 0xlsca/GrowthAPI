package tomconn.growthapi.implementations.growthprofile;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A chance-based profile depends on a chance of things to grow.
 *
 * @since 0.0.6
 */
abstract class BaseProbabilityGrowthProfile< E extends Event, P extends GrowthProfile< E, P > > implements GrowthProfile< E, P > {


    /**
     * Default constructor. The chance-function will be initialized with a 100% chance.
     *
     * @since 0.0.6
     */
    public BaseProbabilityGrowthProfile() {

        chanceFunction = e -> 1.0;
    }


    /**
     * Value-based constructor. The chance-function will be derived from the passed value, which makes it a constant
     * function, meaning it will always return the provided value.
     *
     * @param chance the respective chance
     *
     * @see #doubleWithinBounds(double)
     * @since 0.0.6
     */
    public BaseProbabilityGrowthProfile(double chance) {

        doubleWithinBounds(chance);
        chanceFunction = e -> chance;
    }


    /**
     * An integer-based wrapper for {@link #BaseProbabilityGrowthProfile(double)}.
     *
     * @param chance an integer within the inclusive bounds of 0 and 100
     * @since 0.0.6
     */
    public BaseProbabilityGrowthProfile(int chance) {

        this(chance / 100.0);
    }


    /**
     * Function-based constructor which sets the internal chance-function to the provided one
     *
     * @param chanceFunction the chance function you wish to set for this profile
     * @since 0.0.6
     */
    public BaseProbabilityGrowthProfile(Function< E, Double > chanceFunction) {

        this.chanceFunction = chanceFunction;
    }


    private Function< E, Double > chanceFunction;


    /**
     * Returns the chance with which the profile will allow growth.
     *
     * @return a double within the inclusive-bounds of 0 and 1
     * @since 0.0.6
     */
    public Function< E, Double > getChanceFunction() {

        return chanceFunction;
    }


    /**
     * Sets the chance for this profile.
     * Will throw an exception if the value is above 1 or below 0.
     *
     * @param chance the chance
     *
     * @throws IllegalArgumentException If the passed value was not within the expected bounds
     * @see #doubleWithinBounds(double)
     * @since 0.0.6
     */
    public void setChance(double chance) {

        doubleWithinBounds(chance);
        chanceFunction = e -> chance;
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Nonnull
    @Override
    public List< Predicate< E > > liquidate() {

        List< Predicate< E > > ret = new ArrayList<>();

        ret.add(this::test);

        return ret;
    }


    /**
     * Throws an {@link IllegalArgumentException} if the passed value is not within the inclusive bounds of 0 to 1
     *
     * @param num the number
     *
     * @throws IllegalArgumentException If the passed value was not within the expected bounds
     *
     * @since 0.0.6
     */
    private void doubleWithinBounds(double num) {

        if (0 > num || 1 < num) {
            throw new IllegalArgumentException("The passed value is supposed to be between 0.0 and 1.0, was " + num);
        }
    }


    /**
     * This method provides code which retrieves a {@link Random} instance form the passed event
     *
     * @param event the event
     *
     * @return the {@link Random}-instance which is associated with the event
     * @since 0.0.6
     */
    @Nonnull
    protected abstract Random getRandomFromEvent(E event);


    /**
     * This method rolls the dice and checks whether a probability-based function let the event pass or not
     *
     * @param event the event
     * @return <ul>
     *     <li>true  - if and only if the probability was high enough to pass</li>
     *     <li>false - in all other cases</li>
     * </ul>
     */
    private boolean test(E event) {

        Random random = getRandomFromEvent(event);

        double rand = random.doubles(0, 1)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Random Double-stream was empty. This is bad."));

        return rand <= chanceFunction.apply(event);

    }

}
