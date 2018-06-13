package com.problem.taxes.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.problem.taxes.model.ProductType;
import com.problem.taxes.model.impl.Product;

public class ProductTests {
	
	private Product product01 = null;
	private Product product02 = null;
	
	@Before
	public void initialize() {
		
		product01 = new Product("Product01", ProductType.BOOK_PRODUCTS, Boolean.FALSE, new BigDecimal("100.00"));
		product02 = new Product("Product02", ProductType.BOOK_PRODUCTS, Boolean.FALSE, new BigDecimal("200.00"));
		
	}

	@Test
	public final void testGetName() {
		
		String expected = "ProductXPTO";
		assertFalse(expected.equals(product01.getName()));
		
	}

	@Test
	public final void testGetType() {
		assertEquals(ProductType.BOOK_PRODUCTS, product01.getType());
	}

	@Test
	public final void testGetUnitValue() {
		
		BigDecimal expectedValue = new BigDecimal("100.00");
		assertTrue(product01.getTaxedUnitValue().equals(expectedValue));
		
	}

	@Test
	public final void testClone() {
		
		Product productClone = product01.clone();
		assertTrue(product01.equals(productClone));
		
	}

}
