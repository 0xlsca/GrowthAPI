package tomconn.growthapi.implementations.growthprofile.probability.math.function.container;

import org.junit.jupiter.api.Test;

public class IntervalTest {

    @Test
    void testIntervals() {

        new BlockPosIntervalTest().testIsValuePresent();
        new DefaultIntervalTest<>(5, i -> -i, Integer::compareTo).testIsValuePresent();
    }

}
