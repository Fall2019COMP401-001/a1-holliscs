package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		//reading in the number of items in the store
		int iStore=scan.nextInt();
		
		//declaring a 2d array to keep track of the items of the store & their prices
		
		String[][] storeItems = new String[iStore][2];
		
		//getting the names and prices of each item in the store
		for(int i=0; i<iStore; i++) {
			
			//getting the item's name
			String iName=scan.next();
			//inputting the price of the item
			String iPrice=scan.next();
			
			//storing this info into the 2d array for later
			storeItems[i][0]=iName;
			storeItems[i][1]=iPrice;
		}
		//reading in the number of customers
		int numCust=scan.nextInt();
		
		//declaring a 2d array to keep track of each customer and how much they spent
		String[][] amtSpent = new String[numCust][2];
		
		//name variable to combine first and last name for convenience
		String name;
		
		//iterating through every customerr to see what they bought
		for (int k=0; k<numCust; k++) {
			//reading in the first name of the customer
			String fName=scan.next();
			
			//reading in last name of the customer
			String lName=scan.next();
			
			//creating a single name variable for convenience
			name=fName+" "+lName;
			//storing customer name in the array so i can keep track
			amtSpent[k][0]=name;
			//reading in the number of items that the customer bought
			int numItems=scan.nextInt();
			
			//declaring a variable to keep track of the customer's total cost
			double cTotal=0;
			
			//for loop to iterate through next input statements based on how many items the customer bought
			for (int j=0; j<numItems; j++) {
				//reading in the quantity of this item
				int qItem=scan.nextInt();
				//reading in the name of the item
				String iName=scan.next();
				
				//declaring cost variable
				double cost=0;
				//finding the cost of the listed item by going thru storeItems and finding the name of the current item
				for(int p=0; p< storeItems.length; p++) {
					//finding index in storeItems
					if(storeItems[p][0].contentEquals(iName)) {
						//parsing the cost to an integer var so we can do math
						//storeItems[p][1] is the cost associated with the current item
						cost=Double.parseDouble(storeItems[p][1]);
					}	
				}
					
				//adding the cost of this item to the customer's total cost
				cTotal+=(qItem*cost);
			}
			//storing the customer's total cost into the amtSpent index
			//"" are there to convert it back to a string
			amtSpent[k][1]= ""+cTotal;
		}
		
		//calling function to see who spent the most
			String greatest=highestSpender(amtSpent);
			String gAmount="";
			//going through amtSpent to find index of greatest spender so the highest amount can be stored
			for(int c=0; c<amtSpent.length; c++) {
				if(amtSpent[c][0].equals(greatest)) {
					gAmount=amtSpent[c][1];
				}
			}
			
			//parsing gAmount to a double for formatting purposes
			double gDouble=Double.parseDouble(gAmount);
			

		//calling function to see who spent the least
			String lowest=lowestSpender(amtSpent);
			String lAmount="";
			//finding index of lowest spender so lowest amt can be stored
			for(int f=0; f<amtSpent.length; f++) {
				if(amtSpent[f][0].equals(lowest)) {
					lAmount=amtSpent[f][1];
				}
			}
			//parsing for formatting purposes
			double lDouble=Double.parseDouble(lAmount);
			
			
			//calling function to find the avg
		double avg=computeAvg(amtSpent);
		
		//outputting the info according to assignment format specifications
		System.out.print("Biggest: "+ greatest+ " (");
		System.out.printf("%.2f", gDouble);
		System.out.println(")");
		System.out.print("Smallest: "+ lowest+" (");
		System.out.printf("%.2f", lDouble);
		System.out.println(")");
		System.out.print("Average: ");
		System.out.printf("%.2f \n", avg);
	}
	
	//method to determine the highest spender
	public static String highestSpender(String[][] amt) {
		String hSpend=""; 
		double highest=0;
		//going thru amt array and seeing if that amount > highest, parsing so i can use mathematical operators
		for (int m=0; m< amt.length; m++) {
			if(Double.parseDouble(amt[m][1])>highest) {
				highest=Double.parseDouble(amt[m][1]);
				hSpend=amt[m][0];
			}
		}
		//returning the name of the highest spender
		return hSpend;
	}
	
	//method to determine the lowest spender
	public static String lowestSpender(String [][] amt) {
		String lSpend="";
		//assuming that no one will be spending more than $1000
		double lowest=1000;
		//going thru amt to see if anyone is lower than the lowest, parsing so i can compare
		for(int l=0; l< amt.length; l++) {
			if(Double.parseDouble(amt[l][1])<lowest) {
				lowest=Double.parseDouble(amt[l][1]);
				lSpend=amt[l][0];
			}
		}
		//returning the name of the lowest spender
		return lSpend;
	}
	//method to compute the average amount spent
	public static double computeAvg(String [][] amt) {
		double average=0;
		double sum=0;
		//basic math to determine average
		for(int y=0; y<amt.length; y++) {
			sum+=Double.parseDouble(amt[y][1]);
		}
		average=sum/amt.length;
		//returning the average
		return average;
	}
}
