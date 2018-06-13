/**
 * 
 */
package com.problem.taxes.model.impl;

import java.io.Serializable;

import com.problem.taxes.model.IInvoiceItem;
import com.problem.taxes.model.IProduct;

/**
 * The items of an Invoice. Will handle products and its quantities.
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

	@Override
	public String toString() {
		return this.getQty().toString() + " " + this.getProduct().getName() + ": " + this.getProduct().getTaxedUnitValue().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof InvoiceItem))
			return false;
		InvoiceItem other = (InvoiceItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		return true;
	}

}
