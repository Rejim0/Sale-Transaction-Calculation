//SP2023_PROJECT_OLI
//SP2023_Sale_SP23Product_Application_OLI

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SP2023_Sale_SP23Product_Application_OLI {
	static final String[] productName = {"SP23A", "SP23B", "SP23C"};
	static final String[] productSize = { "SMALL", "MEDIUM", "LARGE" };
	static final float[] productPrice = { 11.5f, 12.5f, 13.5f, 21.5f, 22.5f, 23.5f, 31.5f, 32.5f, 33.5f};
	static final float TAX_RATE = 0.0825f;
	
	public static void ShowMenu(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();    
	    System.out.println("SP2023_SaleProductSP23_Application_OLI");
	    System.out.println("SP2023 COMPANY MENU - REJIM OLI");
	    System.out.println("Today: " + dtf.format(now));
	    System.out.println("---------------------------------------");
	    System.out.println("1.Sale SP23 Product");
	    System.out.println("2.Print Day Sale Report");
	    System.out.println("3.Print Month Sale Report");
	    System.out.println("4.Print Year Sale Report");
	    System.out.println("0.Exit");
	    System.out.print("Enter a number 1 to 4 to select a task or 0 to exit: ");
	    System.out.println();
	    
	}
	
	public static void ShowSaleProduct(int[] productUnits){
		
		while(true) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			LocalDateTime now = LocalDateTime.now();    
			System.out.println("SP2023_SaleProductSP23_Application_OLI");
			System.out.println("SP2023 COMPANY MENU - OLI");
			System.out.println("Today: " + dtf.format(now));
			System.out.println("---------------------------------------");
			System.out.println("1.Model SP23A");
			System.out.println("2.Model SP23B");
			System.out.println("3.Model SP23C");
			System.out.println("0.Exit");
			System.out.print("Enter 1, 2, 3 to select the product model or 0 to Exit: ");
	    
			Scanner scanner = new Scanner(System.in);
			int option1;
			option1 = scanner.nextInt();
		    System.out.println();
			if (option1 == 0) break;
			while(true)
			{	      
				System.out.println("SP2023_SaleProductSP23_Application_OLI");
				System.out.println("SP2023 COMPANY MENU - OLI");
				System.out.println("Today: " + dtf.format(now));
				System.out.println("---------------------------------------");
				System.out.println("1.SMALL");
				System.out.println("2.MEDIUM");
				System.out.println("3.LARGE");
				System.out.println("0.Exit");
				System.out.print("Enter 1, 2, 3 to select the product modelor 0 to Exit: ");
				
				int option2;
				option2 = scanner.nextInt();
			    System.out.println();
				boolean shouldBreakSize = false;
				int index = 0;
				switch(option2) {
				case 1:
					if(option1 == 1)
						index = 0;
					else if(option1 == 2)
						index = 3;
					else if(option1 == 3)
						index = 6;
					break;
				case 2:
					if(option1 == 1)
						index = 1;
					else if(option1 == 2)
						index = 4;
					else if(option1 == 3)
						index = 7;
					break;
				case 3:
					if(option1 == 1)
						index = 2;
					else if(option1 == 2)
						index = 5;
					else if(option1 == 3)
						index = 8;
					break;
				case 0:
					shouldBreakSize = true;
					break;
				}
				if (shouldBreakSize) break;
				
				System.out.print("Enter number of units: ");
				int unit;
				unit = scanner.nextInt();
			    System.out.println();
				productUnits[index] = productUnits[index]+ unit;
			
			}
			
		}
			
	}
	
	public static void PrintDayReport() throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Day File Name: ");
		String fileName = scanner.nextLine();
		System.out.println();
		final int[] productUnits = { 0, 0, 0, 0, 0, 0, 0, 0, 0};
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");  
		LocalDateTime now = LocalDateTime.now();
    	File myObj = new File(fileName);
    	
    	if(!myObj.exists()){
    		System.out.println("File does not exist");
    		return;
    	}
    	
    	Scanner myReader = new Scanner(myObj);
    	String data="";
        while (myReader.hasNextLine()) {
          data = myReader.nextLine();
          String[] words = data.split(" ");
          String day = words[0];
          
          productUnits[0] = productUnits[0] + Integer.parseInt(words[1]);
          productUnits[1] = productUnits[1] + Integer.parseInt(words[2]);
          productUnits[2] = productUnits[2] + Integer.parseInt(words[3]);
          productUnits[3] = productUnits[3] + Integer.parseInt(words[4]);
          productUnits[4] = productUnits[4] + Integer.parseInt(words[5]);
          productUnits[5] = productUnits[5] + Integer.parseInt(words[6]);
          productUnits[6] = productUnits[6] + Integer.parseInt(words[7]);
          productUnits[7] = productUnits[7] + Integer.parseInt(words[8]);
          productUnits[8] = productUnits[8] + Integer.parseInt(words[9]);
          
        
        }
        myReader.close();
        SP2023_SP23Product_OLI sp2023_SP23Product_OLI = new SP2023_SP23Product_OLI(productUnits);
        sp2023_SP23Product_OLI.printReport(productPrice);
        sp2023_SP23Product_OLI.writeMonthFile();
	}
	
	static void PrintMonthReport() throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Month File Name: ");
		String fileName = scanner.nextLine();
		System.out.println();
		final int[] productUnits = { 0, 0, 0, 0, 0, 0, 0, 0, 0};
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");  
		LocalDateTime now = LocalDateTime.now();
    	File myObj = new File(fileName);
    	
    	if(!myObj.exists()){
    		System.out.println("File does not exist");
    		return;
    	}
    	
    	Scanner myReader = new Scanner(myObj);
    	String data="";
        while (myReader.hasNextLine()) {
          data = myReader.nextLine();
          String[] words = data.split(" ");
          String day = words[0];
          
          productUnits[0] = productUnits[0] + Integer.parseInt(words[1]);
          productUnits[1] = productUnits[1] + Integer.parseInt(words[2]);
          productUnits[2] = productUnits[2] + Integer.parseInt(words[3]);
          productUnits[3] = productUnits[3] + Integer.parseInt(words[4]);
          productUnits[4] = productUnits[4] + Integer.parseInt(words[5]);
          productUnits[5] = productUnits[5] + Integer.parseInt(words[6]);
          productUnits[6] = productUnits[6] + Integer.parseInt(words[7]);
          productUnits[7] = productUnits[7] + Integer.parseInt(words[8]);
          productUnits[8] = productUnits[8] + Integer.parseInt(words[9]);
          
        
        }
        myReader.close();
        SP2023_SP23Product_OLI sp2023_SP23Product_OLI = new SP2023_SP23Product_OLI(productUnits);
        sp2023_SP23Product_OLI.printReport(productPrice);
        sp2023_SP23Product_OLI.writeYearFile();
	}
	
	public static void PrintYearReport() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter year File Name: ");
		String fileName = scanner.nextLine();
		System.out.println();
		final int[] productUnits = { 0, 0, 0, 0, 0, 0, 0, 0, 0};
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");  
		LocalDateTime now = LocalDateTime.now();
    	File myObj = new File(fileName);
    	
    	if(!myObj.exists()){
    		System.out.println("File does not exist");
    		return;
    	}
    	
    	Scanner myReader = new Scanner(myObj);
    	String data="";
        while (myReader.hasNextLine()) {
          data = myReader.nextLine();
          String[] words = data.split(" ");
          String day = words[0];
          
          productUnits[0] = productUnits[0] + Integer.parseInt(words[1]);
          productUnits[1] = productUnits[1] + Integer.parseInt(words[2]);
          productUnits[2] = productUnits[2] + Integer.parseInt(words[3]);
          productUnits[3] = productUnits[3] + Integer.parseInt(words[4]);
          productUnits[4] = productUnits[4] + Integer.parseInt(words[5]);
          productUnits[5] = productUnits[5] + Integer.parseInt(words[6]);
          productUnits[6] = productUnits[6] + Integer.parseInt(words[7]);
          productUnits[7] = productUnits[7] + Integer.parseInt(words[8]);
          productUnits[8] = productUnits[8] + Integer.parseInt(words[9]);

        }
        myReader.close();
        SP2023_SP23Product_OLI sp2023_SP23Product_OLI = new SP2023_SP23Product_OLI(productUnits);
        sp2023_SP23Product_OLI.printReport(productPrice);
	}
	
	public static void main(String[] args) throws IOException{
		final int[] productUnits = { 0, 0, 0, 0, 0, 0, 0, 0, 0};
		while(true)
		{
			ShowMenu();
			Scanner scanner = new Scanner(System.in);
			int option;
			option = scanner.nextInt();	 
			switch(option) {
			case 1:
				ShowSaleProduct(productUnits);
				SP2023_SP23Product_OLI sp2023_SP23Product_OLI = new SP2023_SP23Product_OLI(productUnits);
				sp2023_SP23Product_OLI.printReciept(productPrice);
				sp2023_SP23Product_OLI.writeDayFile();
				break;
			case 2:
				PrintDayReport();
				break;
			case 3:
				PrintMonthReport();
				break;
			case 4:
				PrintYearReport();
				break;
			case 0:
				System.exit(0);
				break;
			}
		}
	}
}
