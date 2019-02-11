package tomconn.growthapi.interfaces.registry.classbased;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * A class-based registry holds references to the classes of plants and assigns them a {@link Collection} of {@link
 * Predicate Predicates}
 *
 * @since 0.0.5
 */
public interface ClassBasedRegistry extends ClassRegistrationMethods, ClassRetrievalMethods {


}
