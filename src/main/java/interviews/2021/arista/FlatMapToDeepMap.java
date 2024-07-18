package gfg.interviews.arista;

/*
*Below is the data structure question: convert a flat map(given as a list of string) into a deep map.
/*
Flat Map:
--------
customer.id : 100-E
customer.firstname : Mike
customer.lastname : Smith
customer.address.street : 123 Pine Street
customer.address.city : San Francisco
customer.address.state : CA
customer.address.zip : 94131
customer.order.id: O-123
customer.order.total : 500.32
customer.order.date : 2020-01-01
customer.order.product.id : p-123
customer.order.product.description : washer

x.y.

convert this into a deep map:
---------------------------
 {
   "customer": {
   "id": "100-E",
   "firstname": "Mike",
   "lastname": "Smith",
   "address": {
     "street": "123 Pine Street",
       "city":""San Francisco",
       "state" :"CA",
       "zip":"94131"
     },
     "order": {
       "id" : "O-123"
       "total" :"500.32"
       "date" : "2020-01-01"
       "product": {
           "id":"p-123",
           "description":"washer"
       }
     }
   }
 }

*/

/*
*Map<String,Object> deepenMap(List<String> flatMap){

        for(int i=0; i<flatMap.size(); i++){

        }
    }
* */

import java.util.*;

public class FlatMapToDeepMap {

    private static List<String> createEntries(){
        List<String> list = new ArrayList<>();
        list.add("customer.id : 100-E");
        list.add("customer.firstname : Mike");
        list.add("customer.lastname : Smith");
        list.add("customer.address.street : 123 Pine Street");
        list.add("customer.address.city : San Francisco");
        list.add("customer.address.state : CA");
        list.add("customer.address.zip : 94131");
        list.add("customer.order.id: O-123");
        list.add("customer.order.total : 500.32");
        list.add("customer.order.date : 2020-01-01");
        list.add("customer.order.product.id : p-123");
        list.add("customer.order.product.description : washer");

        return list;
    }

    public static void main (final String... args) {

        final List<String> entries = createEntries();

        // The outer map that is the result. This is the head of the map "tree" that we are trying to construct.
        // Entry point for all iterations.
        final Map<String, Object> result = new HashMap<>();

        for (final String entry : entries) {
            final DeepKeysAndValue deepKeysAndValue = new DeepKeysAndValue(entry);
            insertEntryInMainMap(deepKeysAndValue, result);
        }

        System.out.println(result);
    }

    private static void insertEntryInMainMap(final DeepKeysAndValue deepKeysAndValue, final Map<String, Object> result) {
        Map<String, Object> loopMap = result;
        for (final String nonTerminalKeyPart : deepKeysAndValue.getNMinus1KeyParts()) {
            addMapForKeyPartIfDoesNotExistAlready(nonTerminalKeyPart, loopMap);
            loopMap = (Map<String, Object>) loopMap.get(nonTerminalKeyPart);
        }
        loopMap.put(deepKeysAndValue.getNthKeyPart(), deepKeysAndValue.getValue());
    }

    private static void addMapForKeyPartIfDoesNotExistAlready(final String keyPart, final Map<String, Object> mapToCheckAndAddSubMapIn) {
        if (!mapToCheckAndAddSubMapIn.containsKey(keyPart)) {
            mapToCheckAndAddSubMapIn.put(keyPart, new HashMap<>());
        }
    }

}

class DeepKeysAndValue {
    private final List<String> keyParts;
    private final String value;

    DeepKeysAndValue(final String keyValueString) {
        final String[] keyAndValue = keyValueString.split(":");
        final String key = keyAndValue[0].trim();
        value = keyAndValue[1].trim();
        keyParts = Arrays.asList((key.split("\\.")));
    }

    List<String> getNMinus1KeyParts() {
        return keyParts.subList(0, keyParts.size() - 1);
    }

    String getNthKeyPart() {
        return keyParts.get(keyParts.size() - 1);
    }

    String getValue() {
        return value;
    }
}
