import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OperatorTest extends TestCase {
	
	//@Before
	//String inputData = "user input data";
	//System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
	

	/*
		@Test
		public void testAddMember() {
			OperatorTest myUnit = new OperatorTest();

			String[] expectedArray = {"000000001"+"\t"+"Madison"+"\t"+"McHam"+"\t"+"919 Greenboro ave"+"\t"+"Tucaloosa"+"\t"+"AL"+"35401"+"\t"+"949-903-2796"+"\t"+"02/15/1992"+"A"};

			String[] resultArray = myUnit.AddMember();

			assertArrayEquals(expectedArray, resultArray);
		}*/
	@Test	
	public void testMember() throws Exception {
		//MemAdmin mem = new MemAdmin(000000001, "Madison", "McHam", "2420 First ave");
		MemAdmin m = new MemAdmin(1, "Madison","McHam","919 Greensboro ave","Tucaloosa","AL","35401","949-903-2796","02/15/1992","A"); 
		
		//Operator.AddMember();
		assertEquals("000000001", m.getMemId());
		assertEquals("Madison", m.getFirstName());
		assertEquals("McHam", m.getLastName());
		assertEquals("919 Greensboro ave", m.getAdd());
		assertEquals("Tucaloosa", m.getCity());
		assertEquals("AL", m.getSt());
		assertEquals("35401", m.getZip());
		assertEquals("949-903-2796", m.getMemPhone());
		assertEquals("02/15/1992", m.getMemDOB());
		assertEquals("A", m.getMemberStatus());
		//m.MemStatus = "A";
		
		//assertEquals("000000001"+"\t"+"Madison"+"\t"+"McHam"+"\t"+"919 Greenboro ave"+"\t"+"Tucaloosa"+"\t"+"AL"+"35401"+"\t"+"949-903-2796"+"\t"+"02/15/1992"+"A");
		
	}
	@Test 
	public void testProvider(){
		ProAdmin p = new ProAdmin(1, "Madison","McHam","919 Greensboro ave","Tucaloosa","AL","35401","949-903-2796","A");
		assertEquals("000001", p.getProNum());
		assertEquals("Madison", p.getFirstName());
		assertEquals("McHam", p.getLastName());
		assertEquals("919 Greensboro ave", p.getAdd());
		assertEquals("Tucaloosa", p.getCity());
		assertEquals("AL", p.getSt());
		assertEquals("35401", p.getZip());
		assertEquals("949-903-2796", p.getProvPhone());
	
		assertEquals("A", p.getProviderStatus());
	}
	//public void testUpdate(){
	//	Operator o = new Operator();
	//	o.updateMember();
	//	
	//	MemAdmin m = new MemAdmin(1, "Madison","McHam","919 Greensboro ave","Tucaloosa","AL","35401","949-903-2796","02/15/1992","A");
		
	//}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		//Operator.AddMember();
		//Operator.AddProvider();
		fail("Not yet implemented");
	}

}
