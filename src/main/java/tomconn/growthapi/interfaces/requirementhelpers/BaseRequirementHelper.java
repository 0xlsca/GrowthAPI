package tomconn.growthapi.interfaces.requirementhelpers;

import net.minecraftforge.fml.common.eventhandler.Event;
import tomconn.growthapi.interfaces.base.GrowthCondition;
import tomconn.growthapi.interfaces.requirementhelpers.base_requirements.BiomeRequirements;
import tomconn.growthapi.interfaces.requirementhelpers.base_requirements.LightLevelRequirements;
import tomconn.growthapi.interfaces.requirementhelpers.base_requirements.SkyRequirements;
import tomconn.growthapi.interfaces.requirementhelpers.base_requirements.TemperatureRequirements;

import java.util.function.Predicate;

/**
 * Provides methods which help with creating basic requirements in the form of {@link Predicate Predicates}. <br>
 * RequirementHelpers act as a shortcut to create {@link GrowthCondition GrowthConditions}.<br> They take away the
 * creation process of {@link GrowthCondition GrowthConditions} and simply take in parameters and boolean logic.
 *
 * @param <E> any inheritor of {@link Event}
 *
 * @since 0.0.6
 */
public interface BaseRequirementHelper< E extends Event > extends
        LightLevelRequirements< E >,
        TemperatureRequirements< E >,
        SkyRequirements< E >,
        BiomeRequirements< E > {

}
