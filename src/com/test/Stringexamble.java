package com.test;

public class Stringexamble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="ram";
		String b="ram";
		String c=new String("ram");
		StringBuffer d=new StringBuffer("ram");
		StringBuffer sf=new StringBuffer("ram");
		//System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(a.equals(c));
		System.out.println(c==d.toString());
		System.out.println(d.toString().equals(sf.toString()));



	}

}
