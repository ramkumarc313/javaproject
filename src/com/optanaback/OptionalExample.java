package com.optanaback;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] str = new String[10];  
       // System.out.print(lowercaseString);  
        Optional<String> checkNull = Optional.ofNullable(str[5]);  

        if(checkNull.isPresent()) {
            String lowercaseString = str[5].toLowerCase();  

             // String lowercaseString = str[5].toLowerCase();  
              System.out.print(lowercaseString);  

          }
          else
          {
              System.out.print("ramkumar");  
 
          }
        
        

	}

}
