package com.problem.taxes.main;


import com.problem.taxes.model.impl.Invoice;
import com.problem.taxes.test.TestTaxes;

public class MainTest {

	
	public static void main(String[] args) {

		TestTaxes test = new TestTaxes();

		Invoice inv01 = test.buildInvoice1();
		Invoice inv02 = test.buildInvoice2();
		Invoice inv03 = test.buildInvoice3();

		System.out.println(inv01.toString());
		System.out.println(inv02.toString());
		System.out.println(inv03.toString());

	}

}
