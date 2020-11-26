package modernjava.streams.chapter05;

import modernjava.streams.chapter04.Dish;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class TestReducing {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

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

        BinaryOperator<Integer> sumLambda = (a, b) -> a + b;
        //reduce
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);

        System.out.println("reduce sum: " + sum);

        //maximum and minimum
        Optional<Integer> max = numbers.stream().reduce((a, b) -> Integer.max(a, b));

        System.out.println("reduce max: " + max);

        //Quiz 5.3:Reducing
        int numberDishes = menu.stream()
                .map(dish -> 1)
                .reduce(0, (a, b) -> a + b);

        System.out.println("number of dishes: " + numberDishes);


    }
}
