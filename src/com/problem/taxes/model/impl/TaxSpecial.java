/**
 * 
 */
package com.problem.taxes.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import com.problem.taxes.model.ITax;
import com.problem.taxes.util.Util;

/**
 * Calculate tax for special products, and in this case, applying no percentage over the value.
 * The special products types are defined at ISalesTaxesDef.SPECIAL_TYPES
 * 
 * @author Gustavo Pagotto
 *
 */
public class TaxSpecial implements ITax, Serializable {

	private static final long serialVersionUID = 2091756113809143891L;

	/**
	 * @return the product price, applying taxes
	 */
	@Override
	public BigDecimal evaluateTax(BigDecimal value) {
		return Util.roundValue(value);
	}

	/**
	 * Calculates the taxValue, based on the product price
	 * 
	 * @return tax value
	 */
	@Override
	public BigDecimal taxValue(BigDecimal value) {
		return new BigDecimal("0.00");
		
	}

}
