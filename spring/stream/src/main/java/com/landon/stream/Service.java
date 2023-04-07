package com.landon.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private final Trader raoul = new Trader("Raoul", "Cambridge");
    private final Trader mario = new Trader("Mario", "Milan");
    private final Trader alan = new Trader("Alan", "Cambridge");
    private final Trader brian = new Trader("Brian", "Cambridge");

    private final List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
    public void q1() {
        List<Transaction> transactionsIn2011 = transactions.stream()
            .filter((t) -> t.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getYear))
            .collect(Collectors.toList());

        System.out.println(transactionsIn2011);
    }

    // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
    public void q2() {
        List<String> citiesWorkedByTrader = transactions.stream()
            .map((transaction -> transaction.getTrader().getCity()))
            .distinct()
            .collect(Collectors.toList());

        System.out.println(citiesWorkedByTrader);
    }

    // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
    public void q3() {
        List<Trader> tradersWorkedAtCambridge = transactions.stream()
//            .filter(transaction -> transaction.getTrader().getCity() == "Cambridge")
            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getTrader)
            .distinct()
            .sorted(Comparator.comparing(Trader::getName))
            .collect(Collectors.toList());

        System.out.println(tradersWorkedAtCambridge);
    }

    // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
    public void q4() {
        List<String> traderNames = transactions.stream()
            .map((transaction) -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .collect(Collectors.toList());

        System.out.println(traderNames);
    }

    // 5. 밀라노에 거래자가 있는가?
    public void q5() {
//        boolean hasTraderInMilano = !transactions.stream()
//            .map(Transaction::getTrader)
//            .filter(trader -> trader.getCity().equals("Milan"))
//            .collect(Collectors.toList())
//            .isEmpty();
//
//        System.out.println(hasTraderInMilano);

        boolean milanBased = transactions.stream()
            .anyMatch(transaction ->
                transaction.getTrader().getCity().equals("Milan")
            );

        System.out.println(milanBased);
    }

    // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
    public void q6() {
//        List<Integer> transactionValuesInCambridge = transactions.stream()
//            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
//            .map(Transaction::getValue)
//            .collect(Collectors.toList());
//
//        System.out.println(transactionValuesInCambridge);

        transactions.stream()
            .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
            .map(Transaction::getValue)
            .forEach(System.out::println);
    }

    // 7. 전체 트랜잭션 중 최댓값은 얼마인가?
    public void q7() {
//        int max = transactions.stream()
//            .map(Transaction::getValue)
//            .reduce(Integer::max)
//            .get();

        transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::max)
            .ifPresent((max) -> System.out.println("최댓값 : " + max));
    }

    // 8. 전체 트랜잭션 중 최솟값은 얼마인가?
    public void q8() {
        transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::min)
            .ifPresent((min) -> System.out.println("최솟값 : " + min));
    }
}
