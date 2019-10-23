package com.test;

public class test4 {

	public void dispaly(Object obj)
	{
		System.out.println("obj");

	}
	
	public void dispaly(String s)
	{
		System.out.println("string");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		test4 t=new test4();
		
		Object o=new test4();
		String s=new String();
		t.dispaly(s);
		t.dispaly(o);

		

	}

}
