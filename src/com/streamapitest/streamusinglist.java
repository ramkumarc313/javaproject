package com.streamapitest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streamusinglist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="";
		List<String> al=Arrays.asList("sachin","ram","arun","kumar","sri","arun");
          al.stream().sorted().forEach(p -> System.out.print(p+","));
          System.out.println();
          al.stream().sorted().distinct().forEach(p -> System.out.print(p+","));
          System.out.println();
          List<String> show =al.stream().filter(p -> p.startsWith("a")).collect(Collectors.toList());
          System.out.print(show);
	}

}
