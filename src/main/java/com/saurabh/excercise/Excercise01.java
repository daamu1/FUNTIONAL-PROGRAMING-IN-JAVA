package com.saurabh.excercise;

import java.util.List;

public class Excercise01 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        System.out.println("***** Print Odd Number *****");
        printOddNumbersInListFuntional(numbers);
        System.out.println("***** Print All Course *****");
        printCourseInListFuntional(courses);
        System.out.println("***** Print All Course contain Spring *****");
        printCourseContainSpringInListFuntional(courses);
        System.out.println("***** Print all Course whos length is more then 3 *****");
        printCourseLengthInListFuntional(courses);
        System.out.println("**** Print Cubes of All Number ****");
        printCubesOfOddNumbersInListFunctional(numbers);
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers
                .stream()
                .map(number->number*number*number)
                .forEach(System.out::println);
    }

    private static void printCourseLengthInListFuntional(List<String> courses) {
        courses
                .stream()
                .filter(course->course.length()>=4)
                .forEach(System.out::println);
    }

    private static void printCourseContainSpringInListFuntional(List<String> courses) {
        courses
                .stream()
                .filter(course->course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printCourseInListFuntional(List<String> courses) {
        courses
                .stream()
                .forEach(System.out::println);
    }

    private static void printOddNumbersInListFuntional(List<Integer> numbers) {
        numbers.
                stream()
                .filter(number->number%2!=0)
                .forEach(System.out::println);
    }
}
