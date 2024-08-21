package interviews.adyen;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class CardRange {
    final String start;
    final String end;
    final String cardNetwork;

    CardRange(String start, String end, String cardNetwork) {
        this.start = start;
        this.end = end;
        this.cardNetwork = cardNetwork;
    }
}

class CardNetworkCache {
    TreeMap<String, CardRange> cardRangeDb;
    int l = Integer.MAX_VALUE;

    CardNetworkCache(List<CardRange> cardRanges) {
        this.cardRangeDb = new TreeMap<String, CardRange>((a, b) -> a.compareTo(b));
        for (CardRange cr : cardRanges) {
            l = Math.min(l, cr.start.length());
            CardRange newCr = new CardRange(cr.start, cr.end, cr.cardNetwork);
            cardRangeDb.put(cr.start, newCr);
        }
    }

    /**
     * @param cardNumber 16 to 24 digit card number.
     * @return the card network for this cardNumber or null if the card number does not
     * fall into any valid range.
     */
    public String get(String cardNo) {
        cardNo = cardNo.substring(0, l);
        String floorKey = cardRangeDb.floorKey(cardNo);
        String ceilKey = cardRangeDb.ceilingKey(cardNo);
        if (floorKey != null) {
            CardRange cr = cardRangeDb.get(floorKey);
            if (isCardRangeMatch(cardNo, cr)) {
                return cr.cardNetwork;
            }
        }
        if (ceilKey != null) {
            CardRange cr = cardRangeDb.get(ceilKey);
            if (isCardRangeMatch(cardNo, cr)) {
                return cr.cardNetwork;
            }
        }
        return null;
    }

    public boolean isCardRangeMatch(String cardNo, CardRange cr) {
        return cardNo.compareTo(cr.start) >= 0 && cardNo.compareTo(cr.end) <= 0;
    }

}

public class CardNetwork {
    /* Problem Statement: Payment processing requires providers like Adyen to identify the
    network(Visa, MasterCard, American Express etc.) to which the request should be forwarded. This is done
    based on the shopper's card number. While card numbers can have a length of 16-24 digits, the network can be
    uniquely identified based on the first 12 digits of it.
    Often consecutive 12 digit card identifiers map to the same network and therefor we maintain ranges of them.
    For this exercise we assume that each range is mapped to only one network and there are no overlapping ranges.
    There may be gaps in b/w ranges for which we don't have a corresponding network. We consider the cards that fall
    in those gaps as being invalid and we can't process them.

    Objective: Based on a list of card ranges implement a card network cache that supports efficient card network
    identification by card number and returns 'null' if there's no matching range. Keep in mind that Adyen
    processes millions of payments every day and the card network lookup has to be performed for every payment
    request. At the same time there can be hundreds of thousands of different card ranges in cache.

    Example:
    Start= 410000000000, end= 419999999999, network=visa
    Start= 420008000000, end= 420008999999, network=amex
    Start= 435000000000, end= 435000999999, network=visa
    Start= 540000000000, end= 599999999999, network=mc

    A card number 411111111111 would match the first card range and so the network would be Visa.

    * */

    public static void main(String[] args) {
        List<CardRange> cardRanges = new ArrayList<>();
        cardRanges.add(new CardRange("410000000000", "419999999999", "VISA"));
        cardRanges.add(new CardRange("420008000000", "420008999999", "AMEX"));
        cardRanges.add(new CardRange("435000000000", "435000999999", "VISA"));
        cardRanges.add(new CardRange("540000000000", "599999999999", "MC"));

        CardNetworkCache cardNetworkCache = new CardNetworkCache(cardRanges);
        System.out.println(cardNetworkCache.get("411111111111"));
        System.out.println(cardNetworkCache.get("540000000123"));
        System.out.println(cardNetworkCache.get("434000000000"));
    }
}