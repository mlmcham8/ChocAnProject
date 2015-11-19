public class ProAdmin {
	
	int ProvNum;
	String FName;
	String LName;
	String ProAdd;
	String ProCity;
	String ProSt;
	String ProZip;
	String ProPhone;
	String ProStatus;
	
	public ProAdmin(int num, String fname, String lname, String padd, String pcity, String pst, String pzip, String pphone, String pstatus){
		
		ProvNum = num;
		FName = fname;
		LName = lname;
		ProAdd = padd;
		ProCity = pcity;
		ProSt = pst;
		ProZip = pzip;
		ProPhone = pphone;
		ProStatus = pstatus;
		
	}
	
	public String getFirstName(){ return FName;}
	public String getLastName() { return LName;}
	public String getAdd() {return ProAdd;}
	public String getCity() {return ProCity;}
	public String getSt() {return ProSt;}
	public String getZip() {return ProZip;}
	//public String getPhone() {return ProPhone;}
	
	public String getProNum() { return String.format("%06d", ProvNum);}
	
	public String getProvName() { return (FName + " " + LName + "       ");}
	
	public String getProvAdd() {return (ProAdd + " " + ProCity + " "+ ProSt+ ", "+ ProZip);}
	
	public String getProvPhone() { return ProPhone;}
	
	public String getProviderStatus(){ return ProStatus; }
	
	public String getFullString() {
		String formatStr = "%06d %-15s %-15s %-15s %-15s";
		return String.format(formatStr, ProvNum, getProvName(), getProvAdd(), ProPhone, getProviderStatus()); }

}

