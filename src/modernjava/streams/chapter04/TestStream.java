package modernjava.streams.chapter04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {
        List<String> title = Arrays.asList("Modern", "Java", "In", "Action");

        Stream<String> s = title.stream();

        s.forEach(t -> System.out.println(t));
        //s.forEach(t-> System.out.println(t));

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

        //Collections: external iteration with a for-each loop
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }
        System.out.println("with for-each: " + names);

        //Collections:external iteration using an iterator behind the scenes
        List<String> names2 = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            names2.add(dish.getName());
        }
        System.out.println("with iterator: " + names2);

        //Streams: internal iteration
        List<String> names3 = menu.stream()
                .map(d -> d.getName())
                .collect(Collectors.toList());
        System.out.println("with streams: " + names3);

        /*
        QUIZ 4.1
         */
        List<String> highCaloricDishes = new ArrayList<>();
        Iterator<Dish> iterator2 = menu.iterator();
        while (iterator2.hasNext()) {
            Dish dish = iterator2.next();
            if (dish.getCalories() > 300) {
                highCaloricDishes.add(dish.getName());
            }
        }
        System.out.println("high caloric iterator: " + highCaloricDishes);

        //with streams()
        List<Dish> highCaloricDishesStream = menu.stream()
                .filter(d->d.getCalories()>300)
                .collect(Collectors.toList());
        System.out.println("high caloric streams: " + highCaloricDishesStream);

        System.out.println("---------------");
        List<String> highCaloricStreams = menu.stream()
                .filter(dish->{
                    System.out.println("filtering: " + dish.getCalories());
                    return dish.getCalories()>300;
                })
                .map(dish->{
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                }).limit(3).collect(Collectors.toList());


        List<Dish> vegetarianDishes = menu.stream()
                .filter(dish->dish.isVegetarian())
                .collect(Collectors.toList());
        System.out.println(vegetarianDishes);

        System.out.println("------------------------");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i->i%2==0)
                .distinct()
                .forEach(number-> System.out.println(number));
    }
}
