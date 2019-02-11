package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import net.minecraft.util.math.BlockPos;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Bound;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;

import javax.annotation.Nonnull;
import java.util.Comparator;

/**
 * A special-case implementation of {@link Interval} for {@link BlockPos}.<br>
 * <br>
 * This is required because instances of {@link BlockPos} are not easily comparable against other instances
 */
class BlockPosInterval extends AbstractInterval< BlockPos > {

    @Nonnull
    private final Comparator< BlockPos > upperComparator;
    @Nonnull
    private final Comparator< BlockPos > lowerComparator;


    {
        /*
          Returns -1, 0 or 1 depending on whether p1 is wholly smaller, wholly equal or minimally greater than p2
         */
        upperComparator = (p1, p2) -> {
            if (p1.equals(p2)) {
                return 0;
            }
            if (
                    p1.getX() < p2.getX() &&
                            p1.getY() < p2.getY() &&
                            p1.getZ() < p2.getZ()
            ) {
                return -1;
            }
            return 1;
        };

        /*
          Returns -1, 0 or 1 depending on whether p1 is minimally smaller, wholly equal or wholly greater than p2
         */
        lowerComparator = (p1, p2) -> {
            if (p1.equals(p2)) {
                return 0;
            }
            if (
                    p1.getX() > p2.getX() &&
                            p1.getY() > p2.getY() &&
                            p1.getZ() > p2.getZ()
            ) {
                return 1;
            }
            return -1;
        };

    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    BlockPosInterval(Bound< BlockPos > upperBound, Bound< BlockPos > lowerBound) {

        super(upperBound, lowerBound);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public boolean isValuePresent(BlockPos value) {

        return matchesUpper(value, upperComparator) && matchesLower(value, lowerComparator);
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public Interval< BlockPos > withUpperBound(Bound< BlockPos > upper) {

        return new BlockPosInterval(upper, this.getLowerBound());
    }


    /**
     * {@inheritDoc}
     *
     * @since 0.0.6
     */
    @Override
    public Interval< BlockPos > withLowerBound(Bound< BlockPos > lower) {

        return new BlockPosInterval(this.getUpperBound(), lower);
    }

}
