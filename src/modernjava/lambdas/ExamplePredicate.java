package modernjava.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExamplePredicate {

    public static void main(String[] args){
        Predicate<String> nonEmptyStringPredicate = (String s)-> !s.isEmpty();

        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Andres");
        listOfStrings.add("");
        listOfStrings.add("");
        listOfStrings.add("Caro");

        System.out.println(listOfStrings + ", size: " + listOfStrings.size());

        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

        List<String> nonEmpty2 = filter(listOfStrings, s-> !s.isEmpty());

        System.out.println(nonEmpty + ", size: " + nonEmpty.size());
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results = new ArrayList<>();

        for(T t:list){
            if(p.test(t)){
                results.add(t);
            }
        }
        return results;
    }


}
