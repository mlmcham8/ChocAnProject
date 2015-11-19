import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Report {



	public static void generateMemberReport() throws IOException {
		String memberName;
		String memberNumber;
		String memberStreet;
		String memberCity;
		String memberState;
		String memberZip;

		String dateServiced = "";
		String providerName = "";
		String serviceName = "";
		ArrayList <String> service = new ArrayList <String>();

		FileInputStream f = new FileInputStream("Members.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(f));
		String currentLine;

		StringBuilder fileContent = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the memberID to generate a report: ");
		String userinput = input.nextLine().trim(); //member report to generate

		FileInputStream g = new FileInputStream("serviceRecords.txt");
		BufferedReader brg = new BufferedReader(new InputStreamReader(g));

		
		while ((currentLine = br.readLine()) != null) { //reads members.txt
			String tokens[] = currentLine.split("\t");
			memberNumber = tokens[0];
			memberName = tokens[2] + ", " + tokens[1];
			memberStreet = tokens[3];
			memberCity = tokens[4];
			memberState = tokens[5];
			memberZip = tokens[6];
			//finished reading the first member's information

			String lineRecords;
			int i = 0;

			fileContent = new StringBuilder(); //test
			fileContent.append(memberNumber + "\n");
			fileContent.append(memberName + "\n");
			fileContent.append(memberStreet + "\n");
			fileContent.append(memberCity + "\n");
			fileContent.append(memberState + "\n");
			fileContent.append(memberZip + "\n");

			while ((lineRecords = brg.readLine()) != null) {
				
				String records[] = lineRecords.split("\t");
				System.out.println("member number = " +memberNumber);
				System.out.println("userinput = " +userinput);
				if (memberNumber.equals(records[0]) && (userinput.equals(memberNumber))) {
					System.out.println("processing member report");
					dateServiced = records[3]; //may be wrong index
					providerName = records[5];
					serviceName = records[6];
					System.out.println("dateserviced: " + dateServiced);
					System.out.println("providerName: " + providerName);
					System.out.println("serviceName: " + serviceName);
					service.add(i, dateServiced+"\t"+providerName+"\t"+"\t"+serviceName+"\n"); //array to store a multiple service records
					fileContent.append(dateServiced+"\t"+providerName+"\t"+"\t"+serviceName+"\n");
				}
				//for (int j = 0; j < service.size(); j++) { //iteratively add service records
					//fileContent.append(service.get(j));

				//} //finished acquiring info for a single report
			} //individual member's contents written
		} //done traversing members.txt
		FileWriter fstreamWrite = new FileWriter("testMemberReport.txt");
		BufferedWriter out = new BufferedWriter(fstreamWrite);
		System.out.println(fileContent.toString());
		out.write(fileContent.toString());
		out.close();
	}//end generateMemberReport

	public static void generateProviderReport() throws IOException {
		//TODO total fees

		String providerName;
		String providerNumber;
		String streetAddress;
		String city;
		String state;
		String zip;

		int numberOfConsultations = 0;
		ArrayList <String> service = new ArrayList <String>();

		FileInputStream f = new FileInputStream("Providers.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(f));
		String  currentLine;

		StringBuilder fileContent = null;
		Scanner input = new Scanner(System.in);
		//TODO insert way to do just one provider

		while ((currentLine = br.readLine()) != null) { //reads one line of providers
			numberOfConsultations = 0;

			String tokens[] = currentLine.split("\t");
			providerNumber = tokens[0];
			providerName = tokens[2] + ", " + tokens[1];
			streetAddress = tokens[3];
			city = tokens[4];
			state = tokens[5];
			zip = tokens[6];
			//finished reading the first provider's info

			FileInputStream g = new FileInputStream("serviceRecords.txt");
			BufferedReader brg = new BufferedReader(new InputStreamReader(g));

			String lineRecords; //one line from serviceRecords.txt
			int i = 0;

			fileContent = new StringBuilder();
			fileContent.append(providerNumber + "\n");
			fileContent.append(providerName + "\n");
			fileContent.append(streetAddress + "\n");
			fileContent.append(city + "\n");
			fileContent.append(state + "\n");
			fileContent.append(zip + "\n");

			while ((lineRecords = brg.readLine()) != null) {
				String records[] = lineRecords.split("\t");

				//if (providerNumber.equals(records[0])) { //&& (userinput.equals(providerNumber))
					providerName = records[5];
					numberOfConsultations++;
					service.add(i, providerName+"\t"+providerNumber+"\t"+streetAddress+"\t"
							+city+"\t"+state+"\t"+zip+"\n");
					fileContent.append(providerName+"\t"+providerNumber+"\t"+streetAddress+"\t"
							+city+"\t"+state+"\t"+zip+"\n");
					i++;
				//}
				for (int j = 0; j < service.size(); j++) {
					//fileContent.append(service.get(j));
				}//finished acquiring info for a single report
			}//finished provider's contents written
		}//done traversing providers.txt
		FileWriter fStreamWrite = new FileWriter("testProviderReport");
		BufferedWriter out = new BufferedWriter(fStreamWrite);
		System.out.println(fileContent.toString());
		out.write(fileContent.toString());
		out.close();
	}//end generateProviderReport

	public static void generateSummaryReport() throws IOException {
		String providerName;
		ArrayList<String[]> providerList = new ArrayList<String[]>();//list of providers to be paid
		ArrayList proPaid = new ArrayList(); //provider numbers in totaledFees.txt
		ArrayList<String[]> proList = new ArrayList<String[]>(); //list of providers in providers.txt
		ArrayList providerNumList = new ArrayList();//list of provider numbers
		int consultations = 0;//number of consultations
		int providerFee;//total fee for provider
		int totalProviders; //total number of providers who provided services
		int totalConsultations;//total number of consultations
		int overallFee;//overall fee total
		int counter = 0;
		StringBuilder fileContent;
		String providerNumber;
		
		fileContent = new StringBuilder();


		////////////////////OPEN PROVIDER.TXT ////////////////////////////////////

		File fileObj = new File("Providers.txt");
		Scanner f = new Scanner(fileObj);

		String line1 = f.nextLine().trim();
		//created the empty list of services 		
		proList.add(line1.split("\t"));
		while (f.hasNext()) {
			line1 = f.nextLine().trim();
			proList.add(line1.split("\t"));
		}
		for (int a = 0; a < proList.size(); a++){ 
			providerNumList.add(proList.get(a)[0]);
		}

		///////////////OPEN TOTALfEES.TXT ///////////////////////

		File fileObj1 = new File("totaledFees.txt");
		Scanner fi = new Scanner(fileObj1);
		String line = fi.nextLine().trim();
		ArrayList proNum;
		//		System.out.println("Please enter your 6-digit provider number: ");
		proNum = providerNumList;

		providerList.add(line.split("\t"));
		//reads thru the rest of the file and adds the services 
		while(fi.hasNext()){
			line = fi.nextLine().trim();
			providerList.add(line.split("\t"));
		}
		//System.out.println(providerList);
		for (int b = 0; b < providerList.size(); b++){
			proPaid.add(providerList.get(b)[0]);
		}
		//System.out.println(proPaid);

		for (int q = 0;q < providerNumList.size();q++){
			//for each provider, q = a provider
			counter = 0;
			for (int r = 0;r <proPaid.size();r++) {
				//for each serviceRecord, r = a record
				//System.out.println("q = " + providerList.get(q)[0].toString() +", r = "+proPaid.get(r));
				if (providerNumList.get(q).equals(proPaid.get(r))){
					//System.out.println(providerNumList.get(q) +"is equal to "+proPaid.get(r));
					counter++;
				} //stop if
			} //end for loop of serviceRecord
			//counter does things here
			fileContent.append(providerNumList.get(q)+"\t Number of consultations: "+counter+" for a total of "+providerList.get(q)[2]+"\n");
			//System.out.println(providerList.get(q)[0]+"is the provider number");
			//System.out.println(providerList.get(q)[2]+"is the fee");
			//System.out.println(providerList.get(q)[1]+"is the date\n");
		}
		FileWriter fStreamWrite = new FileWriter("testSummaryReport.txt");
		BufferedWriter out = new BufferedWriter(fStreamWrite);
		out.write(fileContent.toString());
		out.close();
	}	

//	public static void main(String[] args) throws IOException {
//		generateMemberReport();
//		generateProviderReport();
//		generateSummaryReport();
//	}
//	
//	public String getEFTData(EFTData e){
//		//TODO this
//		return "";
//	
//	}
//}
	
}
