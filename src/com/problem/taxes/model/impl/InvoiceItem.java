/**
 * 
 */
package com.problem.taxes.model.impl;

import java.io.Serializable;

import com.problem.taxes.model.IInvoiceItem;
import com.problem.taxes.model.IProduct;

/**
 * @author Gustavo Pagotto
 *
 */
public class InvoiceItem implements IInvoiceItem, Serializable {

	private static final long serialVersionUID = -6427368010025019263L;

	private IProduct product;
	private Long qty;

	/**
	 * Creates an Invoice Item with quantity of 01.
	 * 
	 * @param product
	 */
	public InvoiceItem(IProduct product) {
		super();
		this.product = product;
		this.qty = new Long(1L);
	}

	/**
	 * Creates an Invoice Item
	 * 
	 * @param product
	 * @param qty
	 */
	public InvoiceItem(IProduct product, Long qty) {
		super();
		this.product = product;
		this.qty = qty;
	}

	@Override
	public IProduct getProduct() {
		return this.product;
	}

	@Override
	public void setProduct(IProduct product) {
		this.product = product;
	}

	@Override
	public void setQty(Long qty) {
		this.qty = qty;
	}

	@Override
	public Long getQty() {
		return this.qty;
	}

}
