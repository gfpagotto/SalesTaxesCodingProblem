package com.problem.taxes.model;

import java.math.BigDecimal;

public interface ITax {

	public BigDecimal evaluateTax(BigDecimal value);

	public BigDecimal taxValue(BigDecimal value);
	
	public int hashCode();
	
	public boolean equals(Object obj);

}
