import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class Operator {

	static int MemID;
	static String FName;
	static String LName;
	static String MemAdd;
	static String MemCity;
	static String MemSt;
	static String MemZip;
	static String MemPhone;
	static String MemDOB;
	static String MemStatus;
	
	
	static int ProvNum;
	static String FPName;
	static String LPName;
	static String ProAdd;
	static String ProCity;
	static String ProSt;
	static String ProZip;
	static String ProPhone;
	static String ProStatus;
	//private static Scanner input; 
	static private int Choice;
	static private int Choice1;
	static private int Choice2;
	static private int Choice3;
	static private int Choice4;
	static private int Choice5;
	static ArrayList<MemAdmin> MList = new ArrayList<MemAdmin>();
	static ArrayList vMemId = new ArrayList();
	static ArrayList vProNum = new ArrayList();
	static ArrayList<MemAdmin> totalMList = new ArrayList<MemAdmin>();
	private static DefaultListModel mResults = new DefaultListModel();
    static ArrayList<ProAdmin> PList = new ArrayList<ProAdmin>();
    static ArrayList<ProAdmin> totalPList = new ArrayList<ProAdmin>();
    private static DefaultListModel pResults = new DefaultListModel();
	
    private static final Scanner CONSOLE = new Scanner(System.in);
    
	public static void main(String[] args) throws IOException{
		
	while(Choice!= 9) {
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
		//System.out.println("9. Get Member Report");
		//System.out.println("10. Get Provider Report");
		//System.out.println("11. Get Summary Report");
		
		System.out.println("9. Return to main Console");
		System.out.println("10. EXIT");
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
				//displayMembers();
				lookupMember();
				break;
			case 8:
				//displayProviders();
				lookupProvider();
				break;
			case 9:
				;
				break;
			case 10: 
				System.exit(Choice);
				
		}	
	}//while(Choice != 12);
}
	
	public static void AddMember() throws IOException{
		System.out.println("Enter all of the needed new member information:");
		System.out.println();
		
		Scanner m = new Scanner(System.in);
		System.out.println("9-digit Member ID (that does not exist in the above list): ");
		String memId = m.next();
		
		System.out.println("Member's First Name:");
		FName = m.next();
		
		System.out.println("Member's Last Name:");
		LName = m.next();
	
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		System.out.println("Member's Address:");
		try {
			MemAdd = reader.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		InputStreamReader input2 = new InputStreamReader(System.in);
		BufferedReader reader2 = new BufferedReader(input2);
		System.out.println("City: ");
		try {
			MemCity = reader2.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("State (ex. CA): ");
		MemSt = m.next();
		
		System.out.println("Zipcode: ");
		MemZip = m.next();
		
		System.out.println("Member's Phone Number (XXX-XXX-XXXX): ");
		MemPhone = m.next();
		
		System.out.println("Member's D.O.B (MM/DD/YYYY): ");
		MemDOB = m.next();
		
		System.out.println("Member Status (Active(A) or Inactive(IA):  ");
		MemStatus = m.next();
		
		MemID = Integer.parseInt(memId);
		MemAdmin mem = new MemAdmin(MemID, FName, LName, MemAdd, MemCity, MemSt, MemZip, MemPhone,MemDOB, MemStatus);
		System.out.println();
		vMemId.add(mem.getMemId().toString());
		
			System.out.println("New Member's information: ");
			System.out.println(mem.getFullString());
			
			System.out.println();
			//String answer = m.next();
			//System.out.println("1. Yes );
			
			//if ( answer.equals("Y")){
			MList.add(mem);
			totalMList.add(mem);
			
			//mResults.addElement(mem);
			
			BufferedWriter writer = null;
			try {
				PrintWriter out = new PrintWriter(
	                    new BufferedWriter(
	                    new FileWriter("Members.txt",true)));
							out.print( mem.getMemId() + "\t");
							out.print( mem.getFirstName() + "\t");
							out.print(mem.getLastName() + "\t");
							out.print(mem.getAdd() + "\t");
							out.print( mem.getCity() + "\t");
							out.print( mem.getSt() + "\t");
							out.print( mem.getZip() + "\t");
							out.print(mem.getMemPhone() + "\t");
							out.print( mem.getMemDOB() + "\t");
							out.print( mem.getMemberStatus() + "\n");
							out.close();
					}
				 catch (IOException e) {
					e.printStackTrace();
				}
			
			while(Choice1 != 4){
			System.out.println("What do you want to do next?");
			System.out.println();
			System.out.println("1. Add more Members ");
			System.out.println("2. Update existing Members ");
			System.out.println("3. Remove a Member");
			System.out.println("4. Return to Main Menu ");
			System.out.println("5. Exit ");
			Choice1 = m.nextInt();
			switch(Choice1){
			case 1:
				displayMembers();
				AddMember();
				break;
			case 2:
				displayMembers();
				updateMember();
				break;
			case 3:
				displayMembers();
				removeMember();
				break;
				
			case 5:
				System.exit(Choice1);
				}	
			}
		}
		
	
	
	public static void AddProvider() throws IOException{
		System.out.println();
		System.out.println("Enter all the needed information for new Provider: ");
		Scanner p = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter 6-digit Provider Num (that does not exist in the above list: ");
		String proNUm = p.next();

		System.out.println("Provider's First Name:");
		FPName = p.next();
		
		System.out.println("Provider's Last Name:");
		LPName = p.next();
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		System.out.println("Provider's Address:");
		try {
			ProAdd = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		InputStreamReader input2 = new InputStreamReader(System.in);
		BufferedReader reader2 = new BufferedReader(input2);
		p.nextLine();
		System.out.println("City: ");
		try {
			ProCity = reader2.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("State (ex. CA): ");
		ProSt = p.next();
		
		System.out.println("Zipcode: ");
		ProZip = p.next();
		
		System.out.println("Provider's Phone Number (XXX-XXX-XXXX): ");
		ProPhone = p.next();
		
		System.out.println("Member Status (Active(A) or Inactive(IA)):  ");
		ProStatus = p.next();
		
		ProvNum = Integer.parseInt(proNUm);
		ProAdmin prov = new ProAdmin(ProvNum, FPName, LPName, ProAdd,ProCity,ProSt, ProZip, ProPhone, ProStatus);
		PList.add(prov);
		totalPList.add(prov);
		pResults.addElement(prov);
		System.out.println();
		System.out.println("New Provider's information: ");
		System.out.println(prov.getFullString());
		System.out.println();
		
		BufferedWriter writer = null;
		try {
			PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter("Providers.txt",true)));
						out.print( prov.getProNum() + "\t");
						out.print( prov.getFirstName() + "\t");
						out.print( prov.getLastName() + "\t");
						out.print(prov.getAdd() + "\t");
						out.print( prov.getCity() + "\t");
						out.print( prov.getSt() + "\t");
						out.print( prov.getZip() + "\t");
						out.print( prov.getProvPhone() + "\t");
						out.print( prov.getProviderStatus() + "\n");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		while(Choice2 != 4){
			System.out.println("What do you want to do next?");
			System.out.println();
			System.out.println("1. Add more Provider ");
			System.out.println("2. Update existing Provider ");
			System.out.println("3. Remove a Provider");
			System.out.println("4. Return to Main Menu ");
			System.out.println("5. Exit ");
			Choice2 = p.nextInt();
			switch(Choice2){
			case 1:
				
				displayProviders();
				AddProvider();
				break;
			case 2:
				displayProviders();
				updateProvider();
				break;
			case 3:
				displayProviders();
				removeProvider();
				break;
			case 5:
				System.exit(Choice2);
			}
			
			
			}
	}
	
 	public static void removeMember() throws IOException {
 		
 		try {
 			System.out.println("Enter the 9-digit Member ID to remove: ");
			Scanner p = new Scanner(System.in);
			String memID=  p.next();
			File inputFile = new File("Members.txt");
			if (!inputFile.isFile()) {
        		System.out.println("Parameter is not an existing file");
        		return;
      		}
			File tempFile = new File("mytempFile.txt");     	
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String currentLine;
			validMember(memID);
			while((currentLine = reader.readLine()) != null ) {
				if(!vMemId.contains(memID)){
					
					writer.write(currentLine); 
   	 				writer.newLine();
				}
				else if (!currentLine.contains(memID)){
   	 				writer.write(currentLine); 
   	 				writer.newLine();
				}
				else if (currentLine.contains(memID)){
					totalMList.remove(currentLine);
					//vMemId.get(currentLine[0])
					vMemId.remove(memID);
				}
			}
			writer.close(); 
			boolean successful = tempFile.renameTo(inputFile);
 		} 
 		catch (FileNotFoundException ex) {
 			ex.printStackTrace();
 		}
 		catch (IOException ex) {
 			ex.printStackTrace();
 		} 
 	}

	public static void removeProvider(){
		try {
			System.out.println("Enter the 6-digit Provider Number to remove: ");
			Scanner p = new Scanner(System.in);
			String proNum =  p.next();
			File inputFile = new File("Providers.txt");
			if (!inputFile.isFile()) {
        		System.out.println("Parameter is not an existing file");
        		return;
      		}
			File tempFile = new File("mytempFile.txt");     	
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			
			String currentLine;	
			validProvider(proNum);
			while((currentLine = reader.readLine()) != null) {
				
				if(!vProNum.contains(proNum)){
					writer.write(currentLine); 
   	 				writer.newLine();
				}
				else if (!currentLine.contains(proNum)){
   	 				writer.write(currentLine); 
   	 				writer.newLine();
				}
				
				if (currentLine.contains(proNum)){
					totalPList.remove(currentLine);
					//vMemId.get(currentLine[0])
					vProNum.remove(proNum);
				}
				
			}
			writer.close(); 
			boolean successful = tempFile.renameTo(inputFile);
		} 
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void updateMember(){	
		try {
            // Open the file that is the first
            // command line parameter
			System.out.println("Enter the 9-digit Member ID to Update: ");
			Scanner m = new Scanner(System.in);
			String MemId =  m.next();
            FileInputStream fstream = new FileInputStream("Members.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            validMember(MemId);
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
            	//totalMList.remove(strLine);
            	//vMemId.remove(mems.getMemId());
                String tokens[] = strLine.split("\t");
                if (tokens.length > 0) {
                	//MemID = Integer.parseInt(tokens[0]);
                	//MemAdmin mems = new MemAdmin(MemID,tokens[1], tokens[2],tokens[3], tokens[4], tokens[5], tokens[6], tokens[7],tokens[8], tokens[9]);
                	
                	
                    // Here tokens[0] will have value of ID
                    if (tokens[0].equals(MemId)) {
                    	System.out.println("Current Member Information:");
                    	System.out.println(strLine);
                    	System.out.println();
                    	//System.out.println(tokens[0]);
                    	while(Choice3!= 6){
                    		System.out.println();
                			System.out.println("What do you want to update?");
                			System.out.println();
                			System.out.println("1. Member's First Name ");
                			System.out.println("2. Member's Last Name ");
                			System.out.println("3. Member's Address");
                			System.out.println("4. Member's Phone Number ");
                			System.out.println("5. Member's Status ");
                			System.out.println("6. Exit, and update Member information");
                			
                			
                			//switch between cases
                			Choice3 = m.nextInt();
                			//System.out.println();
                			//System.out.println("Member ID: " + tokens[0]);
    						int MemID = Integer.parseInt(tokens[0]);
                			switch(Choice3){
                			case 1:
        						System.out.println("Member's NEW First Name:");
        						tokens[1] = m.next();
                				break;
                			case 2:
                				System.out.println("Member's NEW Last Name:");
        						tokens[2] = m.next();
                				break;
                			case 3:
        						InputStreamReader input = new InputStreamReader(System.in);
        						BufferedReader reader = new BufferedReader(input);
        						System.out.println("Member's NEW Address:");
        						try {
        							tokens[3] = reader.readLine();
        						} catch (IOException e) {
        							e.printStackTrace();
        						}
        						InputStreamReader input2 = new InputStreamReader(System.in);
        						BufferedReader reader2 = new BufferedReader(input2);
        						System.out.println("NEW City: ");
        						try {
        							tokens[4] = reader2.readLine();
        						} catch (IOException e) {
        							e.printStackTrace();
        							}
        		
        						System.out.println("NEW State (ex. CA): ");
        						tokens[5] = m.next();
        		
        						System.out.println("NEW Zipcode: ");
        						tokens[6] = m.next();
        						break;
        						
                			case 4:
        						System.out.println("Member's NEW Phone Number (XXX-XXX-XXXX): ");
        						tokens[7] = m.next();
        						break;
                			case 5:
        						System.out.println("Member NEW Status (Active(A) or Inactive(IA)):  ");
        						tokens[9] = m.next();
        						break;
                			case 6:
                				MemAdmin mem = new MemAdmin(MemID, tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7],tokens[8],tokens[9]);
                                totalMList.add(mem);
                                mResults.addElement(mem);
                        		System.out.println("Updated member information: ");
                        		System.out.println(mem.getFullString());
                        		System.out.println();
                                fileContent.append(mem.getMemId() + "\t");
                                fileContent.append( mem.getFirstName() + "\t");
                                fileContent.append( mem.getLastName() + "\t");
                                fileContent.append(mem.getAdd() + "\t");
                                fileContent.append( mem.getCity() + "\t");
                                fileContent.append(mem.getSt() + "\t");
                                fileContent.append( mem.getZip() + "\t");
                                fileContent.append(mem.getMemPhone() + "\t");
                                fileContent.append( mem.getMemDOB() + "\t");
                                fileContent.append( mem.getMemberStatus() + "\n");
                                break;
                            }
                    	}
                }

                    else {
                    	fileContent.append(strLine);
                        fileContent.append("\n");	
                    	} 
                }                 
                			}           
                        
                    // Now fileContent will have updated content , which you can override into file
                    FileWriter fstreamWrite = new FileWriter("Members.txt");
                    BufferedWriter out = new BufferedWriter(fstreamWrite);
                    out.write(fileContent.toString());
                    out.close();
                    //Close the input stream
                    //in.close();
                } catch (Exception e) {//Catch exception if any
                    System.err.println("Error: " + e.getMessage());
                }
     }

	public static void updateProvider(){
		try {
			System.out.println("Enter the 6-digit Provider Number to update: ");
			Scanner r = new Scanner(System.in);
			String ProNum =  r.next();
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("Providers.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            
            while ((strLine = br.readLine()) != null) {
            	totalPList.remove(strLine);
                String tokens[] = strLine.split("\t");
                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID
                    if (tokens[0].equals(ProNum)) {
                    	System.out.println("Current Provider Information:");
                    	System.out.println(strLine);
                    	System.out.println();
                    	while(Choice4 != 6){
                			System.out.println("What do you want to update?");
                			System.out.println();
                			System.out.println("1. Provider's First Name ");
                			System.out.println("2. Provider's Last Name ");
                			System.out.println("3. Provider's Address");
                			System.out.println("4. Provider's Phone Number ");
                			System.out.println("5. Provider's Status ");
                			System.out.println("6. Exit, and update Provider information");
                			
                			
                			Choice4 = r.nextInt();
                			int ProvNum = Integer.parseInt(tokens[0]);
                			switch(Choice4){
                			case 1:
        						System.out.println("Provider's NEW First Name:");
        						tokens[1] = r.next();
                				break;
                			case 2:
                				System.out.println("Provider's NEW Last Name:");
        						tokens[2] = r.next();
                				break;
                			case 3:
        						System.out.println("Provider's NEW Address:");
        						InputStreamReader input = new InputStreamReader(System.in);
        						BufferedReader reader = new BufferedReader(input);
        						System.out.println("NEW Address:");
        						try {
        							tokens[3] = reader.readLine();
        						} catch (IOException e) {
        							e.printStackTrace();
        						}
        						InputStreamReader input2 = new InputStreamReader(System.in);
        						BufferedReader reader2 = new BufferedReader(input2);
        						System.out.println("NEW City: ");
        						try {
        							tokens[4] = reader2.readLine();
        						} catch (IOException e) {
        							e.printStackTrace();
        							}
        		
        						System.out.println("NEW State (ex. CA): ");
        						tokens[5] = r.next();
        		
        						System.out.println("NEW Zipcode: ");
        						tokens[6] = r.next();
        						break;
        						
                			case 4:
        						System.out.println("Provider's NEW Phone Number (XXX-XXX-XXXX): ");
        						tokens[7] = r.next();
        						break;
                			case 5:
        						System.out.println("Provider's NEW Status (Active(A) or Inactive(IA)):  ");
        						tokens[8] = r.next();
                			case 6:
                				ProAdmin mem = new ProAdmin(ProvNum, tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7],tokens[8]);
                                totalPList.add(mem);
                                mResults.addElement(mem);
                                System.out.println();
                        		System.out.println("Updated Provider information: ");
                        		System.out.println(mem.getFullString());
                        		System.out.println();
                                fileContent.append(mem.getProNum() + "\t");
                                fileContent.append( mem.getFirstName() + "\t");
                                fileContent.append( mem.getLastName() + "\t");
                                fileContent.append(mem.getAdd() + "\t");
                                fileContent.append( mem.getCity() + "\t");
                                fileContent.append(mem.getSt() + "\t");
                                fileContent.append( mem.getZip() + "\t");
                                fileContent.append(mem.getProvPhone() + "\t");
                                fileContent.append( mem.getProviderStatus() + "\n");
                            }
                    	}
                    }
                            else {
                            	fileContent.append(strLine);
                                fileContent.append("\n");	
                            	}                  
                			}           
                        }
                    // Now fileContent will have updated content , which you can override into file
                    FileWriter fstreamWrite = new FileWriter("Providers.txt");
                    BufferedWriter out = new BufferedWriter(fstreamWrite);
                    out.write(fileContent.toString());
                    out.close();
                    //Close the input stream
                    //in.close();
                } catch (Exception e) {//Catch exception if any
                    System.err.println("Error: " + e.getMessage());
                }        	
            }

	public static void lookupMember() throws FileNotFoundException{
		try{ 
			//displayMembers();
			Scanner l = new Scanner(System.in);
			System.out.println("Enter 9-digit Member ID to LookUp:  ");
			
			String LMem =  l.next();
			//int MemNum = Integer.parseInt(LMem);
			
			FileInputStream fstream = new FileInputStream("Members.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			//StringBuilder fileContent = new StringBuilder();
			validMember(LMem);
				
				while ((strLine = br.readLine()) != null) {
					String tokens [] = strLine.split("\t");
				if (tokens.length > 0) {
                // Here tokens[0] will have value of ID
					if (tokens[0].equals(LMem) & tokens[9].equals("A")) {
						System.out.println();
						System.out.println("Member Information: ");
						
						System.out.println(strLine);
						System.out.println();
						System.out.println("Member is Active!");
						break;
					}else if (tokens[0].equals(LMem) & tokens[9].equals("IA")){
						System.out.println();
						System.out.println("Member Information: ");
						System.out.println(strLine);
						System.out.println();
						System.out.println("Member is  Inactive!");	
					}
				}
			}
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
	}
	
	public static void lookupProvider(){
		try{ 
			//displayMembers();
			System.out.println("Enter 9-digit Provider Number to LookUp:  ");
			Scanner lp = new Scanner(System.in);
			String LMem =  lp.next();
			
			FileInputStream fstream = new FileInputStream("Providers.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			//StringBuilder fileContent = new StringBuilder();
			validProvider(LMem);
			while ((strLine = br.readLine()) != null) {
				
				String tokens[] = strLine.split("\t"); 
				if (tokens.length > 0) {
                // Here tokens[0] will have value of ID
					if (tokens[0].equals(LMem) & tokens[8].equals("A")) {
						System.out.println();
						System.out.println("Provider's Information: ");
						System.out.println(strLine);
						System.out.println();
						System.out.println("Provider is Active!");
						break;
					}else if (tokens[0].equals(LMem) & tokens[8].equals("IA")){
						System.out.println();
						System.out.println("Provider's Information: ");
						System.out.println(strLine);
						System.out.println();
						System.out.println("Provider is  Inactive!");	
					}
				}		
			}
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
		//System.out.println("Invalid Provider Num!");
	}
	

	
	public static void memberStatus(String memID){
		for( int i = 0; i < totalMList.size(); i++){
			if (totalMList.get(i).getMemId() == memID){
				totalMList.get(i).getMemberStatus();
			}
		}
	}
	
	public static boolean validMember(String input){
		if(!vMemId.contains(input)){
			System.out.println("Invalid Member Id.  Please try again.");
		}
		return true;
	}
		
	public static void validProvider(String input){
		if(!vProNum.contains(input)){
			System.out.println("Invalid Provider Number.  Please try again.");
		}
	}
		
	

	
	public static void openMember(){
		try{ 
			FileInputStream fstream = new FileInputStream("Members.txt");
	        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	        String strLine;
	        
	        while ((strLine = br.readLine()) != null) {
	        	//System.out.println(strLine);
	        	 String tokens[] = strLine.split("\t"); 
	        	 //ArrayList num = new ArrayList();
	             if (tokens.length > 0) {
	            	 MemID = Integer.parseInt(tokens[0]);
	            	 FName = tokens[1];
	            	 LName = tokens[2];
	            	 MemAdd = tokens[3];
	            	 MemCity = tokens[4];
	            	 MemSt = tokens[5];
	            	 MemZip = tokens[6];
	            	 MemPhone = tokens[7];
	            	 MemDOB = tokens[8];
	            	 MemStatus = tokens[9]; 
	            	 
	            	
	             }
	             MemAdmin mem = new MemAdmin(MemID,FName,LName,MemAdd,MemCity,MemSt,MemZip, MemPhone, MemDOB, MemStatus);
	             totalMList.add(mem);
	             vMemId.add(mem.getMemId().toString());
	            
		}
		}catch (IOException ex){
			ex.printStackTrace();
			}
		}
	
	public static void openProviders(){
		try{ 
			FileInputStream fstream = new FileInputStream("Providers.txt");
	        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	        String strLine;
	        
	        while ((strLine = br.readLine()) != null) {
	        	 String tokens[] = strLine.split("\t"); 
	             if (tokens.length > 0) {
	            	 ProvNum = Integer.parseInt(tokens[0]);
	            	 FPName = tokens[1];
	            	 LPName = tokens[2];
	            	 ProAdd = tokens[3];
	            	 ProCity = tokens[4];
	            	 ProSt = tokens[5];
	            	 ProZip = tokens[6];
	            	 ProPhone = tokens[7];
	            	 ProStatus = tokens[8];
	            	 
	             }
	             ProAdmin pro = new ProAdmin(ProvNum,FPName,LPName,ProAdd,ProCity,ProSt,ProZip, ProPhone, ProStatus);
	             totalPList.add(pro);
	             vProNum.add(pro.getProNum());
		}
		}catch (IOException ex){
			ex.printStackTrace();
			}	
	}
	
	public static void displayProviders(){
		System.out.println();
		System.out.println("List of exsiting Providers: ");
		for( int i = 0; i < totalPList.size(); i++){
			System.out.println(totalPList.get(i).getFullString());
			//System.out.println();
		}
		System.out.println();
	}
	
	public static void displayMembers(){
		System.out.println();
		System.out.println("List of exsiting Members: ");
		for( int i = 0; i < totalMList.size(); i++){
			System.out.println(totalMList.get(i).getFullString());
			
		}
		System.out.println();
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
	}
	
	
}

