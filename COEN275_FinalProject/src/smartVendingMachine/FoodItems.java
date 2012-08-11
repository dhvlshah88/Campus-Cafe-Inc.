/**
 * 
 */
package smartVendingMachine;

/*import javax.swing.JButton;*/

/**
 * @author ADS Team
 * 
 */
public class FoodItems{

	private String outletId;
	private int id;
	private String name;
	private int quantity;
	private double price;
	private int calories;
	private String description;

	/* private String imageLocation; */

	/*public FoodItems() {
		super();
		//this(outletId, id, name, quantity, price, calories);
	}*/

	/**
	 * 
	 */
	public FoodItems(){
		
	}
	
	public FoodItems(String outletId, int id, String name, int quantity,
			double price, int calories, String description) {
		this.outletId = outletId;
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.calories = calories;
		this.description = description;
	}

	public void setOutletId(String outletId) {
		this.outletId = outletId;
	}

	public String getOutletId() {
		return outletId;
	}

	public void setFoodId(int id) {
		this.id = id;
	}

	public int getFoodId() {
		return id;
	}

	public void setFoodName(String name) {
		this.name = name;
	}

	public String getFoodName() {
		return name;
	}

	public void setFoodQty(int quantity) {
		this.quantity = quantity;
	}

	public int getFoodQty() {
		return quantity;
	}

	public void setFoodPrice(double price) {
		this.price = price;
	}

	public double getFoodPrice() {
		return price;
	}

	public void setFoodCalories(int calories) {
		this.calories = calories;
	}

	public int getFoodCalories() {
		return calories;
	}

	public void setFoodDesc(String description) {
		this.description = description;
	}

	public String getFoodDesc() {
		return description;
	}


}
