package modernjava.streams.chapter04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args){
        List<String> title = Arrays.asList("Modern", "Java", "In", "Action");

        Stream<String> s = title.stream();

        s.forEach(t-> System.out.println(t));
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
        for(Dish dish:menu){
            names.add(dish.getName());
        }
        System.out.println("with for-each: " + names);

        //Collections:external iteration using an iterator behind the scenes
        List<String> names2 = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while(iterator.hasNext()){
            Dish dish = iterator.next();
            names2.add(dish.getName());
        }
        System.out.println("with iterator: " + names2);

        //Streams: internal iteration
        List<String> names3 = menu.stream()
                .map(d->d.getName())
                .collect(Collectors.toList());
        System.out.println("with streams: " + names3);


    }
}
