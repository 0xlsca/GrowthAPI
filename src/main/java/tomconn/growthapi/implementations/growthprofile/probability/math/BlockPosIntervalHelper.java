package tomconn.growthapi.implementations.growthprofile.probability.math;

import net.minecraft.util.math.BlockPos;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import java.util.Objects;

/**
 * This class helps with deciding whether or not a {@link BlockPos} lies within a {@link BlockPosInterval}
 *
 * @since 0.0.6
 */
public class BlockPosIntervalHelper {


    /**
     * Creates a new {@link BlockPosIntervalHelper} for the passed {@link BlockPosInterval} and {@link BlockPos}
     *
     * @param interval the interval
     * @param pos      the pos
     *
     * @return a dedicated {@link BlockPosIntervalHelper} for the passed parameters
     *
     * @since 0.0.6
     */
    public static BlockPosIntervalHelper of(BlockPosInterval interval, BlockPos pos) {

        return new BlockPosIntervalHelper(interval, pos);
    }


    private final BlockPos upper;
    private final BlockPos lower;

    private final BlockPosInterval interval;
    private final BlockPos pos;


    /**
     * Default constructor
     *
     * @param interval the interval
     * @param pos      the pos
     *
     * @since 0.0.6
     */
    protected BlockPosIntervalHelper(BlockPosInterval interval, BlockPos pos) {

        Objects.requireNonNull(interval);
        Objects.requireNonNull(pos);


        this.interval = interval;
        this.pos = pos;

        this.upper = interval.getUpperBound();
        this.lower = interval.getLowerBound();
    }


    /**
     * This method returns whether the {@link BlockPos} matches the upper bound of the interval
     *
     * @return <pre>
     * true  - if and only if the passed BlockPos matches the upper bound<br>
     * false - in all other cases
     * </pre>
     *
     * @since 0.0.6
     */
    protected boolean matchesUpper() {

        if (interval.getUpperBoundKind() == Interval.BoundKind.INCLUSIVE) {
            return belowOrEqualUpper();
        } else {
            return belowUpper();
        }
    }


    /**
     * Checks whether {@link BlockPos} is below or equal to the upper bound of the interval
     *
     * @return <span>
     * true  - if and only if <code>pos</code> is below or equal to the upper bound of the interval<br>
     * false - in all other cases
     * </span>
     *
     * @since 0.0.6
     */
    protected boolean belowOrEqualUpper() {

        return belowUpper() || interval.getUpperBound().equals(pos);
    }


    /**
     * Checks whether the {@link BlockPos} is below the upper bound of the interval
     *
     * @return <ul>
     * <li>true  - if and only if <code>pos</code> is below the upper bound of the interval<br></li>
     * <li>false - in all other cases</li>
     * </ul>
     *
     * @since 0.0.6
     */
    protected boolean belowUpper() {

        return upper.getX() < pos.getX() &&
                upper.getY() < pos.getY() &&
                upper.getZ() < pos.getZ();
    }


    /**
     * This method returns whether the {@link BlockPos} matches the lower bound of the interval
     *
     * @return <pre>
     * true  - if and only if the passed BlockPos matches the lower bound<br>
     * false - in all other cases
     * </pre>
     *
     * @since 0.0.6
     */
    protected boolean matchesLower() {

        if (interval.getLowerBoundKind() == Interval.BoundKind.INCLUSIVE) {
            return aboveOrEqualLower();
        } else {
            return aboveLower();
        }
    }


    /**
     * Checks whether the {@link BlockPos} is above the upper lower of the interval
     *
     * @return <ul>
     * <li>true  - if and only if <code>pos</code> is above the lower bound of the interval<br></li>
     * <li>false - in all other cases</li>
     * </ul>
     *
     * @since 0.0.6
     */
    protected boolean aboveLower() {

        return lower.getX() < pos.getX() &&
                lower.getY() < pos.getY() &&
                lower.getZ() < pos.getZ();
    }


    /**
     * Checks whether {@link BlockPos} is above or equal to the lower bound of the interval
     *
     * @return <span>
     * true  - if and only if <code>pos</code> is above or equal to the lower bound of the interval<br>
     * false - in all other cases
     * </span>
     *
     * @since 0.0.6
     */
    protected boolean aboveOrEqualLower() {

        return aboveLower() || interval.getLowerBound().equals(pos);
    }


    /**
     * Checks whether the provided {@link BlockPos} lies within the provided {@link BlockPosInterval}
     *
     * @return <ul>
     * <li>
     * true  - if and only if the provided {@link BlockPos} lies within the upper and lower bound of the
     * interval
     * </li>
     * <li>
     * false - in all other cases
     * </li>
     * </ul>
     *
     * @since 0.0.6
     */
    public boolean matches() {

        return matchesLower() && matchesUpper();
    }

}
