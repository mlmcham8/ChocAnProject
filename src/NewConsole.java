import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class NewConsole {
	static private int Choice;
	private static final Scanner CONSOLE = new Scanner(System.in);
	
	public static boolean validated() {
		System.out.println("Validated");
		return true;
	}
	
	public static boolean invalid() {
		System.out.println("Invalid");
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		while(Choice != 4){
		
			System.out.println();
			System.out.println("What would you like to do? (Type in a number form the menu below and hit Enter)");
			System.out.println();
			System.out.println("1. Login as a Operator");
			System.out.println("2. Login as a Provider");
			System.out.println("3. Login as an Manager");
			System.out.println("4. All done. Exit please!");
			
			//User inputs the number they want to do
			//which is then stored in the private variable Choice
			Scanner input = new Scanner(System.in);
			Choice = input.nextInt();
			
		//Switch Case between the Operator, Provider, and Manager
		//Will loop through until the user inputs Choice 4
		switch(Choice){
		case 1:
			//Operator Case
			Operator.openMember();
			Operator.openProviders();
			FileInputStream f = new FileInputStream("Operators.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(f));
			String currentLine; 
			while ((currentLine = br.readLine()) != null) {
				String tokens[] = currentLine.split("\t"); 
				String id = getValidString("Please enter your 3-digit Operator ID:",tokens[0]);
				if (id.equals(tokens[0])) { //valid Operator
					//boolean valid = validated();
					System.out.println(id);
					System.out.println("Verify this is you: (Y/N) ");
					System.out.println(tokens[1] +" "+ tokens[2]);
					//System.out.println(" ");
					while(true){
					String Choice = input.next();
					if(Choice.equals("Y")){
						Operator.main(args);
						break;
						}
					else {
						System.out.println();
						System.out.println("Try again, and enter the correct Operator ID!");
						break;
						}
					}
					}break;	
			 }break;
			 
		case 2:
			//Provider Case
			//Operator.openProviders();
			FileInputStream fp = new FileInputStream("Providers.txt");
			BufferedReader brp = new BufferedReader(new InputStreamReader(fp));

			String currentPLine; 
			while ((currentPLine = brp.readLine()) != null) {
				String tokens[] = currentPLine.split("\t");
				String num = getValidString("Please enter your 6-digit Provider Number: ",tokens[0]);
				if (num.equals(tokens[0])) { //valid provider
					System.out.println("Verify this is you: (Y/N) ");
					System.out.println(tokens[1] +" "+ tokens[2]);
					//boolean valid = validated();
					String Choice = input.next();
					if(Choice.equals("Y")){
						Provider.main(args);
						}
					else {
						System.out.println();
						System.out.println("Try again, and enter the correct Operator ID!");
						
						}
				}	break;
			} break;
			
		case 3:
			//Manager Case
			FileInputStream fa = new FileInputStream("Mangers.txt");
			BufferedReader bra = new BufferedReader(new InputStreamReader(fa));
			String currentALine; 
			while ((currentALine = bra.readLine()) != null) {
				String tokens[] = currentALine.split("\t");
				 //Valid Manager ID
					String admin = getValidString("Please enter you 3-digit Manger ID: ",tokens[0]);
					if (admin.equals(tokens[0])) {
					System.out.println("Verify this is you: (Y/N) ");
					System.out.println(tokens[1] +" "+ tokens[2]);
					String Choice = input.next();
					while(true){
					if(Choice.equals("Y")){
						Operator.openMember();
						Operator.openProviders();
						Manager.main(args);
						break;
						}
					else {
						System.out.println();
						System.out.println("Try again, and enter the correct Operator ID!");
						break;
						}
					}
					} break;				
				}break;
		case 4:
			System.exit(Choice);
			}
		}
	}
	
	
	public static String getValidString(String prompt, String regex) {
		if (prompt == null || regex == null) {
			throw new IllegalArgumentException();
		}
		while (true) {
			System.out.println(prompt + " ");
			String input = CONSOLE.nextLine();
			if (input.matches(regex)) {
				
				return input;
			} else {
				System.out.println("Invalid input.  Please try again.");
				System.out.println();
			}
		}
		//return regex;
	}
}

		

