package smartVendingMachine;

//import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClass {

	public void serializeObjectToXML(String xmlFileLocation,
			Object objectToSerialize) throws FileNotFoundException {

		if (xmlFileLocation == "") {
			throw new FileNotFoundException();
		}

		FileOutputStream fOStream = new FileOutputStream(xmlFileLocation);
		XMLEncoder encoder = new XMLEncoder(fOStream);
		encoder.writeObject(objectToSerialize);
		encoder.close();

	}

	public Object deserializeXMLToObject(String xmlFileLocation)
			throws FileNotFoundException {

		if (xmlFileLocation == "") {
			throw new FileNotFoundException();
		}

		FileInputStream fIStream = new FileInputStream(xmlFileLocation);
		XMLDecoder decoder = new XMLDecoder(fIStream);
		Object deserializedObject = decoder.readObject();
		decoder.close();

		return deserializedObject;
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Calendar calender = Calendar.getInstance();
		Date dateTime = calender.getTime();
		DateFormat dateFormater = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

		// System.out.println(dateFormater.format(dateTime));

		/*Object[] uc = new Object[1];

		CampusCardUser[] tc = new CampusCardUser[3];
		for (int i = 0; i < tc.length; i++) {
			tc[i] = new CampusCardUser();
		}*/
		
		CampusCardUser tc1 = new CampusCardUser();
		CampusCardUser tc2 = new CampusCardUser();
		CampusCardUser tc3 = new CampusCardUser();
		
		//tc1.setAccountNo("");
		tc1.setCardno("93819701");
		tc1.setPin("1234");
		tc1.setUserName("Dhaval");
		tc1.setGender('M');
		tc1.setFunds(2000);
		tc1.setCalories(7000);

		PurchasedDetails t1 = new PurchasedDetails();
		t1.setCardNo(tc1.getCardno());
		t1.setFoodOutletId("vm1");
		t1.setFoodItemId(101);
		t1.setFoodQuantity(1);
		t1.setFoodItemCalories(180);
		t1.setFoodItemPrice(1.00);
		t1.setFoodPurchasedDateTime(dateFormater.format(dateTime));

		PurchasedDetails t2 = new PurchasedDetails();
		t2.setCardNo(tc1.getCardno());
		t2.setFoodOutletId("vm1");
		t2.setFoodItemId(115);
		t2.setFoodQuantity(1);
		t2.setFoodItemCalories(160);
		t2.setFoodItemPrice(1.00);
		t2.setFoodPurchasedDateTime(dateFormater.format(dateTime));

		PurchasedDetails t3 = new PurchasedDetails("93819701", "vm1", 1, 1, 1500,
				3.00, dateFormater.format(dateTime));

		//tc2.setAccountNo(20);
		tc2.setCardno("93819702");
		tc2.setPin("hyhh");
		tc2.setUserName("Dhaval1");
		tc2.setGender('M');
		tc2.setFunds(2000);
		tc2.setCalories(7000);
		
		tc3.setCardno("83498901");
		tc3.setPin("hyhh");
		tc3.setUserName("Dhaval2");
		tc3.setGender('M');
		tc3.setFunds(2000);
		tc3.setCalories(7000);

		/*
		 * PurchasedDetails t3 = new PurchasedDetails(tc[0].getCardno(),"vm1",
		 * 1, 1, 1500, 3.00); t3.setFoodPurchasedDate(date);
		 * t3.setFoodPurchasedTime(time.getTime());
		 * tc[0].addPurchasedDetails(t3);
		 * 
		 * PurchasedDetails t4 = new PurchasedDetails(tc[0].getCardno(),"vm1",
		 * 3, 3, 3000, 4.79); t4.setFoodPurchasedDate(date);
		 * t4.setFoodPurchasedTime(time.getTime());
		 * tc[0].addPurchasedDetails(t4);
		 * 
		 * 
		 * tc2.setAccountNo(20); tc2.setCardno("00000123456");
		 * tc2.setPin("8562"); tc2.setUserName("Dhaval2");
		 * tc2.setGender('M'); tc2.setFunds(2000); tc2.setCalories(7000);
		 * 
		 * 
		 * PurchasedDetails t5 = new PurchasedDetails(tc[0].getCardno(),"vm1",
		 * 1, 1, 1500, 3.00); t5.setFoodPurchasedDate(date);
		 * t5.setFoodPurchasedTime(time.getTime());
		 * tc[0].addPurchasedDetails(t5);
		 * 
		 * PurchasedDetails t6 = new PurchasedDetails(tc[0].getCardno(),"vm1",
		 * 3, 3, 3000, 4.79); t6.setFoodPurchasedDate(date);
		 * t6.setFoodPurchasedTime(time.getTime());
		 * tc[0].addPurchasedDetails(t6);
		 */

		List<CampusCardUser> Users = new ArrayList<CampusCardUser>();
		Users.add(tc1);
		Users.add(tc2);
		Users.add(tc3);

		List<PurchasedDetails> list = new ArrayList<PurchasedDetails>();
		list.add(t1);
		list.add(t2);
		list.add(t3);

		TestClass serializer = new TestClass();
		String xmlFileLocation = "D:/users.xml";
		String xmlFileLocation1 = "D:/purchaseddetails.xml";

		serializer.serializeObjectToXML(xmlFileLocation, Users);
		serializer.serializeObjectToXML(xmlFileLocation1, list);

		/*List<PurchasedDetails> deserializedObject = new ArrayList<PurchasedDetails>();
		deserializedObject = (List<PurchasedDetails>) serializer
				.deserializeXMLToObject(xmlFileLocation1);

		List<CampusCardUser> deserializedUsers = new ArrayList<CampusCardUser>();
		deserializedUsers = (List<CampusCardUser>) serializer
				.deserializeXMLToObject(xmlFileLocation);*/

		/*Map<String,Integer> test = new HashMap<String, Integer>();
		test.put("Monday", new Integer(1));
		test.put("Monday", new Integer(2));
		System.out.println(test.get("Monday"));
		
		Map<String, Double> test1 = new HashMap<String, Double>();
		test1.put("Monday", new Double(1.1));
		test1.put("Monday", 1.1);
		System.out.println(test1.get("Monday"));
		
		int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		calender = Calendar.getInstance();
		dateTime = calender.getTime();
		dateFormater = new SimpleDateFormat(
				"MM/dd/yyyy hh:mm:ss");
		
		DateFormat dateFormater1 = new SimpleDateFormat(
				"EEEE");
		
		System.out.println(dateFormater.format(dateTime.getTime()- (7*MILLIS_IN_DAY)));
		calender.add(Calendar.DATE, -7);
		System.out.println(dateFormater1.format(calender.getTime()));
		
		calender.set(Calendar.HOUR, 8);
		calender.set(Calendar.MINUTE, 0);
		calender.set(Calendar.SECOND, 0);
		calender.set(Calendar.AM_PM, calender.AM);
		
		System.out.println(calender.getTime());*/
	}
	

	  public static void math() {
	    
	    int i = 7;
	    int j = -9;
	    double x = 72.3;
	    double y = 0.60;
	  
	    System.out.println("i is " + i);     
	    System.out.println("j is " + j);
	    System.out.println("x is " + x);     
	    System.out.println("y is " + y);
	     
	    // The absolute value of a number is equal to 
	    // the number if the number is positive or 
	    // zero and equal to the negative of the number 
	    // if the number is negative.
	 
	    System.out.println("|" + i + "| is " + Math.abs(i));     
	    System.out.println("|" + j + "| is " + Math.abs(j));
	    System.out.println("|" + x + "| is " + Math.abs(x));     
	    System.out.println("|" + y + "| is " + Math.abs(y));

	    // Truncating and Rounding functions
	 
	    // You can round off a floating point number  
	    // to the nearest integer with round()
	     System.out.println(x + " is approximately " + Math.round(x));     
	     System.out.println(y + " is approximately " + Math.round(y));     

	    // The "ceiling" of a number is the   
	    // smallest integer greater than or equal to
	    // the number. Every integer is its own 
	    // ceiling.
	     System.out.println("The ceiling of " + i + " is " + Math.ceil(i));     
	     System.out.println("The ceiling of " + j + " is " + Math.ceil(j));
	     System.out.println("The ceiling of " + x + " is " + Math.ceil(x));     
	     System.out.println("The ceiling of " + y + " is " + Math.ceil(y));

	     // The "floor" of a number is the largest  
	     // integer less than or equal to the number.
	     // Every integer is its own floor.
	     System.out.println("The floor of " + i + " is " + Math.floor(i));     
	     System.out.println("The floor of " + j + " is " + Math.floor(j));
	     System.out.println("The floor of " + x + " is " + Math.floor(x));     
	     System.out.println("The floor of " + y + " is " + Math.floor(y));

	     // Comparison operators

	     // min() returns the smaller of the two arguments you pass it
	     System.out.println("min(" + i + "," + j + ") is " + Math.min(i,j));     
	     System.out.println("min(" + x + "," + y + ") is " + Math.min(x,y));     
	     System.out.println("min(" + i + "," + x + ") is " + Math.min(i,x));     
	     System.out.println("min(" + y + "," + j + ") is " + Math.min(y,j));     

	     // There's a corresponding max() method 
	     // that returns the larger of two numbers 
	     System.out.println("max(" + i + "," + j + ") is " + Math.max(i,j));     
	     System.out.println("max(" + x + "," + y + ") is " + Math.max(x,y));     
	     System.out.println("max(" + i + "," + x + ") is " + Math.max(i,x));     
	     System.out.println("max(" + y + "," + j + ") is " + Math.max(y,j));     
	      
	     // The Math library defines a couple 
	     // of useful constants:
	     System.out.println("Pi is " + Math.PI);     
	     System.out.println("e is " + Math.E);       
	     // Trigonometric methods
	    // All arguments are given in radians
	 
	    // Convert a 45 degree angle to radians
	    double angle = 45.0 * 2.0 * Math.PI/360.0;
	    System.out.println("cos(" + angle + ") is " + Math.cos(angle));     
	    System.out.println("sin(" + angle + ") is " + Math.sin(angle));     
	    
	     // Inverse Trigonometric methods
	     // All values are returned as radians
	   
	    double value = 0.707;

	    System.out.println("acos(" + value + ") is " + Math.acos(value));     
	    System.out.println("asin(" + value + ") is " + Math.asin(value));     
	    System.out.println("atan(" + value + ") is " + Math.atan(value));     

	    // Exponential and Logarithmic Methods
	  
	    // exp(a) returns e (2.71828...) raised 
	    // to the power of a.   
	    System.out.println("exp(1.0) is "  + Math.exp(1.0));
	    System.out.println("exp(10.0) is " + Math.exp(10.0));
	    System.out.println("exp(0.0) is "  +  Math.exp(0.0));

	    // log(a) returns  the natural 
	    // logarithm (base e) of a. 
	    System.out.println("log(1.0) is "    + Math.log(1.0));
	    System.out.println("log(10.0) is "   + Math.log(10.0));
	    System.out.println("log(Math.E) is " + Math.log(Math.E));

	    // pow(x, y) returns the x raised 
	    // to the yth power.
	    System.out.println("pow(2.0, 2.0) is "  + Math.pow(2.0,2.0));
	    System.out.println("pow(10.0, 3.5) is " + Math.pow(10.0,3.5));
	    System.out.println("pow(8, -1) is "     + Math.pow(8,-1));

	    // sqrt(x) returns the square root of x.
	    for (i=0; i < 10; i++) {
	      System.out.println(
	       "The square root of " + i + " is " + Math.sqrt(i));
	    }
	    
	  }
}




