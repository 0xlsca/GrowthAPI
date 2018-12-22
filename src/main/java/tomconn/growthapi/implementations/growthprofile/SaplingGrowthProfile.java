package tomconn.growthapi.implementations.growthprofile;


import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import tomconn.growthapi.interfaces.growthprofile.IGrowthProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SaplingGrowthProfile implements IGrowthProfile<SaplingGrowTreeEvent> {

    //TODO: implement class

    @Override
    public List<Predicate<SaplingGrowTreeEvent>> liquidate() {
        ArrayList<Predicate<SaplingGrowTreeEvent>> ret = new ArrayList<>();

        return ret;
    }
}
