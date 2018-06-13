# SalesTaxesCodingProblem

Gustavo Furlan Pagotto

Coding Problem: Sales Taxes, Java

README

HOW TO RUN:

1. Eclipse
	- Unzip the files and import it into Eclipse using "File\Import..." option. 
	- Open the Main.java file, located at the package "com.problem.taxes.main" and over 
    the file name (in Project Explorer) right click "Run As..." => "Java Application". 
	- The main() method will print the output results at console. 
	
2. Terminal
	- Unzip the files in terminal	and enter the src directory for running the application, as below:
		~$ cd SalesTaxesCodingProblem-master
		~$ cd src
		~$ java com/problem/taxes/main/Main


ADDITIONAL INFORMATION

1. Used BigDecimal for values in order to have better accuracy for currencies manipulation;
2. Implemented the taxes calculation using Strategy Design Patern in order to have mobility of taxes implementation, 
   leaving space for more customization if needeed (beyond the problem statement);
3. Used JUnit for testing;
4. Worked with a Master/Detail for order information.
5. Unfortunately I still had discrepancies with the output. Tried to round the totals and product cost 
   as close as possible as the problem statement.

Thank You!
