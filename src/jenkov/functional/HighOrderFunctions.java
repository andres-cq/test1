package jenkov.functional;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HighOrderFunctions {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Abc");
        list.add("BCD");

        System.out.println("Original");
        System.out.println(list);

        Collections.sort(list, (String a, String b) -> {
            return a.compareTo(b);
        });

        System.out.println("Sorted");
        System.out.println(list);

        Comparator<String> comparator = (String a, String b) -> {
            return a.compareTo(b);
        };

        Comparator<String> comparatorReversed = comparator.reversed();

        Collections.sort(list, comparatorReversed);

        System.out.println("reversed sorted");
        System.out.println(list);

        Runnable r = () -> System.out.println("Runnable example");
        r.run();

        ActionListener a = e -> {

        };
    }
}
