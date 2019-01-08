package tomconn.growthapi.implementations.growthprofile;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A chance-based profile depends on a chance of things to grow.
 */
public abstract class BaseProbabilityGrowthProfile< E extends Event > implements GrowthProfile< E > {


    /**
     * Default constructor. The chance-function will be initialized with a 100% chance.
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
     */
    public BaseProbabilityGrowthProfile(double chance) {

        doubleWithinBounds(chance);
        chanceFunction = e -> chance;
    }


    /**
     * An integer-based wrapper for {@link #BaseProbabilityGrowthProfile(double)}.
     *
     * @param chance an integer within the inclusive bounds of 0 and 100
     */
    public BaseProbabilityGrowthProfile(int chance) {

        this(chance / 100.0);
    }


    /**
     * Function-based constructor which sets the internal chance-function to the provided one
     *
     * @param chanceFunction the chance function you wish to set for this profile
     */
    public BaseProbabilityGrowthProfile(Function< E, Double > chanceFunction) {

        this.chanceFunction = chanceFunction;
    }


    private Function< E, Double > chanceFunction;


    /**
     * Returns the chance with which the profile will allow growth.
     *
     * @return a double within the inclusive-bounds of 0 and 1
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
     */
    public void setChance(double chance) {

        doubleWithinBounds(chance);
        chanceFunction = e -> chance;
    }


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
     */
    protected abstract Random getRandomFromEvent(E event);


    private boolean test(E event) {

        Random random = getRandomFromEvent(event);

        double rand = random.doubles(0, 1).findFirst().getAsDouble();

        return rand <= chanceFunction.apply(event);

    }

}
