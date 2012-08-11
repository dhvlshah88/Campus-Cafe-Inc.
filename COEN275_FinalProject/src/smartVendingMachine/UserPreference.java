/**
 * 
 */
package smartVendingMachine;

/**
 * @author ADS Team
 *
 */
public class UserPreference {

	private int dailyCalories;
	private int caloriesSpent;
	private double monthlyFunds;
	private double fundsSpent;
	
	/**
	 * 
	 */
	public UserPreference() {
	}
	
	public void setCalories(int dailyCalories){
		this.dailyCalories = dailyCalories;
	}
	
	public int getCalories(){
		return dailyCalories;
	}
	
	public void setFunds(double monthlyFunds){
		this.monthlyFunds = monthlyFunds;
	}
	
	public double getFunds(){
		return monthlyFunds;
	}
	
	public void setCaloriesSpent(int caloriesSpent) {
		this.caloriesSpent = caloriesSpent;
	}

	public int getCaloriesSpent() {
		return caloriesSpent;
	}
	
	public void setFundsSpent(double fundsSpent){
		this.fundsSpent = fundsSpent;
	}
		
	public double getFundsSpent() {
		return fundsSpent;
	}

}
