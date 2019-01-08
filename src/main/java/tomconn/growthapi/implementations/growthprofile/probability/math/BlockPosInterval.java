package tomconn.growthapi.implementations.growthprofile.probability.math;

import net.minecraft.util.math.BlockPos;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.PrimitiveBlockPosInterval;

import java.util.Objects;

/**
 * An implementation of {@link PrimitiveBlockPosInterval}, which is a {@link BlockPos}-based kind of an {@link Interval}
 *
 * @since 0.0.6
 */
public class BlockPosInterval implements PrimitiveBlockPosInterval {


    /**
     * Creates a new <code>BlockPosInterval</code> with an inclusive upper- and lower bound.
     *
     * @param upperBound the upper bound
     * @param lowerBound the lower bound
     *
     * @return a new <code>BlockPosInterval</code>
     *
     * @since 0.0.6
     */
    public static BlockPosInterval inclusiveOf(BlockPos upperBound, BlockPos lowerBound) {

        return of(upperBound, lowerBound, BoundKind.INCLUSIVE);
    }


    /**
     * Creates a new <code>BlockPosInterval</code> with an exclusive upper- and lower bound.
     *
     * @param upperBound the upper bound
     * @param lowerBound the lower bound
     *
     * @return a new <code>BlockPosInterval</code>
     *
     * @since 0.0.6
     */
    public static BlockPosInterval exclusiveOf(BlockPos upperBound, BlockPos lowerBound) {

        return of(upperBound, lowerBound, BoundKind.EXCLUSIVE);
    }


    /**
     * Creates a new <code>BlockPosInterval</code> with the specified bound-kind that is applied to the upper- and lower
     * bound
     *
     * @param upperBound        the upper bound
     * @param lowerBound        the lower bound
     * @param intervalBoundKind the {@link BoundKind} of the <code>upperBound</code> and <code>lowerBound</code>
     *
     * @return a new <code>BlockPosInterval</code>
     *
     * @since 0.0.6
     */
    public static BlockPosInterval of(BlockPos upperBound, BlockPos lowerBound, BoundKind intervalBoundKind) {

        return of(upperBound, intervalBoundKind, lowerBound, intervalBoundKind);
    }


    /**
     * Creates a new <code>BlockPosInterval</code> with the specified bounds and {@link BoundKind}s
     *
     * @param upperBound the upper bound
     * @param upperKind  the {@link BoundKind} of the <code>upperBound</code>
     * @param lowerBound the lower bound
     * @param lowerKind  the {@link BoundKind} of the <code>lowerBound</code>
     *
     * @return a new <code>BlockPosInterval</code> with the specified bounds and {@link BoundKind}s
     *
     * @since 0.0.6
     */
    public static BlockPosInterval of(BlockPos upperBound, BoundKind upperKind, BlockPos lowerBound, BoundKind lowerKind) {

        return new BlockPosInterval(upperBound, upperKind, lowerBound, lowerKind);
    }


    private final BlockPos upperBound;
    private final BoundKind upperKind;

    private final BlockPos lowerBound;
    private final BoundKind lowerKind;


    /**
     * Default constructor
     *
     * @param upperBound the upper bound
     * @param upperKind  the {@link BoundKind} of the upper bound
     * @param lowerBound the lower bound
     * @param lowerKind  the {@link BoundKind} of the lower bound
     *
     * @since 0.0.6
     */
    public BlockPosInterval(BlockPos upperBound, BoundKind upperKind, BlockPos lowerBound, BoundKind lowerKind) {

        Objects.requireNonNull(upperBound);
        Objects.requireNonNull(upperKind);
        Objects.requireNonNull(lowerBound);
        Objects.requireNonNull(lowerKind);


        this.upperBound = upperBound;
        this.upperKind = upperKind;
        this.lowerBound = lowerBound;
        this.lowerKind = lowerKind;
    }


    @Override
    public BlockPos getUpperBound() {

        return upperBound;
    }


    @Override
    public BoundKind getUpperBoundKind() {

        return upperKind;
    }


    @Override
    public BlockPos getLowerBound() {

        return lowerBound;
    }


    @Override
    public BoundKind getLowerBoundKind() {

        return lowerKind;
    }


    @Override
    public boolean isValuePresent(BlockPos value) {

        return new BlockPosIntervalHelper(this, value).matches();
    }

}