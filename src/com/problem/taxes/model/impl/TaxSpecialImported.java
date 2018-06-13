/**
 * 
 */
package com.problem.taxes.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import com.problem.taxes.model.ITax;
import com.problem.taxes.util.Util;

/**
 * Calculate tax for common products, applying 15% over the value.
 * The special products types are defined at ISalesTaxesDef.SPECIAL_TYPES
 * 
 * @author Gustavo Pagotto
 *
 */
public class TaxSpecialImported implements ITax, Serializable {

	private static final long serialVersionUID = -6574650866139403252L;

	private final BigDecimal PERCENT_VALUE = new BigDecimal("5");

	/**
	 * @return the product price, applying taxes
	 */
	@Override
	public BigDecimal evaluateTax(BigDecimal value) {
		return Util.roundValue(value.add(this.taxValue(value)));
	}

	/**
	 * Calculates the taxValue, based on the product price
	 * 
	 * @return tax value
	 */
	@Override
	public BigDecimal taxValue(BigDecimal value) {
		return Util.roundValue(value.multiply(PERCENT_VALUE).divide(new BigDecimal(100)));
	}

}
