package com.collectexamble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class groupbyexamble {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> al=new ArrayList<Employee>();
		al.add(new Employee(1,"ramkumar",33,"BE","13-09-1987",30000,"chennai"));
		al.add(new Employee(2,"arun",19,"ba","10-01-1990",2500,"tenkasi"));
		al.add(new Employee(3,"sachin",49,"10th","24-05-1970",3000000,"mumbai"));
		al.add(new Employee(4,"tendulkar",29,"12th","22-06-1890",5000000,"saudi"));
		al.add(new Employee(5,"sri",47,"mca","11-03-1977",38000,"qatar"));
		al.add(new Employee(6,"anbu",19,"btech","31-07-2000",70000,"madurai"));
		al.add(new Employee(7,"siva",21,"mbbs","20-11-1998",50000,"covai"));
		al.add(new Employee(8,"kumar",18,"md","10-12-2001",50000,"delhi"));
		al.add(new Employee(9,"ramkumar",16,"ma","01-10-2005",10000,"uae"));
		al.add(new Employee(10,"ram",14,"BE","33-04-2006",25000,"qatar"));

		//List<Employee> gal=al.stream().count()
		// filter using list collect
		List<Double> filterSalary=al.stream().filter(p ->p.salary <50000).map(p ->p.salary).collect(Collectors.toList());
		
		 System.out.println(filterSalary);
		 
		 // filter using list without collect foreache
		 al.stream().filter(e -> e.name.equals("ramkumar")).forEach(Employee -> System.out.println(Employee.name));

		 Map<Object, Object> map=al.stream().collect(Collectors.toMap(p -> p.id, p-> p.name));
		 
		 System.out.println(map);
		Set<String> set=al.stream().map(p ->p.name).collect(Collectors.toSet());
		System.out.println(set);
		
		//Map<Employee, Long> ms=al.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		//System.out.println(ms);
		
		Map<String,Long> counting=al.stream().collect(Collectors.groupingBy(p ->p.name,Collectors.counting()));
		System.out.println(counting);
		Map<Object, Double> sum=al.stream().collect(Collectors.groupingBy(p ->p.name,Collectors.summingDouble(p-> p.salary)));

		System.out.println(sum);

		
		Map<String,Long> counting1=al.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
		System.out.println(counting1);
		
		Map<String, List<Employee>> grouped=al.stream().collect(Collectors.groupingBy(Employee::getName));
		System.out.println(grouped);
		
	   

	}

	
}

class Employee
{
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String name;
	int age;
	String Qualification;
	String dateofbirth;
	double salary;
	String Address;
	
	int id;
	public Employee(int id, String name, int age, String qualification, String dateofbirth, double salary,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		Qualification = qualification;
		this.dateofbirth = dateofbirth;
		this.salary = salary;
		Address = address;
	}
	
	
}
