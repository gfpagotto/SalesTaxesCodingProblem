package com.problem.taxes.main;


import com.problem.taxes.loader.InvoiceLoader;
import com.problem.taxes.model.impl.Invoice;

public class Main {

	
	public static void main(String[] args) {

		InvoiceLoader invoiceLoader = new InvoiceLoader();

		Invoice inv01 = invoiceLoader.buildInvoice1();
		Invoice inv02 = invoiceLoader.buildInvoice2();
		Invoice inv03 = invoiceLoader.buildInvoice3();

		System.out.println(inv01.toString());
		System.out.println(inv02.toString());
		System.out.println(inv03.toString());

	}

}
