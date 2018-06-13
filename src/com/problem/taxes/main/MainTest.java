package com.problem.taxes.main;

import java.util.Iterator;

import com.problem.taxes.model.IInvoiceItem;
import com.problem.taxes.model.impl.Invoice;
import com.problem.taxes.model.impl.InvoiceItem;
import com.problem.taxes.test.TestTaxes;

public class MainTest {

	public static void printOutput(String header, Invoice inv) {

		System.out.println(header);

		for (Iterator<IInvoiceItem> iterator = inv.getItems().iterator(); iterator.hasNext();) {
			InvoiceItem item = (InvoiceItem) iterator.next();

			System.out.println(item.getQty().toString() + " " + item.getProduct().getName() + ": "
					+ item.getProduct().getTaxedUnitValue().toString());

		}

		System.out.println("Sales Taxes: " + inv.getTotalTax().toString());
		System.out.println("Total: " + inv.getTotalValue().toString());
		System.out.println("");

	}

	public static void main(String[] args) {

		TestTaxes test = new TestTaxes();

		Invoice inv01 = test.buildInvoice1();
		Invoice inv02 = test.buildInvoice2();
		Invoice inv03 = test.buildInvoice3();

		printOutput("Output 1:", inv01);
		printOutput("Output 2:", inv02);
		printOutput("Output 3:", inv03);

	}

}
