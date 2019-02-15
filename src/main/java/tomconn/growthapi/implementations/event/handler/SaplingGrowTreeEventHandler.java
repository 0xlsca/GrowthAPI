package tomconn.growthapi.implementations.event.handler;

import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tomconn.growthapi.GrowthAPI;

public class SaplingGrowTreeEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void saplingGrowTree(SaplingGrowTreeEvent event) {
        GrowthAPI.getEventManager().manage(event);
    }

}
