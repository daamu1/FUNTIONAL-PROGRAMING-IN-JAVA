package com.saurabh.funtional;


import java.util.List;

public class FP01Funtional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        System.out.println("***** All Number *****");
        printAllNumbersInListFuntional(numbers);
        System.out.println("***** Even Number *****");
        printEvenNumbersInListFuntional(numbers);


    }

    private static void printEvenNumbersInListFuntional(List<Integer> numbers) {
        numbers
                .stream()
                .filter(number->number%2==0)
                .forEach(System.out::println);
    }

    private static void printAllNumbersInListFuntional(List<Integer> numbers) {
        numbers
                .forEach(System.out::println);

    }


}