package tomconn.growthapi.implementations.easy.parser;

import net.minecraftforge.event.world.BlockEvent.CropGrowEvent.Pre;
import tomconn.growthapi.interfaces.easy.parser.ParserModule;

import java.util.HashMap;
import java.util.Map;

/**
 * A {@link Pre} specific default implementation of {@link tomconn.growthapi.interfaces.easy.parser.JSONParser}
 *
 * @since 0.0.6
 */
public class JSONParser {

    private static Map< String, ParserModule< ?, ? > > moduleMap = new HashMap<>();


    /**
     * Registers a {@link ParserModule} for the passed key
     *
     * @param keyName the JSON-key under which the module shall be applied
     * @param module  the respective module
     */
    public static synchronized void addModule(String keyName, ParserModule< ?, ? > module) {

        moduleMap.put(keyName, module);
    }


    /**
     * Attempts to remove a module and returns the found one, if there was any registered
     *
     * @param keyName the JSOn-key of the module you wish to remove
     *
     * @return the respective module, if it was installed
     */
    public static synchronized ParserModule< ?, ? > removeModule(String keyName) {

        return moduleMap.remove(keyName);
    }

}
