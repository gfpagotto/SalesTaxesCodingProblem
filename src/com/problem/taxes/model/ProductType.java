/**
 * 
 */
package com.problem.taxes.model;

import java.util.Arrays;

import com.problem.taxes.setup.Settings;

/**
 * @author Gustavo Pagotto
 *
 */
public abstract class ProductType {
	
	public static final String OTHER_PRODUCTS = "other";
	public static final String BOOK_PRODUCTS = "book";
	public static final String FOOD_PRODUCTS = "food";
	public static final String MEDICAL_PRODUCTS = "medical";
	
	public static Boolean isSpecialType(String type) {
		return Arrays.asList(Settings.SPECIAL_TYPES).contains(type);
	}

}
