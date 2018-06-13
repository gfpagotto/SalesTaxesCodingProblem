/**
 * 
 */
package com.problem.taxes.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import com.problem.taxes.model.ITax;
import com.problem.taxes.util.Util;

/**
 * Calculate tax for common goods, applying 15% over the value.
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PERCENT_VALUE == null) ? 0 : PERCENT_VALUE.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TaxSpecialImported))
			return false;
		TaxSpecialImported other = (TaxSpecialImported) obj;
		if (PERCENT_VALUE == null) {
			if (other.PERCENT_VALUE != null)
				return false;
		} else if (!PERCENT_VALUE.equals(other.PERCENT_VALUE))
			return false;
		return true;
	}
	
}
