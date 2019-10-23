package com.test;

import java.io.IOException;

import com.test1.ProVars;

public class AnotherClass extends ProVars {
	
	public  AnotherClass()
	{
		foo();
		//return 1;
	}
	public static void main(String args[]) 
	{
		AnotherClass p=new AnotherClass();
		p.foo();
		
	}

}
