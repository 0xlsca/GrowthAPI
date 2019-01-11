package tomconn.growthapi.interfaces.growthprofile.probability.math.function;

import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.CoDomainContainer;
import tomconn.growthapi.interfaces.growthprofile.probability.math.function.container.DomainContainer;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.function.Function;

/**
 * A mathematical function is a relation between two sets.<br>
 * With the relation, each element of the domain is assigned <u>exactly one</u> element of the co-domain.<br>
 * <br>
 * <b>Note:</b> <u>Every</u> element of the domain has <u>exactly one</u> associated element in the co-domain, but
 * not every element in the co-domain needs to be associated to an element in the domain.
 * <br>
 * <br>
 * Classes which implement this interface are constrained to raise the specified exception in case they encounter
 * the following behavior:<br>
 * <br>
 * <ul>
 * <li>
 * <pre>
 * a value of the type of the domain was passed to the function but there was no associated element present in
 * the co-domain:               {@link MissingMappingException}<br>
 * </pre>
 * </li>
 * <li>
 * <pre>
 * a value of the type of the domain was passed to the function and two or more associated elements present in the
 * co-domain were found:        {@link MultiMappingException}
 * </pre>
 * </li>
 * </ul>
 *
 * @param <D> the type of the domain
 * @param <C> the type of the co-domain
 *
 * @since 0.0.6
 */
public interface MathematicalFunction< D, C > extends Function< DomainContainer< D >, CoDomainContainer< C > > {


    /**
     * Instances of this class are raised if a {@link ProbabilityFunction} encounters a value to which it does not have a mapping
     *
     * @since 0.0.6
     */
    class MissingMappingException extends MaldefinedProbabilityFunctionException {

        /**
         * Default constructor
         *
         * @param valueRepresentation a String-representation of the value which has no mapping in the
         *                            {@link ProbabilityFunction}
         *
         * @since 0.0.6
         */
        public MissingMappingException(String valueRepresentation) {

            super("The following value had no mapping: " + valueRepresentation);
        }

    }


    /**
     * This exception is raised if a {@link ProbabilityFunction} is not bijective.
     *
     * @since 0.0.6
     */
    abstract class MaldefinedProbabilityFunctionException extends RuntimeException {

        /**
         * Default constructor
         *
         * @param s a String, passed to the super-constructor
         *
         * @see RuntimeException#RuntimeException(String)
         * @since 0.0.6
         */
        public MaldefinedProbabilityFunctionException(String s) {

            super(s);
        }

    }

    /**
     * This exception is raised if a {@link ProbabilityFunction} encounters two or more eligible mappings for a single value
     *
     * @since 0.0.6
     */
    class MultiMappingException extends MaldefinedProbabilityFunctionException {

        /**
         * Default constructor
         *
         * @param valueRepresentation the String-representation for the value which has multiple mappings in the
         *                            {@link ProbabilityFunction}
         * @param mappings            a collection of String-representations of all mappings which include the value
         *
         * @since 0.0.6
         */
        public MultiMappingException(String valueRepresentation, @Nonnull Collection< String > mappings) {

            super(String.format(
                    "The value %s has multiple mappings: \n\n %s . \n" +
                            "Chance functions, however, must be bijective.",
                    valueRepresentation,
                    String.join(", \n", mappings))
            );
        }

    }

}
