/**
 * 
 */
package com.problem.taxes.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import com.problem.taxes.model.IProduct;
import com.problem.taxes.model.ITax;
import com.problem.taxes.model.ProductType;

/**
 * Main Product Class
 * 
 * @author Gustavo Pagotto
 *
 */
public class Product implements IProduct, Serializable {

	private static final long serialVersionUID = -384133437937973616L;

	private String name;
	private String type;
	private Boolean isImported;
	private BigDecimal unitValue;
	private ITax tax;

	/**
	 * @param name
	 *            - Name of the product
	 * @param type
	 *            - Type of the product
	 * @param isImported
	 *            - if is imported
	 * @param unitValue
	 *            - unit value
	 */
	public Product(String name, String type, Boolean isImported, BigDecimal unitValue) {
		super();
		this.name = name;
		this.type = type;
		this.isImported = isImported;
		this.unitValue = unitValue;

		// Assign taxes for special products
		if (ProductType.isSpecialType(type).equals(Boolean.TRUE)) {
			if (isImported.equals(Boolean.TRUE)) {
				this.tax = new TaxSpecialImported();
			} else {
				this.tax = new TaxSpecial();
			}
			// Assign tax calculation method for other products
		} else {
			if (isImported.equals(Boolean.TRUE)) {
				this.tax = new TaxOtherImported();
			} else {
				this.tax = new TaxOther();
			}
		}
	}

	/**
	 * @param isImported
	 *            - determine if a product is imported
	 */
	public void setIsImported(Boolean isImported) {
		this.isImported = isImported;
	}

	/**
	 * @param name
	 *            - The name of Product
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param type
	 *            - product type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param unitValue
	 *            the unitValue to set
	 */
	public void setUnitValue(BigDecimal unitValue) {
		this.unitValue = unitValue;
	}

	/**
	 * @param tax
	 *            the tax to set
	 */
	public void setTax(ITax tax) {
		this.tax = tax;
	}

	/**
	 * @return Name of product
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * @return Type of product
	 */
	@Override
	public String getType() {
		return this.type;
	}

	/**
	 * @return If the product is Imported
	 */
	@Override
	public Boolean isImported() {
		return this.isImported;
	}

	/**
	 * @return The unit value of the product, without taxes
	 */
	@Override
	public BigDecimal getUnitValue() {
		return this.unitValue;
	}

	/**
	 * @return The Tax used for this product
	 */
	@Override
	public ITax getTax() {
		return (ITax) this.tax;
	}

	/**
	 * @return The unit value of the product, with the taxes applied
	 */
	@Override
	public BigDecimal getTaxedUnitValue() {
		return this.tax.evaluateTax(this.unitValue);
	}

	/**
	 * @return The tax value, according to the product price
	 */
	@Override
	public BigDecimal getTaxValue() {
		return this.tax.taxValue(this.unitValue);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isImported == null) ? 0 : isImported.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((unitValue == null) ? 0 : unitValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (isImported == null) {
			if (other.isImported != null)
				return false;
		} else if (!isImported.equals(other.isImported))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (unitValue == null) {
			if (other.unitValue != null)
				return false;
		} else if (!unitValue.equals(other.unitValue))
			return false;
		return true;
	}

	@Override
	public Product clone() {
		
		Product productAux = new Product(this.getName(), this.getType(), this.isImported(), this.getUnitValue());
		return productAux;
				
	}
	
}
