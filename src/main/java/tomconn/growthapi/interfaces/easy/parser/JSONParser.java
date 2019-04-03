package tomconn.growthapi.interfaces.easy.parser;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.growthprofile.GrowthProfile;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;

/**
 * A JSONParser is an object which takes an input string and converts it into a {@link GrowthProfile} or {@link
 * GrowthCondition GrowthConditions}
 *
 * @since 0.0.6
 */
public interface JSONParser< E extends Event > {

    /**
     * <p>Parses the passed String.</p>
     * <br></br>
     * <p><b>Note:</b> Whilst parsing, implementors may <b>never</b> throw an exception</p>
     *
     * @param input the input String, in JSON format
     *
     * @return a respective {@link GrowthProfile}
     *
     * @since 0.0.6
     */
    ProbabilityFunction< E > parse(String input);

}
