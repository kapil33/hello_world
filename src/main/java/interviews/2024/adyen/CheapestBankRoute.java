package interviews.adyen;

import javafx.util.Pair;

import java.util.*;

interface BankRoute {
    String getSource();
    String getDestination();
    int getCost();
}

public class CheapestBankRoute implements BankRoute {
    /* Problem Statement: International bank transfers can sometimes be very complicated with Adyen's money
    going through multiple intermediary banks(each tasking a cut) before they reach their destination.
    Since Adyen executes a lot of transfers- it's worthwhile to find the cheapest routes. At the same time we
    don't want the transfer to go through too many intermediaries as that may cause delays.
    Given a destination bank, lis of routes including costs and a maximum number of intermediary banks -
    return the cost of the cheapest route b/w Adyen and the destination bank or -1 if no such route exists.

    Example: We want to find a route to Chase with at most 1 intermediary bank. The available routes are as follows:
    Adyen to BoA with a cost of 10
    BoA to Wells with a cost of 10
    Wells to Adyen with a cost of 10
    BoA to Chase with a cost of 60
    Wells to Chase with a cost of 20

    There's 2 routes to Chase -
        Adyen to BoA to Wells to Chase(10 + 10 + 20 = 40) and
        Adyen to BoA to Chase(10 + 60 = 70).

    The first route is cheaper but goes through 2 intermediary banks, the cheapest route going through no more
    than 1 intermediary is therefore the second one, with a cost of 70.

    Better solution is at: https://leetcode.com/problems/cheapest-flights-within-k-stops/

    * */

    private final String source;
    private final String destination;
    private final int cost;

    public CheapestBankRoute(String source, String destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public static int getCheapestRouteCost(String destination, List<BankRoute> routes, int max) {
        if(max < 1)
            return -1;
        Map<String, List<Pair<String, Integer>>> adjMap = new HashMap<>();
        PriorityQueue<Pair<String, Pair<Integer, Integer>>> pq =
                new PriorityQueue<>((a, b)-> a.getValue().getKey() - b.getValue().getKey());
        Set<String> visited = new HashSet<>();
        List<Long> result = new ArrayList<>();

        for(BankRoute br: routes) {
            adjMap.computeIfAbsent(br.getSource(), k-> new ArrayList<>())
                    .add(new Pair<>(br.getDestination(), br.getCost()));
        }
        for(Pair<String, Integer> p: adjMap.get("Adyen")) {
            pq.add(new Pair<>(p.getKey(), new Pair<>(p.getValue(), 1)));
        }
        if(pq.isEmpty())
            return -1;
        visited.add("Adyen");

        while(!pq.isEmpty()) {
            Pair<String, Pair<Integer, Integer>> curr = pq.poll();
            visited.add(curr.getKey());

            if(adjMap.containsKey(curr.getKey()) && curr.getValue().getValue() <= max) {
                for(Pair<String, Integer> next: adjMap.get(curr.getKey())) {
                    if(next.getKey().equals(destination))
                        result.add((long) (curr.getValue().getKey() + next.getValue()));
                    else {
                        if(!visited.contains(next.getKey())) {
                            pq.add(new Pair<>(next.getKey(),
                                    new Pair<>(curr.getValue().getKey() + next.getValue(),
                                            curr.getValue().getValue() + 1)));
                            visited.add(next.getKey());
                        }
                    }
                }
            }
        }

        if (result.isEmpty())
            return -1;
        long res = result.get(0);
        for(int i=1; i<result.size(); i++) {
            res = Math.min(res, result.get(i));
        }

        return (int) res;
    }
    public static void main(String[] args) {
        List<BankRoute> bankRoutes = new ArrayList<>();
        bankRoutes.add(new CheapestBankRoute("Adyen", "BoA", 10));
        bankRoutes.add(new CheapestBankRoute("BoA", "Wells", 10));
        bankRoutes.add(new CheapestBankRoute("Wells", "Adyen", 10));
        bankRoutes.add(new CheapestBankRoute("BoA", "Chase", 60));
        bankRoutes.add(new CheapestBankRoute("Wells", "Chase", 20));

        System.out.println(CheapestBankRoute.getCheapestRouteCost("Chase", bankRoutes, 1));
    }
}