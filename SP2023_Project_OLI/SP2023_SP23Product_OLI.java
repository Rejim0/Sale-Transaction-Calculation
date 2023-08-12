//SP2023_SP23Product_OLI
//SP2023_PROJECT_OLI

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SP2023_SP23Product_OLI {
	private static int transactionCount = 0001;
	private int[] productUnits;

    public SP2023_SP23Product_OLI() {
        this.productUnits = new int[9];
    }

    public SP2023_SP23Product_OLI(int[] productUnits) {
        this.productUnits = productUnits;
    }

    public float[] calculatePrice(float[] prices) {
        float[] totalPrices = new float[9];
        for (int i = 0; i < 9; i++) {
            totalPrices[i] = this.productUnits[i] * prices[i];
        }
        return totalPrices;
    }

    public float calculateSubtotal(float[] prices) {
        float subtotal = 0;
        float[] pricess = calculatePrice(prices);
        for (float price : pricess) {
            subtotal += price;
        }
        return subtotal;
    }

    public double calculateTax(float[] prices) {
        float taxRate = (float) 0.0825;
        float subtotal = calculateSubtotal(prices);
        return subtotal * taxRate;
    }

    public double calculateTotal(float[] prices) {
        float subtotal = calculateSubtotal(prices);
        double tax = calculateTax(prices);
        return subtotal + tax;
    }
    
    public void printReciept(float[] productPrice)
    {
    	float[] prices = calculatePrice(productPrice);
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();    
	    System.out.println("File: SP2023_Sale_SP23ProductApplication");
	    System.out.println("RECIEPT - SP23PRODUCT COMPANY - REJIM OLI");
	    System.out.println("Current Date: "+"                 " + dtf.format(now));
	    System.out.println("Sale Transaction: "+"                   " + String.format("%04d", transactionCount++));
	    System.out.println("----------------------------------------------");
	    System.out.println("PRODUCT NAME	UNIT PRICE	UNITS	MONEY");
	    System.out.println("SP23A SMALL     " + String.format("%.2f",productPrice[0]) + "		" + productUnits[0] + "	" + String.format("%.2f",prices[0]));
	    System.out.println("SP23A MEDIUM    " + String.format("%.2f",productPrice[1]) + "		" + productUnits[1] + "	" + String.format("%.2f",prices[1]));
	    System.out.println("SP23A LARGE     " + String.format("%.2f",productPrice[2])+ "		" + productUnits[2] + "	" + String.format("%.2f",prices[2]));
	    System.out.println("SP23B SMALL     " + String.format("%.2f",productPrice[3]) + "		" + productUnits[3] + "	" + String.format("%.2f",prices[3]));
	    System.out.println("SP23B MEDIUM    " + String.format("%.2f",productPrice[4]) + "		" + productUnits[4] + "	" + String.format("%.2f",prices[4]));
	    System.out.println("SP23B LARGE     " + String.format("%.2f",productPrice[5]) + "		" + productUnits[5] + "	" + String.format("%.2f",prices[5]));
	    System.out.println("SP23C SMALL     " + String.format("%.2f",productPrice[6]) + "		" + productUnits[6] + "	" + String.format("%.2f",prices[6]));
	    System.out.println("SP23C MEDIUM    " + String.format("%.2f",productPrice[7]) + "		" + productUnits[7] + "	" + String.format("%.2f",prices[7]));
	    System.out.println("SP23C LARGE     " + String.format("%.2f",productPrice[8]) + "		" + productUnits[8] + "	" + String.format("%.2f",prices[8]));
	    System.out.println("----------------------------------------------");
	    System.out.printf("SUBTOTAL: %35.2f\n",  calculateSubtotal(productPrice));
	    System.out.printf("TAX: %40.2f\n",  calculateTax(productPrice));
	    System.out.printf("TOTAL : %37.2f\n", calculateTotal(productPrice));
	    System.out.println();
	    
    }
    
    public void writeDayFile() throws IOException{
    	int transactionid = 001;
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy");  
		LocalDateTime now = LocalDateTime.now();
		dtf.format(now);
    	File myObj = new File("dayFile_" + dtf.format(now) + ".txt");
    	try {
			myObj.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(myObj.exists())
        {
        	Scanner myReader = new Scanner(myObj);
        	String data="";
            while (myReader.hasNextLine()) {
              data = myReader.nextLine();
            }
            myReader.close();
            
            FileWriter myWriter = new FileWriter("dayFile_" + dtf.format(now) + ".txt",true);
            if(data != "")
            {
            	String[] words = data.split(" ");
            	transactionid = Integer.parseInt(words[0]);
            	transactionid++;
            }
            myWriter.write("000" + Integer.toString(transactionid));
            for (int i = 0; i < 9; i++) {
            	myWriter.write(" " + Integer.toString(productUnits[i]));
            }
            myWriter.write(System.lineSeparator());
            myWriter.close();
        }
    }
    
    public void writeMonthFile() throws IOException{
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMyyyy");  
		LocalDateTime now = LocalDateTime.now();
    	File myObj = new File("monthFile_" + dtf.format(now) + ".txt");
    	try {
			myObj.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(myObj.exists())
        {
        	Scanner myReader = new Scanner(myObj);

            
            FileWriter myWriter = new FileWriter("monthFile_" + dtf.format(now) + ".txt",true);
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd");  
            myWriter.write(dtf2.format(now));
            for (int i = 0; i < 9; i++) {
            	myWriter.write(" " + Integer.toString(productUnits[i]));
            }
            myWriter.write(System.lineSeparator());
            myWriter.close();
        }
    }
    
    public void writeYearFile() throws IOException{
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");  
		LocalDateTime now = LocalDateTime.now();
    	File myObj = new File("yearFile_" + dtf.format(now) + ".txt");
    	try {
			myObj.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(myObj.exists())
        {
        	FileWriter myWriter = new FileWriter("yearFile_" + dtf.format(now) + ".txt",true);
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM");  
            myWriter.write(dtf2.format(now));
            for (int i = 0; i < 9; i++) {
            	myWriter.write(" " + Integer.toString(productUnits[i]));
            }
            myWriter.write(System.lineSeparator());
            myWriter.close();
        }
    }
    
    public void printReport(float[] productPrice){
    	float[] prices = calculatePrice(productPrice);
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();    
	    System.out.println("File: SP2023_Sale_SP23ProductApplication.cpp");
	    System.out.println("RECIEPT - SP23PRODUCT COMPANY - REJIM OLI");
	    System.out.println("Current Date: " +"                 "+dtf.format(now));
	    System.out.println("----------------------------------------------");
	    System.out.println("PRODUCT NAME	UNIT PRICE	UNITS	MONEY");
	    System.out.println("SP23A SMALL     " + String.format("%.2f",productPrice[0]) + "		" + productUnits[0] + "	" + String.format("%.2f",prices[0]));
	    System.out.println("SP23A MEDIUM    " + String.format("%.2f",productPrice[1]) + "		" + productUnits[1] + "	" + String.format("%.2f",prices[1]));
	    System.out.println("SP23A LARGE     " + String.format("%.2f",productPrice[2]) + "		" + productUnits[2] + "	" + String.format("%.2f",prices[2]));
	    System.out.println("SP23B SMALL     " + String.format("%.2f",productPrice[3]) + "		" + productUnits[3] + "	" + String.format("%.2f",prices[3]));
	    System.out.println("SP23B MEDIUM    " + String.format("%.2f",productPrice[4]) + "		" + productUnits[4] + "	" + String.format("%.2f",prices[4]));
	    System.out.println("SP23B LARGE     " + String.format("%.2f",productPrice[5]) + "		" + productUnits[5] + "	" + String.format("%.2f",prices[5]));
	    System.out.println("SP23C SMALL     " + String.format("%.2f",productPrice[6]) + "		" + productUnits[6] + "	" + String.format("%.2f",prices[6]));
	    System.out.println("SP23C MEDIUM    " + String.format("%.2f",productPrice[7])+ "		" + productUnits[7] + "	" + String.format("%.2f",prices[7]));
	    System.out.println("SP23C LARGE     " + String.format("%.2f",productPrice[8]) + "		" + productUnits[8] + "	" + String.format("%.2f",prices[8]));
	    System.out.println("----------------------------------------------");
	    System.out.printf("SUBTOTAL: %35.2f\n", calculateSubtotal(productPrice));
	    System.out.printf("TAX: %40.2f\n", calculateTax(productPrice));
	    System.out.printf("TOTAL : %37.2f\n", calculateTotal(productPrice));
	    System.out.println();
         
    }
}
