public class MemAdmin {
	
	
	int MemID;
	String FName;
	String LName;
	String MemAdd;
	String MemCity;
	String MemSt;
	String MemZip;
	String MemPhone;
	String MemDOB;
	String MemStatus;
	
	
	public MemAdmin(int id, String fname, String lname, String madd, String mcity, String mst, String mzip, String mphone, String mdob, String memstatus ){
			
			MemID = id;
			FName = fname;
			LName = lname;
			MemAdd = madd;
			MemCity = mcity;
			MemSt = mst;
			MemZip = mzip;
			MemPhone = mphone;
			MemDOB = mdob;
			MemStatus = memstatus;
	}
	
	public String getMemId() { return String.format("%09d", MemID);}  
	
	public String getMemName() { return (FName + " " + LName + " ");}
	
	public String getFirstName() {return FName;}
	public String getLastName() {return LName;}
	
	public String getAdd() {return MemAdd;}
	public String getCity() {return MemCity;}
	public String getSt() {return MemSt;}
	public String getZip() {return MemZip;}
	
	public String getMemAdd() {return (MemAdd + " " + MemCity + " "+ MemSt+ ", "+ MemZip);}
	
	public String getMemPhone() { return MemPhone;}
	
	public String getMemDOB() { return MemDOB; }
	
	public String getMemberStatus(){ return MemStatus;}
		
	
	
	public String getFullString() {
		String formatStr = "%09d %-15s %-15s %-15s %-15s %-15s";
		return String.format(formatStr, MemID, getMemName(),  getMemAdd(), MemPhone, MemDOB, getMemberStatus());
		
	}
	

}


