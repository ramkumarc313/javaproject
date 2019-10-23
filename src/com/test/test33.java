package com.test;

public class test33 {
	public static boolean palindrome(String s) {
		String str ="";
		char temp;
		for(int i=0;i<=s.length()-1;i++) {
			
			
			temp=s.charAt(i);
			str =str+temp;
			
		}
        if(str.equals(s)) {
    		return true;

        }
        else
        {
		return false;
        }
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(palindrome("madam"));
	}

}
