package com.collectexamble;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortByKeyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        
        Map<String, Integer> sorted=unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldvalue,newvalue)->oldvalue,TreeMap::new));
        System.out.println(sorted);

        
        Map<String,Integer> sort=new LinkedHashMap<>();        
        		unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(p -> sort.put(p.getKey(), p.getValue()));
        		 System.out.println(sort);
        		 
        		  Map<String, Integer> sorted1=unsortMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
        	        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldvalue,newvalue)->newvalue,LinkedHashMap::new));
        	        System.out.println(sorted1);
        	        
        	   
	}

}
