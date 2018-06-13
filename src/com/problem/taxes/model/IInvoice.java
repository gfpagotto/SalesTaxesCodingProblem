/**
 * 
 */
package com.problem.taxes.model;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Gustavo Pagotto
 *
 */
public interface IInvoice {
	
	public void setName(String name);

	public String getName();

	public void addItem(IInvoiceItem item);

	public void removeItem(IInvoiceItem item);

	public ArrayList<IInvoiceItem> getItems();

	public BigDecimal getTotalTax();

	public BigDecimal getTotalValue();
	
	public int hashCode();
	
	public boolean equals(Object obj);

}
