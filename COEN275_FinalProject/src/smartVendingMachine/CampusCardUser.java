/**
 * 
 */
package smartVendingMachine;

import java.io.Serializable;
/*import java.util.ArrayList;
import java.util.Collections;
import java.util.List;*/

/**
 * @author ADS Team
 * 
 */
public class CampusCardUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String familyID="";
	private String accountNo="";
	private String userName="";
	private String cardNo="";
	private String pin="";
	private char gender;
	transient private int length = 0;
	
	private UserPreference preferences = new UserPreference();
	/*private PurchasedDetails[] purchasedDetails = new PurchasedDetails[100];
	private static int index = 0;
	private List<PurchasedDetails> purchasedDetails1 = new ArrayList<PurchasedDetails>();*/

	/**
	 * 
	 */
	public CampusCardUser() {
		
	}

	private void setFamilyId(String familyID){
		this.familyID = familyID;
	}
	
	public String getFamilyId(){
		return familyID;
	}
	
	private void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setCardno(String cardNo) {
		this.cardNo = cardNo;
		length = cardNo.length();
		setAccountNo(cardNo.substring(0, length>0? length-2:0));
		length = this.accountNo.length();
		setFamilyId(cardNo.substring(length, cardNo.length()));
	}

	public String getCardno() {
		return cardNo;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPin(){
		return pin;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getGender() {
		return gender;
	}
	
	
	public void setCalories(int dailyCalories) {
		preferences.setCalories(dailyCalories);
	}

	public int getCalories() {
		return preferences.getCalories();
	}

	public void setFunds(double monthlyFunds) {
		preferences.setFunds(monthlyFunds);
	}

	public double getFunds() {
		return preferences.getFunds();
	}

	public void setFundsSpent(double fundsSpent) {
		preferences.setFundsSpent(fundsSpent);
	}

	public double getFundsSpent() {
		return preferences.getFundsSpent();
	}
	
	
	public void setCaloriesSpent(int caloriesSpent) {
		preferences.setCaloriesSpent(caloriesSpent);
	}

	public int getCaloriesSpent() {
		return preferences.getCaloriesSpent();
	}

/*	public void addPurchasedDetails1(PurchasedDetails transactions) {
		purchasedDetails1.add(transactions);
	}

	public List<PurchasedDetails> getPurchasedDetails1() {
		List<PurchasedDetails> copyOfPurchaseDtls = new ArrayList<PurchasedDetails>();
		Collections.copy(copyOfPurchaseDtls, purchasedDetails1);
		return copyOfPurchaseDtls;
	}
	
	public void addPurchasedDetails(PurchasedDetails purchasedDetails) {
		this.purchasedDetails[index++] = purchasedDetails;
	}
	
	public PurchasedDetails[] getPurchasedDetails() {
		PurchasedDetails[] copyOfPurchasedDetails = new PurchasedDetails[100];
		//Collections.copy(copyOfPurchasedDetails[], purchasedDetails[]);
		copyOfPurchasedDetails = purchasedDetails;
		return copyOfPurchasedDetails;
	}*/
}
