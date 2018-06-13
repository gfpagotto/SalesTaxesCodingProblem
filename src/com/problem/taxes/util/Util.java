/**
 * 
 */
package com.problem.taxes.util;

import java.math.BigDecimal;

/**
 * Utility Class
 * 
 * @author Gustavo Pagotto
 *
 */
public class Util {

	/**
	 * Round the value based on the rule ROUNDING_RULE, defined in
	 * ISalesTaxesDef interface
	 * 
	 * @param value
	 *            - The value you want to round
	 * @return rounded value, according to the rule
	 */
	public static BigDecimal roundValue(BigDecimal value) {

		BigDecimal valueAux = new BigDecimal(Math.ceil((value.divide(ISalesTaxesDef.ROUNDING_RULE).doubleValue())));
		return valueAux.multiply(ISalesTaxesDef.ROUNDING_RULE);
		
	}

}
