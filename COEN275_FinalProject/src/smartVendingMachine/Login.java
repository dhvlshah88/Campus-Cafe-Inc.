package smartVendingMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Login {
	
	private Map<String, String> credentialMap = new HashMap<String, String>();
	private List<CampusCardUser> users = new ArrayList<CampusCardUser>();
	private Iterator<CampusCardUser> iterator;
		
	public Login(List<CampusCardUser> users) {
		//Collections.copy(this.users, users);	
		iterator = users.iterator();
		while(iterator.hasNext()){
			CampusCardUser singleUser = iterator.next();
			credentialMap.put(singleUser.getCardno(), singleUser.getPin());
		}
	}
	
	public int authenticateUser(String cardNo, String pin){
		
		if(credentialMap.get(cardNo)== null){
			// 2 denotes error number which is returned if the card number is not valid
			return 2; 
		}
		
		if(!credentialMap.get(cardNo).equals(pin)){
			// 3 denotes error number which is returned if the pin is not valid
			return 3; 
		}
		
		// 1 denotes successful authentication.
		return 1; 
	}
	
	public CampusCardUser getValidUser(List<CampusCardUser> users, String validCardNo){
		CampusCardUser validUser = new CampusCardUser();
	    iterator = users.iterator();
		while(iterator.hasNext()){
			validUser = iterator.next();
			if(validUser.getCardno().equals(validCardNo)){
				break;
			}
		}
		
		return validUser;
	}

	
	
}
