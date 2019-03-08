package com.gx.java8;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StreamTest {
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
                new Transaction(alan, 2012, 950));

//        1. Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> list = transactions.stream().filter(t -> t.getYear() == 2001).sorted(comparing(Transaction::getValue)).collect(toList());
        Optional.ofNullable(list).ifPresent(System.out::println);
        System.out.println(list);
//        2. What are all the unique cities where the traders work?
        List<String> list1 = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList());
        System.out.println(list1);
//        3. Find all traders from Cambridge and sort them by name.
        List<Trader> traderList = transactions.stream().map(t -> t.getTrader()).filter(t -> t.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName)).collect(toList());
        System.out.println(traderList);

//        4. Return a string of all traders’ names sorted alphabetically.
        String tradersName=transactions.stream().map(t->t.getTrader().getName()).distinct().sorted().reduce("",(n1,n2)->n1+n2);
        String tradersName2=transactions.stream().map(t->t.getTrader().getName()).distinct().sorted(Comparator.reverseOrder()).collect(joining());
        System.out.println(tradersName);
        System.out.println(tradersName2);
//        5. Are any traders based in Milan?
       boolean flag= transactions.stream().anyMatch(t->t.getTrader().getCity().equals("Milan"));
        System.out.println(flag);

//        6. Print all transactions’ values from the traders living in Cambridge.
       transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(s->s.getValue()).forEach(System.out::println);
       List<Integer>  listValues= transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(s->s.getValue()).collect(toList());
        System.out.println(listValues);
//        7. What’s the highest value of all the transactions?
        Optional<Integer> reduce = transactions.stream().map(t -> t.getValue()).reduce(Integer::max);
        System.out.println(reduce.get());

//        8. Find the transaction with the smallest value.
        Optional<Transaction> reduce1 = transactions.stream().reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t1 : t2);
        System.out.println(reduce1.get());

    }

}
