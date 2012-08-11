/**
 * 
 */
package smartVendingMachine;

/**
 * @author ADS Team
 *
 */
public class DietoryProfile {

	/**
	 * 
	 */
	private int caloriesLeft;
	private CampusCardUser cardHolder;
	
	public DietoryProfile(CampusCardUser cardholder) {
		this.cardHolder = cardholder;
	}

	
	//This functions calculates the calories left after calories consumed
	public int calculateCaloriesLeft(){
		caloriesLeft = cardHolder.getCalories() - cardHolder.getCaloriesSpent();
			return caloriesLeft;
		}

}
