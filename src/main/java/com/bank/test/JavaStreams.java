package com.bank.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {
        // FInd Duplicate elements
        List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
        HashSet<Integer> seen=new HashSet<>();
        List<Integer> integers = nums.stream().
                filter(num -> !seen.add(num))
                .toList();
        System.out.println(integers);

        // Remove Duplicates
        List<Integer> list = nums.stream().distinct().toList();
        System.out.println(list);

        // Maximum number
        Integer i = nums.stream().max(Integer::compare).orElseThrow();
        System.out.println(i);
        //Minimum NUmber
        Integer min = nums.stream().min(Comparator.reverseOrder()).orElseThrow();
        System.out.println(min);

        // Second highest
        Optional<Integer> secondHighest = nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondHighest.get());

        // Sum ofNumbers
        Optional<Integer> reduce = nums.stream().reduce(Integer::sum);
        System.out.println(reduce.get());

        // AVg
        OptionalDouble reduce1 = nums.stream().mapToInt(Integer::intValue).average();
        System.out.println(reduce1.getAsDouble());

        // To upper case
        List<String> names = Arrays.asList("subhajit", "rahul", "amit");
        names.stream()
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);

        //Longest string
        List<String> list1 = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(list1);

        // join the elements
        String collect = names.stream().collect(Collectors.joining(""));
        System.out.println(collect);

        // Frequency of each number
        Map<Integer, Long> collect1 = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);

        // First non-repeating character
        String str = "spwpiss";
        Optional<Character> first = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )).entrySet()
                .stream().filter(ele -> ele.getValue() > 1)
                .map(Map.Entry::getKey).findFirst();
        System.out.println(first);

        // Convert list to map
        List<EmployeeDetails> employeeDetails = List.of(new EmployeeDetails(1, "Subhajit Garai", "IT", 55000L),
                new EmployeeDetails(2, "Sayak Ghosh", "DESK", 45000L),
                new EmployeeDetails(3, "Ritwik Bhowmik", "SUPPORT", 75000L),
                new EmployeeDetails(4, "Satyajit Jha", "YT", 35000L),
                new EmployeeDetails(5, "Diljit Dhosan", "IT", 90000L));

        Map<String, Double> collect2 = employeeDetails.stream().collect(Collectors.groupingBy(
                EmployeeDetails::getEmployeeDept,
                Collectors.averagingDouble(EmployeeDetails::getSalary)

        ));
        System.out.println(collect2);

        //Find Highest Salary
        Optional<EmployeeDetails> max = employeeDetails.stream().max(Comparator.comparingLong(EmployeeDetails::getSalary));
        System.out.println(max);

        // Frequency of each word in string
        String word ="programming"; // Ras string convert to intstream then maptoObj
        Map<Character, Long> collect3 = word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(collect3);

        // Find most frequent element
        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 2, 4, 2, 5, 3);

        Optional<Integer> i1 = numbers.stream().collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet()
                .stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey);
        System.out.println(i1);

        // Find Common Elements
        List<Integer> l1 =
                Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> l2 =
                Arrays.asList(4, 5, 6, 7, 8);

        l1.stream().filter(l2::contains).toList().forEach(System.out::println);

        // Find Second largest String
        List<String> technologies = Arrays.asList(
                "Java",
                "Spring",
                "Microservices",
                "AWS",
                "Docker"
        );

        Optional<String> first1 = technologies.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(first1);

        // Group Numbers by Even and Odd ⭐
        List<Integer> numbers1 =
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Boolean, List<Integer>> collect4 = numbers1.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(collect4);

        //Employee — Second Highest Salary Per Department 🔥
        Map<String, Optional<EmployeeDetails>> result =
                employeeDetails.stream()
                        .collect(Collectors.groupingBy(
                                EmployeeDetails::getEmployeeDept,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list0 -> list0.stream()
                                                .sorted(Comparator.comparingLong(
                                                        EmployeeDetails::getSalary
                                                ).reversed())
                                                .skip(1)
                                                .findFirst()
                                )
                        ));
        System.out.println(result);



    }
}
