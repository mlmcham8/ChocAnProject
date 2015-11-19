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


public class Provider {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Please pick an option:" + '\n'
							+ "A) Request a Provider Directory" + '\n' 
							+"B) Provide Service/Make Record" + '\n'
							+ "C) Total Fees");
		String userinput = input.nextLine();
		if (userinput.equals("A")){
			String email;
			System.out.println("Please enter your email: ");	
			email = input.next();
			System.out.println("An email containing the provider directory has been sent to  " + email); 
			//sends email to the given email containing the provider directory 
			
		}
		if (userinput.equals("B")){
			
			//open file
			File fileObj = new File("serviceCodeFees.txt");
			Scanner file = new Scanner(fileObj);
			
			//read a single line in
			String line = file.nextLine().trim();
			
			//created the empty list of services 
			ArrayList <String[]> services = new ArrayList<String[]>(); 
			ArrayList vCodes = new ArrayList();
			
			//put a service into the service list
			services.add(line.split(","));
			
			//reads thru the rest of the file and adds the services 
			while(file.hasNext()){
				line = file.nextLine().trim();
				services.add(line.split(","));
			}
			for(int i = 0; i < services.size(); i++){
				vCodes.add(services.get(i)[0]);
			}
			//System.out.println(vCodes);
			
			String serviceCode; 
			//while(true){
				System.out.println("Please enter the service code: ");
				serviceCode = input.next();
				if(vCodes.contains(serviceCode)){
					//loop thru the services list
					for (int i=0; i < services.size(); i++){
						//check if service code is valid
						//System.out.println( serviceCode + "," + services.get(i)[0]);
						if (serviceCode.equals(services.get(i)[0])){
							//print the service name and fee
							System.out.println("Service Name:  " + services.get(i)[1]);
							System.out.println("Is this the correct service? Y/N ");
							String userinput2 = input.next();
							if(userinput2.equals("N")){
								//System.out.println("TEST");
								break;
							}
							if(userinput2.equals("Y")){
					
								String current_date;
								System.out.println("Please enter the current date (mm/dd/yyyy) : ");
								current_date = input.next();
								
								String service_date;
								System.out.println("Please enter the date the service was provided (mm/dd/yyyy) : ");
								service_date = input.next();
								
								String member_first;
								System.out.println("Please enter the member's first name: ");
								member_first = input.next();
								
								String member_last;
								System.out.println("Please enter the member's last name: ");
								member_last = input.next();
								
								String member_ID;
								System.out.println("Please enter the member's 9-digit ID number: ");
								member_ID = input.next();
								
										System.out.println("Member ID:  " + member_ID + '\n'
														+ "Service Code: " + services.get(i)[0]  + '\n'
														+ "Service Name:  " + services.get(i)[1]  + '\n'
														+ "Service Fee:  " + services.get(i)[2]   + '\n'
														+ "Current Date:  " + current_date +  '\n'
														+ "Service Date:  " + service_date + '\n'
														+"First name:  " + member_first + '\n' 
														+"Last Name  "+ member_last + '\n'
														+ "Is this information correct? Y/N ");
														String userinput3 = input.next();
														if(userinput3.equals("Y")){
															
	
															try{
															BufferedWriter out = new BufferedWriter(new FileWriter("serviceRecords.txt", true));
															out.write(services.get(i)[0] + "\t" 
															    			+ services.get(i)[1] + "\t" 
															    			+ services.get(i)[2] + "\t" 
															    			+ current_date + "\t" 
															    			+ service_date + "\t"
															    			+ member_first + "\t"
															    			+ member_last + "\t"
															    			+ member_ID + '\n');
															out.close();
															//out = new BufferedWriter(new FileWriter("serviceRecord.txt", true));
															//out.close();
															//BufferedReader in = new BufferedReader(new FileReader("serviceRecords.txt"));
															//String str;
														//	while ((str = in.readLine()) != null){
																//System.out.println(str);
															//}
															System.out.println("Your service record has been recorded!");
															//in.close();
															
														}
														      catch (IOException e) {
														         System.out.println("exception occurred"+ e);
														      }break;
														}
															if(userinput3.equals("N")){
																//System.out.println("TEST");
																break;
															}
							} //if Y
							
						} //if valid
					//}	
					}
				} //if contains
				else{
					System.out.println("Service code invlaid. Please try again.");
				}
				//} //while1
			
		}	//if B
		
		if (userinput.equals("C")){
			
			//open file
			File fileObj = new File("serviceRecord.txt");
			Scanner f = new Scanner(fileObj);
			
			//read a single line in
			String line = f.nextLine().trim();
			
			//created the empty list of services 
			ArrayList <String[]> fees = new ArrayList<String[]>(); 
			
			//put a service into the service list
			fees.add(line.split(","));
			
			//reads thru the rest of the file and adds the services 
			while(f.hasNext()){
				line = f.nextLine().trim();
				fees.add(line.split(","));
			}
			
			//String serviceFee; 
			//loop thru the fees list
			int sum = 0;
			for (int i=0; i < fees.size(); i++){
				//check if service code is valid
				//System.out.println( fees.get(i)[2]);
				sum += Integer.parseInt(fees.get(i)[2]);
				//if (serviceCode.equals(services.get(i)[0]))
			}
			String currentDate;
			System.out.println("Please enter the current date (mm/dd/yyyy) : ");
			currentDate = input.next();
			
			try{
				BufferedWriter out = new BufferedWriter(new FileWriter("totaledFees.txt", true));
				out.write(currentDate + " \t" + sum + '\n');
				out.close();
				BufferedReader in = new BufferedReader(new FileReader("totaledFees.txt"));
//				String str;
//				while ((str = in.readLine()) != null){
//					System.out.println(str);
//				}
				System.out.println("Your total has been saved!" + "\n" + "Open the file 'totaledFees.txt' to view this and previous totaled service fees by date.");
				in.close();
			}
			      catch (IOException e) {
			         System.out.println("exception occurred"+ e);
			      }
			}
	}
}




