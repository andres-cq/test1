package modernjava.streams.chapter05;

import modernjava.streams.chapter04.Dish;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestFindingMatching {

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

        //AnyMatch
        if (menu.stream().anyMatch(dish -> dish.isVegetarian())) {
            System.out.println("the menu is (somewhat) vegetarian friendly!!");
        }

        //Allmatch
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);

        System.out.println("is Healthy? " + isHealthy);

        //NoneMatch
        boolean isHealthy2 = menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);

        System.out.println("Is healthy2? " + isHealthy2);

        //FindAny
        Optional<Dish> dish = menu.stream()
                .filter(d -> d.isVegetarian())
                .findAny();

        System.out.println("optional findAny: " + dish.get());

        //findFirst
        //find the first square divisible by 3
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n->n*n)
                .filter(n->n%3==0)
                .findFirst();

        System.out.println("findFirst: " + firstSquareDivisibleByThree.get());


    }
}
