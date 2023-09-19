package com.saurabh.object;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomerFuntional01 {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public CustomerFuntional01(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

}

 class FP04CustomClass {

    public static void main(String[] args) {
        List<CustomerFuntional01> courses = List.of(new CustomerFuntional01("Spring", "Framework", 98, 20000),
                new CustomerFuntional01("Spring Boot", "Framework", 95, 18000), new CustomerFuntional01("API", "Microservices", 97, 22000),
                new CustomerFuntional01("Microservices", "Microservices", 96, 25000),
                new CustomerFuntional01("FullStack", "FullStack", 91, 14000), new CustomerFuntional01("AWS", "Cloud", 92, 21000),
                new CustomerFuntional01("Azure", "Cloud", 99, 21000), new CustomerFuntional01("Docker", "Cloud", 92, 20000),
                new CustomerFuntional01("Kubernetes", "Cloud", 91, 20000));

        // allMatch, noneMatch, anyMatch
        Predicate<CustomerFuntional01> reviewScoreGreaterThan95Predicate
                = course -> course.getReviewScore() > 95;

        Predicate<CustomerFuntional01> reviewScoreGreaterThan90Predicate
                = course -> course.getReviewScore() > 90;

        Predicate<CustomerFuntional01> reviewScoreLessThan90Predicate
                = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        Comparator<CustomerFuntional01> comparingByNoOfStudentsIncreasing
                = Comparator.comparingInt(CustomerFuntional01::getNoOfStudents);

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsIncreasing)
                        .collect(Collectors.toList()));
        //[FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]

        Comparator<CustomerFuntional01> comparingByNoOfStudentsDecreasing
                = Comparator.comparingInt(CustomerFuntional01::getNoOfStudents).reversed();

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsDecreasing)
                        .collect(Collectors.toList()));
        //[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]


        Comparator<CustomerFuntional01> comparingByNoOfStudentsAndNoOfReviews
                = Comparator.comparingInt(CustomerFuntional01::getNoOfStudents)
                .thenComparingInt(CustomerFuntional01::getReviewScore)
                .reversed();

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .collect(Collectors.toList()));
        //[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .limit(5)
                        .collect(Collectors.toList()));
        //[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .collect(Collectors.toList()));
        //[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]


        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList()));
        //[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95]

        System.out.println(courses);

        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getReviewScore()>=95)
                        .collect(Collectors.toList()));
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]

        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getReviewScore()>=95)
                        .collect(Collectors.toList()));
        //[FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

        System.out.println(
                courses.stream()
                        .max(comparingByNoOfStudentsAndNoOfReviews));
        //Optional[FullStack:14000:91]

        System.out.println(
                courses.stream()
                        .min(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(new CustomerFuntional01("Kubernetes", "Cloud", 91, 20000))
        );

        //Optional[Microservices:25000:96]
        //Microservices:25000:96

        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .min(comparingByNoOfStudentsAndNoOfReviews)
                        .orElse(new CustomerFuntional01("Kubernetes", "Cloud", 91, 20000))
        );
        //Optional.empty
        //Kubernetes:20000:91

        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .findFirst()
        );//Optional.empty


        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findFirst()
        );//Optional[Spring:20000:98]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findAny()
        );//Optional[Spring:20000:98]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(CustomerFuntional01::getNoOfStudents)
                        .sum());//88000

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(CustomerFuntional01::getNoOfStudents)
                        .average());//OptionalDouble[22000.0]

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(CustomerFuntional01::getNoOfStudents)
                        .count());//4

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(CustomerFuntional01::getNoOfStudents)
                        .max());//OptionalInt[25000]

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(CustomerFuntional01::getCategory)));
        //{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], 
        //  FullStack=[FullStack:14000:91], 
        // Microservices=[API:22000:97, Microservices:25000:96],
        // Framework=[Spring:20000:98, Spring Boot:18000:95]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(CustomerFuntional01::getCategory, Collectors.counting())));
        //{Cloud=4, FullStack=1, Microservices=2, Framework=2}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(CustomerFuntional01::getCategory,
                                Collectors.maxBy(Comparator.comparing(CustomerFuntional01::getReviewScore)))));
        //{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(CustomerFuntional01::getCategory,
                                Collectors.mapping(CustomerFuntional01::getName, Collectors.toList()))));
        //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}


        Predicate<CustomerFuntional01> reviewScoreGreaterThan95Predicate2
                = createPredicateWithCutoffReviewScore(95);

        Predicate<CustomerFuntional01> reviewScoreGreaterThan90Predicate2
                = createPredicateWithCutoffReviewScore(90);

    }

    private static Predicate<CustomerFuntional01> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }


}