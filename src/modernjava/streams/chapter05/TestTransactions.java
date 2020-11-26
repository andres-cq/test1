package modernjava.streams.chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestTransactions {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /*
        Find all transactions in 2011 and sort by value (small to high)
         */

        Predicate<Transaction> predicate2011 = t -> t.getYear() == 2011;
        Comparator<Transaction> comparator = (a, b) -> a.getValue() < b.getValue() ? -1 : a.getValue() == b.getValue() ? 0 : 1;


        List<Transaction> transactions2011 = transactions.stream()
                .filter(predicate2011)
                .sorted(comparator)
                .collect(Collectors.toList());

        System.out.println("-----Transactions 2011-----");
        System.out.println("mySolution:" + transactions2011);

        //solution from book
        List<Transaction> tran = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("book solution " + tran);

        //another one
        List<Transaction> transactionTest = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(t -> t.getValue()))
                .collect(Collectors.toList());

        System.out.println("alternative: " + transactionTest);

        /*
        Where are all the cities where the traders work
         */
        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("cities: " + cities);

        /*
        Finds all traders from Cambridge and sort them by name
         */

        List<Trader> names = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader())
                .distinct()
                .sorted(Comparator.comparing(t -> t.getName()))
                .collect(Collectors.toList());

        System.out.println("my solution: " + names);

        //from book
        List<Trader> namesBook = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("book solution: " + namesBook);

        /*
        Returns a string of all traders'names sorted alphabetically
         */
        String traders = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b);

        System.out.println("my solution: " + traders);

        String traderStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());

        System.out.println("book solution: "+ traderStr);
    }


}
