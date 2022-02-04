boolean checkCardNumber(String cardnumber){

	char temp0 = cardnumber.charAt(0); // temp0 reads the first digit
	char temp1 = cardnumber.charAt(1); // temp1 reads the second digit
	char temp2 = cardnumber.charAt(2); // temp2 reads the third digit
	char temp3 = cardnumber.charAt(3); // temp3 reads the fourth digit
	String temp4 = new String(new char[] {temp0 ,temp1});// temp4 combines the first and second digits 
	String temp5 = new String(new char[] {temp0,temp1,temp2,temp3}); // temp5 combines the first, second, third and the fourth digits
	int isNumber = 0; // Checks if substring are true
	char[] cardnumberChars = cardnumber.substring(0, cardnumber.length() - 1).toCharArray();
	

	if (cardnumber.length() < 12 || cardnumber.length() > 20) { 

		return false;
		// Checks the Card Number length  
	} else {  
			  
			if (temp0 == ('4')) {
				isNumber = 1;
			} else if (temp4.equals("51")||temp4.equals("52")||temp4.equals("53")||temp4.equals("54")||temp4.equals("55")) {
				isNumber = 1;
			} else if (temp4.equals("62")){
				isNumber = 1;
			} else if (temp4.equals("37")|| temp4.equals("34")) {
				isNumber = 1;
			} else if (Integer.parseInt(temp5) >= (2220) && Integer.parseInt(temp5) <= (2720)){ 
				isNumber = 1;

			} // Checks if the substrings are vaild 
			for( int i=0; i < cardnumber.length() -1 ; i++){
					if (Character.isDigit(cardnumberChars[i]) == false) {
					return false;
					//Checks if there is a letter
					}
				}
			if (isNumber == 1 ){
				return true;
			} else {
				return false; 	
			}	     
	}    
	
}