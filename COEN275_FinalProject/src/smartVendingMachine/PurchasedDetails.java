/**
 * 
 */
package smartVendingMachine;

import java.io.Serializable;

/**
 * @author ADS Team
 * 
 */
public class PurchasedDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String cardNo;
	private String foodOutletId;
	private int foodItemId;
	private int foodQuantity;
	private int foodItemCalories;
	private double foodItemPrice;
	private String purchasedDateTime;

	/**
	 * 
	 */	
	public PurchasedDetails(){
		
	}

	public PurchasedDetails(String cardNo, String foodOutletId, int foodItemId,
			int foodQuantity, int foodItemCalories, double foodItemPrice,
			String purchasedDateTime) {
		this.cardNo = cardNo;
		this.foodOutletId = foodOutletId;
		this.foodItemId = foodItemId;
		this.foodQuantity = foodQuantity;
		this.foodItemCalories = foodItemCalories;
		this.foodItemPrice = foodItemPrice;
		this.purchasedDateTime = purchasedDateTime;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setFoodOutletId(String foodOutletId) {
		this.foodOutletId = foodOutletId;
	}
	
	public String getFoodOutletId() {
		return foodOutletId;
	}

	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}

	public int getFoodItemId() {
		return foodItemId;
	}
	
	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}
	
	public void setFoodItemCalories(int foodItemCalories) {
		this.foodItemCalories = foodItemCalories;
	}

	public int getFoodItemCalories() {
		return foodItemCalories;
	}

	public void setFoodItemPrice(double foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}
	
	public double getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodPurchasedDateTime(String purchasedDateTime) {
		this.purchasedDateTime = purchasedDateTime;
	}
	
	public String getFoodPurchasedDateTime() {
		return purchasedDateTime;
	}

	/*public void setFoodPurchasedTime(Date purchasedTime) {
		this.purchasedDateTime = purchasedTime;
	}*/

/*	public void setFoodPurchasedDate(Date purchasedDateTime) {
		this.purchasedDateTime = dateFormat.format(purchasedDateTime);
	}

	public void setFoodPurchasedTime(Date purchasedTime) {
		this.purchasedDateTime = purchasedTime.toString();
	}
*/
}
