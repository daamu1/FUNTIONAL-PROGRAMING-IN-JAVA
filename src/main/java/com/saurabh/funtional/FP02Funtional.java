package com.saurabh.funtional;

import java.util.List;

public class FP02Funtional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addListFuntional(numbers);
        System.out.println("Sum of List "+sum);
    }


    private static int addListFuntional(List<Integer> numbers) {
        return numbers.stream().reduce(0, FP02Funtional::sum);
    }

    private static Integer sum(Integer a, Integer b) {
        System.out.println("A ---->"+a+"   ----->"+b);
        return a + b;
    }


}
