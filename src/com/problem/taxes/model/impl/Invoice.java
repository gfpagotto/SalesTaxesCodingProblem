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

	@Override
	public String toString() {
		
		String strAux = this.name + ":\n";
		
		for (IInvoiceItem invoiceItem : items) {
			strAux += invoiceItem.toString() + "\n";
		}
		
		strAux += "Sales Taxes: " + this.getTotalTax().setScale(2).toString() + " \n";
		strAux += "Sales Taxes: " + this.getTotalValue().setScale(2).toString() + " \n";
		
		return strAux;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((totalTax == null) ? 0 : totalTax.hashCode());
		result = prime * result + ((totalValue == null) ? 0 : totalValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Invoice))
			return false;
		Invoice other = (Invoice) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (totalTax == null) {
			if (other.totalTax != null)
				return false;
		} else if (!totalTax.equals(other.totalTax))
			return false;
		if (totalValue == null) {
			if (other.totalValue != null)
				return false;
		} else if (!totalValue.equals(other.totalValue))
			return false;
		return true;
	}
	

}
