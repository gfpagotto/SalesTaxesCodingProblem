package com.problem.taxes.util;

import java.math.BigDecimal;

import com.problem.taxes.model.ProductType;

public interface ISalesTaxesDef {

	public static final Boolean IMPORTED_PRODUCT = new Boolean(true);
	public static final BigDecimal ROUNDING_RULE = new BigDecimal("0.05");
	public static final String[] SPECIAL_TYPES = {ProductType.BOOK_PRODUCTS, ProductType.FOOD_PRODUCTS, ProductType.MEDICAL_PRODUCTS};
	

}
