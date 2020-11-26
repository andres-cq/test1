package modernjava.streams.chapter05;

import modernjava.streams.chapter04.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMapping {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<String> dishNames = menu.stream()
                .map(dish -> dish.getName())
                .collect(Collectors.toList());

        System.out.println("mapping: " + dishNames);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(word -> word.length())
                .collect(Collectors.toList());

        System.out.println("length words: " + wordLengths);
        System.out.println("words menu: " +
                menu.stream()
                        .map(word -> word.getName().length())
                        .collect(Collectors.toList())
        );

        List<Integer> dishNameLength = menu.stream()
                .map(dish -> dish.getName())
                .map(name -> name.length())
                .collect(Collectors.toList());

        System.out.println("map menu: " + dishNameLength);

        //unique characters
        List<String> words2 = Arrays.asList("Hello", "World");
//        List<String> uniqueWords = words2.stream()
//                .map(word->word.split(""))
//                .collect(Collectors.toList());
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        List<String> uniqueCharacters = words2.stream()
                .map(word -> word.split(""))
                .flatMap(word -> Arrays.stream(word))
                .distinct()
                .collect(Collectors.toList());

        System.out.println("uniqueCharacters: " + uniqueCharacters);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
        System.out.println("squares: " + squares);

        //Quiz 5.2b
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);

        Stream<Integer> stream1 = list1.stream();

        Stream<Integer> stream2 = list2.stream();

        List<int[]> pairs = list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> new int[]{i, j})
                ).collect(Collectors.toList());

        System.out.println("pairs: " + pairs);

        pairs.stream().forEach(p -> System.out.println(p[0] + "," + p[1]));

        //Quiz 5.2c
        List<int[]> pairs2 = list1.stream()
                .flatMap(i ->
                        list2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})

                ).collect(Collectors.toList());

        pairs2.stream().forEach(p -> {
            System.out.println("pairs % 3 == 0");
            System.out.println(p[0] + "," + p[1]);
        });


    }
}
