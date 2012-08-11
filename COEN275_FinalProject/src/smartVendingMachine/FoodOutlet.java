/**
 * 
 */
package smartVendingMachine;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ashwini
 *
 */
public class FoodOutlet {

	private String outletId;
	private String outletName;
	private String address;
	/*private Date startTime;
	private Date endTime;*/
	//private FoodItems[] foodItems;
	private Map<String, String> distMap = new LinkedHashMap<String, String>();
	
	/**
	 * 
	 */
	public FoodOutlet() {	
		setDistance();
	}
	
	public FoodOutlet(String outletId, String outletName, String address) {
		this.outletId=outletId;
		this.outletName=outletName;
		this.address = address;
		/*this.startTime=startTime;
		this.endTime=endTime;
		*/
		setDistance();
	}
	
	
	public void setOutletID(String outletId){
		this.outletId = outletId;
	}
	
	public void setOutletName(String outletName){
		this.outletName = outletName;
	}

	public void setOutletAdd(String address){
		this.address = address;
	}
	
	/*public void setStartTime(Date startTime){
		this.startTime = startTime;
	}
	
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}*/

	public String getOutletID(){
		return outletId;
	}
	
	public String getOutletName(){
		return outletName;
	}

	public String getOutletAdd(){
		return address;
	}
	
	/*public Date getStartTime(){
		return startTime;
	}
	
	public Date getEndTime(){
		return endTime;
	}*/
	
	public String getDistance(String outletId){
		return distMap.get(outletId);
	}
	
	private void setDistance(){
		distMap.put("vm2", "0.7");
		distMap.put("vm3", "0.5");
		distMap.put("c1", "0.1");
		distMap.put("c2", "0.1");
		distMap.put("fs1", "0.9");
	}
}
