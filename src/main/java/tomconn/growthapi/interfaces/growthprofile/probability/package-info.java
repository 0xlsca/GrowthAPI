/**
 * This package contains all relevant interfaces which are tied to providing methods which help with easing the
 * creation of chance-functions for growth-profiles.
 * <br/>
 * <p>
 * The following kinds of functions are available: <br/>
 *
 * <ul>
 * <li>
 * Stage-based functions:
 *
 * <br>
 * Stage-based functions yield, as the name suggests, values which are depending on the interval in which
 * the input-value is located.<br/><br/>
 * <u>Example:</u>
 * <br/>
 * <br/>
 * <code>
 * if( x >= 15) return 1.0;<br/>
 * if( x < 15 && x >= 10) return 0.5; <br/>
 * else return 0.1;<br/>
 * </code>
 *
 * </br>
 *
 * </li>
 * <li>
 * Linear functions:
 *
 * <br>
 * Linear functions are mathematical functions of the form <code>f(x) = m * x + b</code>.<br/><br/>
 * <u>Example: (light-level)</u>
 * <br/>
 * <br/>
 * <code>
 * return 1.0 * ( 15 - x );
 * </code>
 *
 * </br>
 * </li>
 * <li>
 * Tuple-based functions:
 *
 * <br>
 * A function in mathematics is basically a set of tuples. <br/>
 * A tuple-based functions therefore is a function which maps elements of one set onto another set.<br/>
 * <br/>
 * Therefore, tuple-based functions are of the form <br/>
 * <br/>
 * {@code
 * Function<E, Double> somethingTupleChance(List<Tuple<SomeType, Double>> tuples);
 * }
 * </br>
 * </li>
 * </ul>
 *
 * @since 0.0.6
 */
package tomconn.growthapi.interfaces.growthprofile.probability;