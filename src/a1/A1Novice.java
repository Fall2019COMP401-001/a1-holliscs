package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Reading input for the total number of customers
		int numCust=scan.nextInt();
		
		//for loop to iterate through the next inputs based on the number of customers
		for (int i =0; i<numCust; i++) {
			//reading in the first name of the customer
			String fName=scan.next();
			
			//reading in last name of the customer
			String lName=scan.next();
			
			//creating a variable for the customer's first initial
			String fInit=fName.substring(0, 1);
			
			//reading in the number of items that the customer bought
			int numItems=scan.nextInt();
			
			//declaring a variable to keep track of the customer's total cost
			double cTotal=0;
			
			//for loop to iterate through next input statements based on how many items the customer bought
			for (int k=0; k<numItems; k++) {
				//reading in how many of this item the customer bought
				int qItem=scan.nextInt();
				//reading in the name of the item, don't really need value for later tho
				String iName=scan.next();
				//reading in item price
				double iPrice=scan.nextDouble();
				
				//computing the total cost for this item by multiplying price by quantitiy
				cTotal+=(iPrice*qItem);
				
			}
			//output statements
			System.out.print(fInit+". "+ lName+": "); 
			//using the printf to format the output to 2 decimal places
			System.out.printf("%.2f \n", cTotal);
			
		}
		
		
	}
}
