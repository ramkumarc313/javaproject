package com.streamapitest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class arraylistvalue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");
		memberNames.stream().filter(p -> p.startsWith("S")).collect(Collectors.toList()).forEach(p ->System.out.println(p));
	}

}
