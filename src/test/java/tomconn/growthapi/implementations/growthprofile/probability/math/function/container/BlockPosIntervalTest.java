package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import net.minecraft.util.math.BlockPos;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.interval.Interval.Bound;

import javax.annotation.Nonnull;

class BlockPosIntervalTest extends AbstractIntervalTest< BlockPos > {

    protected BlockPosIntervalTest() {

        super(
                value -> new BlockPos(
                        -value.getX(),
                        -value.getY(),
                        -value.getZ()
                ),
                new BlockPos(5, 5, 5)
        );
    }


    @Nonnull
    @Override
    Interval< BlockPos > makeInterval(Bound< BlockPos > upper, Bound< BlockPos > lower) {

        return DomainContainers.blockPosIntervalOf(upper, lower);
    }

}