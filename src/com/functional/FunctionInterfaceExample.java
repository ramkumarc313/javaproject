package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInterfaceExample {
	
	public static int show(List<Integer> list)
	{
		int sum = 0;
		
		
		sum=list.stream().mapToInt(Integer::intValue).sum();
		
		return sum;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Integer> list = new ArrayList<Integer>();  
        list.add(10);  
        list.add(20);  
        list.add(30);  
        list.add(40);  
        
        Function<List<Integer>,Integer> fun=FunctionInterfaceExample::show;
        
        System.out.println(fun.apply(list));

	}

}
