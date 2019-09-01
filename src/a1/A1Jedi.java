package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//reading in the number of items in the store
		int iStore=scan.nextInt();
		
		//declaring a 2d array to keep track of the items of the store & when they're bought & by how many customers
		String[][] storeItems = new String[iStore][3];
		 
		//getting the names and prices of each item in the store based on num of items
		for(int i=0; i<iStore; i++) {
					
			    //getting item name
				String iName=scan.next();
					
				//we don't care about this, just scanning because the user will input it
				String iPrice=scan.next();
				//storing name in 0th index	
				storeItems[i][0]=iName;
				//starting at 0 because we haven't asked about that yet
				storeItems[i][1]="0";
				storeItems[i][2]="0";
				}
			
		//reading in the number of customers
		int numCust=scan.nextInt();
		
		//iterating thru and getting info based on the number of customers
		for (int k=0; k<numCust; k++) {
			// we don't really care about the names just have to read them in 
			//reading in the first name of the customer
			String fName=scan.next();
			
			//reading in last name of the customer
			String lName=scan.next();
			
			//reading in the number of items that the customer bought
			int numItems=scan.nextInt();
			
			/*array to keep track of the items the customer
			purchased and if they've been included in the customer count or not*/
			String[][] custCount=new String[numItems][2];
			
			for(int l=0;l<custCount.length;l++) {
				//putting in default values
				custCount[l][0]="";
				custCount[l][1]="f";
			}
			//variable to track item index in custCount
			int ii=0;
			//for loop to iterate through next input statements based on how many items the customer bought
			for (int j=0; j<numItems; j++) {
				
				//reading in the quantity of this item
				int qItem=scan.nextInt();
				//reading in the name of the item
				String iName=scan.next();
				//variable to see if this item is already found in custCount
				boolean found=false;
				//for loop to find the item in custCount, updating found and ii accordingly
				for(int b=0; b<custCount.length;b++) {
					if(custCount[b][0].equals(iName)) {
						found=true;
						ii=b;
						continue;
					}
				}
				//if it hasn't been found, put in array and use current index
				if(!found) {
					custCount[j][0]=iName;
					ii=j;
				}
				
				//finding the cost of the listed item
				//number of customers that have purchased that item
				int cCount=0;
				//var for index of item in storeItems
				int itemIndex=0;
				//going thru storeItems to find index for current item
				for(int p=0; p< storeItems.length; p++) {
					//keeping track of total quantity of item
					int qCount;
					if(storeItems[p][0].contentEquals(iName)) {
						//this means item has been found, get index
						itemIndex=p;
						//parsing to do math with it
						qCount=Integer.parseInt(storeItems[p][1]);
						qCount+=qItem;
						//putting updated value back into the array
						storeItems[p][1]=""+qCount;
						//finding the current customer count
						cCount=Integer.parseInt(storeItems[p][2]);
					}
				}
				//seeing if the customer has already been counted for this item
				if(custCount[ii][1].equals("f")) {
					//increment cCount and show that it has been counted
					cCount++;
					custCount[ii][1]="t";
					//putting back into the array
					storeItems[itemIndex][2]=""+cCount;
				}	
			}
		
		}
		//iterating thru storeItems for final output
		for(int d=0; d<storeItems.length; d++) {
			//output if no one bought that item
			if(Integer.parseInt(storeItems[d][2])==0) {
				System.out.println("No customers bought "+storeItems[d][0]);
			}
			//saying how many people bought how many of each item
			else {
				System.out.println(storeItems[d][2]+" customers bought "+ storeItems[d][1]+ " "+ storeItems[d][0]);
			}
		}
		System.out.println("");
		
	}
}
