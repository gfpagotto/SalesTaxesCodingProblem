package com.problem.taxes.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.problem.taxes.model.ProductType;
import com.problem.taxes.model.impl.InvoiceItem;
import com.problem.taxes.model.impl.Product;

public class InvoiceItemTests {

	private Product product01 = null;
	private Product product02 = null;
	private InvoiceItem invoiceItem01 = null;
	private InvoiceItem invoiceItem02 = null;
	
	@Before
	public void initialize() {
		
		product01 = new Product("Product01", ProductType.BOOK_PRODUCTS, Boolean.FALSE, new BigDecimal("100.00"));
		product02 = new Product("Product02", ProductType.BOOK_PRODUCTS, Boolean.FALSE, new BigDecimal("200.00"));
		
		invoiceItem01 = new InvoiceItem(product01);
		invoiceItem02 = new InvoiceItem(product02, new Long(2));
		
	}

	@Test
	public final void testInvoiceItemProduct() {
		
		assertFalse(invoiceItem01.getProduct().equals(invoiceItem02.getProduct()));		
		
	}

	@Test
	public final void testGetProduct() {
		Product prodExpected = new Product("Product01", ProductType.BOOK_PRODUCTS, Boolean.FALSE, new BigDecimal("100.00"));
		assertEquals(prodExpected, invoiceItem01.getProduct());
	}

}
