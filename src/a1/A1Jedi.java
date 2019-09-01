package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//reading in the number of items in the store
		int iStore=scan.nextInt();
		
		//declaring a 2d array to keep track of the items of the store & when they're bought & by how many customers
		String[][] storeItems = new String[iStore][3];
		 
		//getting the names and prices of each item in the store
		for(int i=0; i<iStore; i++) {
					
				String iName=scan.next();
					
				//we don't care about this, just scanning because the user will input it
				String iPrice=scan.next();
					
				storeItems[i][0]=iName;
				//starting at 0 because we haven't asked about that yet
				storeItems[i][1]="0";
				storeItems[i][2]="0";
				}
			
		//reading in the number of customers
		int numCust=scan.nextInt();
		//String[][] customerCount=new String[numCust][3];
		
		boolean cCounted;
		for (int k=0; k<numCust; k++) {
			// we don't really care about the names just have to read them in 
			//reading in the first name of the customer
			
			String fName=scan.next();
			
			//reading in last name of the customer
			String lName=scan.next();
			
			
			//reading in the number of items that the customer bought
			int numItems=scan.nextInt();
			
			String[][] custCount=new String[numItems][2];
			for(int l=0;l<custCount.length;l++) {
				custCount[l][1]="f";
			}
			
			//for loop to iterate through next input statements based on how many items the customer bought
			for (int j=0; j<numItems; j++) {
				//reading in the quantity of this item
				int qItem=scan.nextInt();
				//reading in the name of the item
				String iName=scan.next();
				custCount[j][0]=iName;
				//finding the cost of the listed item
				int cCount=0;
				int itemIndex=0;
				for(int p=0; p< storeItems.length; p++) {
					int qCount;
					if(storeItems[p][0].contentEquals(iName)) {
						itemIndex=p;
						qCount=Integer.parseInt(storeItems[p][1]);
						qCount+=qItem;
						storeItems[p][1]=""+qCount;
						//need to only do this  once per customer 
						//finding the index of the name of the item in custCount
						cCount=Integer.parseInt(storeItems[p][2]);
					}
				}
				
				if(custCount[j][1].equals("f")) {
					cCount++;
					custCount[j][1]="t";
					storeItems[itemIndex][2]=""+cCount;
				}
					
			}
		
		}
		for(int d=0; d<storeItems.length; d++) {
			if(Integer.parseInt(storeItems[d][2])==0) {
				System.out.println("No customers bought "+storeItems[d][0]);
			}
			else {
				System.out.println(storeItems[d][2]+" customers bought "+ storeItems[d][1]+ " "+ storeItems[d][0]);
			}
		}
		System.out.println("");
		
	}
}
