package modernjava.streams.chapter05;

import modernjava.streams.chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreams {

    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

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

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish-> dish.getCalories()<320)
                .collect(Collectors.toList());

        System.out.println("filteredMenu <320 calories: " + filteredMenu);

        //takeWhile
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish->dish.getCalories()<320)
                .collect(Collectors.toList());

        System.out.println("takeWhile: " + slicedMenu1);

        //dropWhile
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish->dish.getCalories()<320)
                .collect(Collectors.toList());

        System.out.println("dropWhile: " + slicedMenu2);

        //limit(int)
        List<Dish> dishesLimit = specialMenu.stream()
                .filter(dish-> dish.getCalories()>300)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("limit: " + dishesLimit);

        //skip(int)
        List<Dish> dishesSkip = specialMenu.stream()
                .filter(dish->dish.getCalories()>300)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println("skip: " + dishesSkip);

        //Quiz 5.1:Filtering
        List<Dish> dishesQuiz =menu.stream()
                .filter(dish->dish.getType()==Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("quiz: " + dishesQuiz);
    }
}
