/**
 * 
 */
package com.problem.taxes.model;

/**
 * @author Gustavo Pagotto
 *
 */
public interface IInvoiceItem {

	public IProduct getProduct();

	public void setProduct(IProduct product);

	public void setQty(Long qty);

	public Long getQty();

}
