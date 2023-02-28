package com.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeList {
	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<Employee>();

		empList.add(new Employee(111, "Ram Kumari", 32, "Female", "HR", 2011, 25000.0));
		empList.add(new Employee(122, "Kumar Swamy", 25, "Male", "Finance", 2015, 13500.0));
		empList.add(new Employee(277, "Shalini Singh", 31, "Male", "Sales", 2012, 35700.0));
		empList.add(new Employee(277, "Shalini Singh", 31, "Female", "Sales", 2012, 35700.0));
		empList.add(new Employee(111, "Ram Kumari", 32, "Female", "HR", 2011, 27000.0));
		empList.add(new Employee(277, "ABXY", 31, "Other", "Engg", 2019, 35700.0));

		// How many male, female and other employees are there in the organization?");
		Map<String, Long> countMFO = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countMFO);

		// Print the name of each Department");
		empList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		// What is the average age of male and female employees?");
		Map<String, Double> avgage = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(avgage);

		// Get the details of highest paid employee in the organization?");
		Optional<Employee> highest = empList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		Employee emp = highest.get();

		// Details Of Highest Paid Employee
		System.out.println("ID:	" + emp.getId());
		System.out.println("Name:	" + emp.getName());

		// Find Names all the Names
		List<String> dname = empList.stream().distinct().map(a -> a.getName()).collect(Collectors.toList());
		System.out.println(dname);
		System.out.println("Find Unique Names ");
		Set<String> uniquename = new HashSet<>();
		List<String> uname = dname.stream().filter(name -> !uniquename.add(name)).collect(Collectors.toList());
		System.out.println("Unique Names: " + uniquename);
		System.out.println("Duplicatio Name : " + uname);

		System.out.println("//Name of employees who have joined after 2015?");
		empList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

		// Average Salary in each department
		Map<String, Double> map = empList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("//Avg Salary in Dept " + map);
		Set<java.util.Map.Entry<String, Double>> entrySet = map.entrySet();
		for (java.util.Map.Entry<String, Double> entry : entrySet) {
			System.out.println(entry.getKey() + "	: " + entry.getValue());

		// Count the no of employee in each dept.
		Map<String, Long> dept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		Set<Entry<String, Long>> deptentry = dept.entrySet();
			for (Entry<String, Long> p : deptentry) {
				System.out.println(p.getKey() + "	:" + p.getValue());

				// List down the names of all employees in each department?
		Map<String, List<Employee>> emplistdept = empList.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> es = emplistdept.entrySet();
				for (Entry<String, List<Employee>> el : es) {
				System.out.println("--------------------------------------");
				System.out.println("Employees In " + entry.getKey() + " : ");
				System.out.println("--------------------------------------");
		List<Employee> list = el.getValue();
			for (Employee e : list) {
				System.out.println(e.getName());
		//What is the average salary and total salary of the whole organization?
				DoubleSummaryStatistics ess=
						empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));						         
						System.out.println("Average Salary = "+ess.getAverage());						         
						System.out.println("Total Salary = "+ess.getSum());
					}
				}
			}
		}

	}
}
