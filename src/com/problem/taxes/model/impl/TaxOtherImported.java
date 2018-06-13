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
 * 
 * @author Gustavo Pagotto
 *
 */
public class TaxOtherImported implements ITax, Serializable {

	private static final long serialVersionUID = -7722720196643649476L;

	private final BigDecimal PERCENT_VALUE = new BigDecimal("15");

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
		if (!(obj instanceof TaxOtherImported))
			return false;
		TaxOtherImported other = (TaxOtherImported) obj;
		if (PERCENT_VALUE == null) {
			if (other.PERCENT_VALUE != null)
				return false;
		} else if (!PERCENT_VALUE.equals(other.PERCENT_VALUE))
			return false;
		return true;
	}

}
