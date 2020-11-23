package modernjava.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

public class ExampleFunction {

    public static void main(String[] args){
        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), (String s)->s.length());
        System.out.println(l);

        Predicate<List<String>> p = list->!list.isEmpty();

        List<String> testList = new ArrayList<>();

        System.out.println(p.test(testList));

        IntBinaryOperator bin = (int a, int b)->a*b;

        System.out.println(bin.applyAsInt(5,8));
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();

        for(T t:list){
            result.add(f.apply(t));
        }
        return result;
    }
}
