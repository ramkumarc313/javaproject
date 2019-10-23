package com.streamapitest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class streamfilterusingforloop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> al=new ArrayList<Integer>();
		for(int i=0;i<=100;i++)
			al.add(i);
		Stream<Integer> st=al.stream();
		
		Stream<Integer> highValue=st.filter(p -> p >90);
		highValue.forEach(p -> System.out.print(p+","));
		
		

	}

}
