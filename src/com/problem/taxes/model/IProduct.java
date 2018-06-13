package com.problem.taxes.model;

import java.math.BigDecimal;

public interface IProduct {

	public String getName();

	public String getType();

	public Boolean isImported();

	public BigDecimal getUnitValue();
	
	public ITax getTax();
	
	public BigDecimal getTaxedUnitValue();
	
	public BigDecimal getTaxValue();

}
