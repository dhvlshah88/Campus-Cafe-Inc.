/**
 * 
 */
package smartVendingMachine;

/**
 * @author ADS Team
 *
 */
public class ExpenseProfile {

	private double fundsLeft;
	private CampusCardUser cardHolder;
	
	/**
	 * This constructor initializes CampusCardUser object to ExpenseProfile Object.
	 */
	public ExpenseProfile(CampusCardUser cardholder) {
		this.cardHolder = cardholder;
	}
		
	/*
	 * This functions calculates funds left.
	 */
	public double calculateFundsLeft(){
		fundsLeft = cardHolder.getFunds() - cardHolder.getFundsSpent();
		 return fundsLeft;
	}
	
	


}
