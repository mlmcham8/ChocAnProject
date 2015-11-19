import java.io.IOException;
import java.util.Scanner;


public class Manager extends Operator {
	static public int Choice;
	public static void main(String[] args) throws IOException{
		//openMember();
		//openProviders();
	while(Choice!= 12) {
		System.out.println();
		System.out.println("What would you like to do? (Type in a number form the menu below and hit Enter)");
		System.out.println();
		System.out.println("1. Add Member");
		System.out.println("2. Add Provider");
		System.out.println("3. Update existing Member");
		System.out.println("4. Update existing Provider");
		System.out.println("5. Remove a Member");
		System.out.println("6. Remove a Provider");
		System.out.println("7. Look Up Member");
		System.out.println("8. Look Up Provider");
		System.out.println("9. Get Member Report");
		System.out.println("10. Get Provider Report");
		System.out.println("11. Get Summary Report");
		
		System.out.println("12. Return to main Console");
		System.out.println("13. EXIT");
		Scanner s = new Scanner(System.in);
		Choice = s.nextInt();
		
		
		switch(Choice){
			case 1: 		
				displayMembers();
				AddMember();
				
				break;
			case 2: 
				displayProviders();
				AddProvider();
				break;
			case 3:
				//openMember();
				displayMembers();
				updateMember();
				break;
			case 4:
				//openProviders();
				displayProviders();
				updateProvider();
				break;
			case 5:
				//openMember();
				displayMembers();
				removeMember();
				
				break;
			case 6:
				//openProviders();
				displayProviders();
				removeProvider();
				break;
			case 7:
				displayMembers();
				lookupMember();
				break;
			case 8:
				displayProviders();
				lookupProvider();
				break;
			case 9:
				getMemberReport();
				
				break;
			case 10: 
				getProviderReport();
				
				break;
			case 11:
				getSummaryReport();
				break;
			case 13:
				System.exit(Choice);
		}	
	}//while(Choice != 12);
	}
	public static void getSummaryReport() throws IOException{
		Report.generateSummaryReport();
	}
	
	public static void getMemberReport() throws IOException{
		Report.generateMemberReport();
		
	}
	
	public static void getProviderReport() throws IOException{
		Report.generateProviderReport();
		
		
	}
}
