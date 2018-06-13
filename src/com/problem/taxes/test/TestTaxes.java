package com.problem.taxes.test;

import java.io.Serializable;
import java.math.BigDecimal;

import com.problem.taxes.model.ProductType;
import com.problem.taxes.model.impl.Invoice;
import com.problem.taxes.model.impl.InvoiceItem;
import com.problem.taxes.model.impl.Product;

public class TestTaxes implements Serializable {

	private static final long serialVersionUID = -7686457418131198379L;
	
	/**
	 * <pre>
	 * Build an invoice based on these itens: 
	 * - 1 book at 12.49
	 * - 1 music CD at 14.99
	 * - 1 chocolate bar at 0.85
	 * </pre>
	 * @return Invoice
	 */
	public Invoice buildInvoice1() {
		
		Invoice invoice = new Invoice("Output01");
		
		invoice.addItem(new InvoiceItem(new Product("book", ProductType.BOOK_PRODUCTS, Boolean.FALSE, new BigDecimal("12.49")), 1L));
		invoice.addItem(new InvoiceItem(new Product("music CD", ProductType.OTHER_PRODUCTS, Boolean.FALSE, new BigDecimal("14.99")), 1L));
		invoice.addItem(new InvoiceItem(new Product("chocolate bar", ProductType.FOOD_PRODUCTS, Boolean.FALSE, new BigDecimal("0.85")), 1L));
		
		return invoice;
		
	}
	
	/**
	 * <pre>
	 * Build an invoice based on these itens:
	 * - 1 imported box of chocolates at 10.00
	 * - 1 imported bottle of perfume at 47.50
	 * </pre>
	 * @return Invoice
	 */
	public Invoice buildInvoice2() {
		
		Invoice invoice = new Invoice("Output02");
		
		invoice.addItem(new InvoiceItem(new Product("imported box of chocolates", ProductType.FOOD_PRODUCTS, Boolean.TRUE, new BigDecimal("10.00")), 1L));
		invoice.addItem(new InvoiceItem(new Product("imported bottle of perfume", ProductType.OTHER_PRODUCTS, Boolean.TRUE, new BigDecimal("47.50")), 1L));
		
		return invoice;
		
	}

	/**
	 * <pre>
	 * Build an invoice based on these itens:
	 * - 1 imported bottle of perfume at 27.99
	 * - 1 bottle of perfume at 18.99
	 * - 1 packet of headache pills at 9.75
	 * - 1 imported box of chocolates at 11.25
	 * </pre>
	 * @return Invoice
	 */	
	public Invoice buildInvoice3() {
		
		Invoice invoice = new Invoice("Output03");
		
		invoice.addItem(new InvoiceItem(new Product("imported bottle of perfume", ProductType.OTHER_PRODUCTS, Boolean.TRUE, new BigDecimal("27.99")), 1L));
		invoice.addItem(new InvoiceItem(new Product("bottle of perfume", ProductType.OTHER_PRODUCTS, Boolean.FALSE, new BigDecimal("18.99")), 1L));
		invoice.addItem(new InvoiceItem(new Product("packet of headache pills", ProductType.MEDICAL_PRODUCTS, Boolean.FALSE, new BigDecimal("9.75")), 1L));
		invoice.addItem(new InvoiceItem(new Product("imported box of chocolates", ProductType.FOOD_PRODUCTS, Boolean.TRUE, new BigDecimal("11.25")), 1L));
		
		return invoice;
		
	}
	
	

}
