package com.saurabh.excercise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Excercise02 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> dateTimeData = Arrays.asList(
                "2023-09-18T10:30:00",
                "2023-09-19T14:45:30",
                "2023-09-20T08:15:20",
                "2023-09-21T18:00:00",
                "2023-09-22T09:30:15",
                "2023-09-23T16:20:45",
                "2023-09-14T11:10:05",
                "2023-09-15T20:55:30",
                "2023-09-16T07:25:10"
        );

        System.out.println(" GET Square of list and Then Sum");
        System.out.println(printsumOfSquareInListFuntional(numbers));
        System.out.println("For Sorting And distinct Value from list");
        printSortedAndDistinctInListFuntional(numbers);
        System.out.println("For Sorting And distinct Value from course");
        printSortedAndDistinctInCourseFuntional(courses);
        System.out.println("****** Sorted Date *******");
        printSortedDateFuntional(dateTimeData);

    }

    private static void printSortedDateFuntional(List<String> dateTimeData) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        List<LocalDateTime> dateTimes = dateTimeData
                .stream()
                .map(dateTimeStr -> LocalDateTime.parse(dateTimeStr, formatter))
                .sorted(LocalDateTime::compareTo)
                .toList();

        List<String> sortedDateTimeStrings = dateTimes
                .stream()
                .map(dateTime -> dateTime.format(formatter))
                .toList();

        sortedDateTimeStrings.forEach(System.out::println);
    }


    private static void printSortedAndDistinctInCourseFuntional(List<String> courses) {
        courses
                .stream()
                .sorted(Comparator.naturalOrder())
                .distinct()
                .forEach(System.out::println);
    }

    private static void printSortedAndDistinctInListFuntional(List<Integer> numbers) {
        numbers
                .stream()
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }

    private static Integer printsumOfSquareInListFuntional(List<Integer> numbers) {
        return numbers.
                stream()
                .map(n -> n * n)
                .toList()
                .stream()
                .reduce(0, Integer::sum);
    }

}

