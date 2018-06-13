/**
 * 
 */
package com.problem.taxes.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import com.problem.taxes.model.IInvoice;
import com.problem.taxes.model.IInvoiceItem;
import com.problem.taxes.util.Util;

/**
 * @author Gustavo Pagotto
 *
 */
public class Invoice implements IInvoice, Serializable {

	private static final long serialVersionUID = -8632789776895392126L;

	private String name;
	private ArrayList<IInvoiceItem> items;
	private BigDecimal totalTax;
	private BigDecimal totalValue;

	/**
	 * @param name
	 */
	public Invoice(String name) {
		super();
		this.name = name;
		this.items = new ArrayList<IInvoiceItem>();
		this.totalTax = new BigDecimal("0.00");
		this.totalValue = new BigDecimal("0.00");
	}

	/**
	 * @param name
	 * @param items
	 */
	public Invoice(String name, ArrayList<IInvoiceItem> items) {
		super();
		this.name = name;
		this.items = items;
	}

	@Override
	public void addItem(IInvoiceItem item) {

		if (this.items == null) {
			this.items = new ArrayList<IInvoiceItem>();
		}

		// If it's a new array, add the item without verification
		if (this.items.isEmpty()) {

			this.items.add(item);

		} else {

			// If the item is already in list, increase qty
			boolean found = false;

			for (IInvoiceItem listItem : items) {
				if (listItem.getProduct().getName().equals(item.getProduct().getName())) {
					listItem.setQty(new Long(listItem.getQty().longValue() + item.getQty().longValue()));
					found = true;
				}
			}

			// If it's a new item, add it to the list:
			if (!found) {
				this.items.add(item);
			}
		} // if (this.items.isEmpty())
	}

	@Override
	public void removeItem(IInvoiceItem item) {

		if (this.items == null) {
			this.items = new ArrayList<IInvoiceItem>();
		}

		if (!this.items.isEmpty()) {

			for (IInvoiceItem listItem : items) {

				if (listItem.getProduct().getName().equals(item.getProduct().getName())) {
					this.items.remove(listItem);
				}
			}
		}
	}

	@Override
	public ArrayList<IInvoiceItem> getItems() {

		if (this.items == null) {
			this.items = new ArrayList<IInvoiceItem>();
		}

		return this.items;
	}

	@Override
	public BigDecimal getTotalTax() {

		//this.totalTax = new BigDecimal("0.00");
		//BigDecimal taxAux = new BigDecimal("0.00");
		BigDecimal taxAux = new BigDecimal(this.totalTax.doubleValue());

		if (this.items == null) {
			this.items = new ArrayList<IInvoiceItem>();
		}

		if (!items.isEmpty()) {
			for (IInvoiceItem item : items) {

				this.totalTax = taxAux.add(item.getProduct().getTaxValue())
						.multiply(new BigDecimal(item.getQty().longValue()));
				
				taxAux = new BigDecimal(this.totalTax.doubleValue());

			}
		}

		return Util.roundValue(this.totalTax);
	}

	@Override
	public BigDecimal getTotalValue() {

		//this.totalValue = BigDecimal.ZERO;
		BigDecimal totalAux = new BigDecimal(this.totalValue.doubleValue());

		if (this.items == null) {
			this.items = new ArrayList<IInvoiceItem>();
		}

		if (!items.isEmpty()) {
			for (IInvoiceItem item : items) {
				this.totalValue = totalAux.add(
						(item.getProduct().getTaxedUnitValue()).multiply(new BigDecimal(item.getQty().longValue())));
				totalAux = new BigDecimal(this.totalValue.doubleValue());
			}
		}

		return Util.roundValue(this.totalValue);
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		return this.name;
	}

}
