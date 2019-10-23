package com.functional;

import java.util.function.Predicate;

public class PredicateInterfaceExample {

	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
		
		Predicate<Integer> pc=a ->(a > 18);
		System.out.println(pc.test(10));

	}

}
