package com.problem.taxes.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.problem.taxes.loader.InvoiceLoader;
import com.problem.taxes.model.IInvoiceItem;
import com.problem.taxes.model.ProductType;
import com.problem.taxes.model.impl.Invoice;
import com.problem.taxes.model.impl.InvoiceItem;
import com.problem.taxes.model.impl.Product;

public class InvoiceTests {
	
	
	private Invoice invoice01 = null;
	private InvoiceLoader loader01 = null;
	
	@Before
	public void initialize() {
		
		loader01 = new InvoiceLoader();
		invoice01 = loader01.buildInvoice2();
		
	}
	
	/**
	 * Testing the ability to increase qty value when adding a product that already exists inside the list, avoiding item duplication
	 */
	@Test
	public final void testAddItem() {
		
		InvoiceItem itemAux = new InvoiceItem(new Product("imported box of chocolates", ProductType.FOOD_PRODUCTS, Boolean.TRUE, new BigDecimal("10.00")), 1L);
		
		invoice01.addItem(itemAux);
		long qtyFound = 0L; 
		
		for (IInvoiceItem listItem : invoice01.getItems()) {
			if (listItem.getProduct().getName().equals(itemAux.getProduct().getName())) {
				qtyFound = listItem.getQty().longValue();
			}
		}
		
		assertTrue(qtyFound == 2L);
		
	}

	@Test
	public final void testGetItems() {
		
		Invoice invoiceAux = loader01.buildInvoice2();
		assertEquals(invoiceAux.getItems(), invoice01.getItems());
		
	}

}
