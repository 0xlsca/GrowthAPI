package tomconn.growthapi.interfaces.easy.parser;


import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.ProbabilityFunction;

import javax.json.JsonStructure;

/**
 * A parser module is responsible for parsing a specific part of a JSON Object
 *
 * @since 0.0.6
 */
public interface ParserModule< E extends Event, J extends JsonStructure > {

    /**
     * <p>Parses the passed structure and applies the respective changes on the passed profile.</p>
     * <br></br>
     * <p><b>Note:</b> Whilst parsing, implementors may <b>never</b> throw an exception</p>
     *
     * @param struct the expected structure
     *
     * @return A probability function which is based on the passed input.
     *
     * @since 0.0.6
     */
    ProbabilityFunction< E > parse(J struct);

}
