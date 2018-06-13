package com.problem.taxes.test;


import com.problem.taxes.loader.InvoiceLoader;
import com.problem.taxes.model.impl.Invoice;

public class MainTest {

	
	public static void main(String[] args) {

		InvoiceLoader test = new InvoiceLoader();

		Invoice inv01 = test.buildInvoice1();
		Invoice inv02 = test.buildInvoice2();
		Invoice inv03 = test.buildInvoice3();

		System.out.println(inv01.toString());
		System.out.println(inv02.toString());
		System.out.println(inv03.toString());

	}

}
