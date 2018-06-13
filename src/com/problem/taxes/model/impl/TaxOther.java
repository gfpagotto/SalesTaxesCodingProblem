/**
 * 
 */
package com.problem.taxes.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import com.problem.taxes.model.ITax;
import com.problem.taxes.util.Util;

/**
 * Calculate tax for common products, applying 10% over the value.
 * 
 * @author Gustavo Pagotto
 *
 */
public class TaxOther implements ITax, Serializable {

	private static final long serialVersionUID = 3813194941310475125L;
	
	private final BigDecimal PERCENT_VALUE = new BigDecimal("10");

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
		return Util.roundValue(value.multiply(PERCENT_VALUE).divide(new BigDecimal("100")));
	}

}
