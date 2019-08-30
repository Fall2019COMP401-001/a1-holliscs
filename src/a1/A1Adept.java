package a1;

import java.util.Scanner;
import java.util.*;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		//reading in the number of items in the store
		int iStore=scan.nextInt();
		
		//declaring a 2d array to keep track of the items of the store & their prices
			String[][] storeItems = new String[iStore][2];
		
		//getting the names and prices of each item in the store
		for(int i=0; i<iStore; i++) {
			
			String iName=scan.next();
			
			String iPrice=scan.next();
			
			storeItems[i][0]=iName;
			storeItems[i][1]=iPrice;
		}
		//reading in the number of customers
		int numCust=scan.nextInt();
		
		//declaring a 2d array to keep track of each customer and how much they spent
		String[][] amtSpent = new String[numCust][2];
		
		String name;
		
		for (int k=0; k<numCust; k++) {
			//reading in the first name of the customer
			String fName=scan.next();
			
			//reading in last name of the customer
			String lName=scan.next();
			
			//creating a single name variable for convenience
			name=fName+" "+lName;
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
				//finding the cost of the listed item
				for(int p=0; p< storeItems.length; p++) {
					
					if(storeItems[p][0].contentEquals(iName)) {
						//parsing the cost to an integer var so we can do math
						cost=Double.parseDouble(storeItems[p][1]);
					}
					
				}
					
				
				cTotal+=(qItem*cost);
			}
			amtSpent[k][1]= ""+cTotal;
		}
		
		//calling function to see who spent the most
			String greatest=highestSpender(amtSpent);
			String gAmount="";
			for(int c=0; c<amtSpent.length; c++) {
				if(amtSpent[c][0].equals(greatest)) {
					gAmount=amtSpent[c][1];
				}
			}
			//System.out.println(gAmount);
			double gDouble=Double.parseDouble(gAmount);
			//System.out.printf("%.2f", gDouble);
			//String gOut=String.format("%.2f", gAmount);
		//calling function to see who spent the least
			String lowest=lowestSpender(amtSpent);
			String lAmount="";
			for(int f=0; f<amtSpent.length; f++) {
				if(amtSpent[f][0].equals(lowest)) {
					lAmount=amtSpent[f][1];
				}
			}
			double lDouble=Double.parseDouble(lAmount);
			
			//String lOut=String.format("%.2f", lAmount);
			
		double avg=computeAvg(amtSpent);
		
		//String aOut=String.format("%.2f", avg);
		System.out.print("Biggest: "+ greatest+ " (");
		System.out.printf("%.2f", gDouble);
		System.out.println(")");
		System.out.print("Smallest: "+ lowest+" (");
		System.out.printf("%.2f", lDouble);
		System.out.println(")");
		System.out.print("Average: ");
		System.out.printf("%.2f", avg);
	}
	
	
	public static String highestSpender(String[][] amt) {
		String hSpend=""; 
		double highest=0;
		for (int m=0; m< amt.length; m++) {
			if(Double.parseDouble(amt[m][1])>highest) {
				highest=Double.parseDouble(amt[m][1]);
				hSpend=amt[m][0];
			}
			
		}
		
		return hSpend;
	}
	
	public static String lowestSpender(String [][] amt) {
		String lSpend="";
		double lowest=1000;
		
		for(int l=0; l< amt.length; l++) {
			if(Double.parseDouble(amt[l][1])<lowest) {
				lowest=Double.parseDouble(amt[l][1]);
				lSpend=amt[l][0];
			}
		}
		
		return lSpend;
	}
	public static double computeAvg(String [][] amt) {
		double average=0;
		double sum=0;
		for(int y=0; y<amt.length; y++) {
			sum+=Double.parseDouble(amt[y][1]);
		}
		average=sum/amt.length;
		return average;
	}
}
