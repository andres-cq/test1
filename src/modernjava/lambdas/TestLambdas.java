package modernjava.lambdas;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class TestLambdas {

    public static void main(String[] args){

        ToIntFunction<String> stringToInt = s->Integer.parseInt(s);

        System.out.println((stringToInt.applyAsInt("55")));

        ToIntFunction<String> str = Integer::parseInt;

        Function<Integer, Integer> f = x->x+1;
        Function<Integer, Integer> g = x->x*2;
        Function<Integer,Integer> h = f.andThen(g);

        int result = h.apply(4);
        System.out.println("result: " + result);
    }
}
