package interviews.arista;

/*
Below is the data structure question: convert a flat map(given as a list of string) into a deep map.

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

import java.util.*;

public class DeepMap {

    private static List<String> createFlatMap(){
        List<String> list = new ArrayList<>();
        /*list.add("customer.id : 100-E");
        list.add("customer.firstname : Mike");
        list.add("customer.lastname : Smith");
        list.add("customer.address.street : 123 Pine Street");
        list.add("customer.address.city : San Francisco");
        list.add("customer.address.state : CA");
        list.add("customer.address.zip : 94131");*/
        list.add("customer.order.id: O-123");
        list.add("customer.order.total : 500.32");
        /*list.add("customer.order.date : 2020-01-01");
        list.add("customer.order.product.id : p-123");
        list.add("customer.order.product.description : washer");*/

        return list;
    }

    private static Map<String,Object> deepMap(final List<String> flatMap){
        Map<String, Object> result = new HashMap<>();

        for (String entry: flatMap){
            System.out.println("Entry: " + entry);
            String[] keyAndValue = entry.split(":");
            String key = keyAndValue[0].trim();
            String value = keyAndValue[1].trim();
            String[] keyParts = key.split("\\.");
            Map<String, Object> loopMap = result;
            System.out.println(result);

            for (int i=0; i<keyParts.length-1; i++){
                Map<String, Object> newLoopMap;
                if (!loopMap.containsKey(keyParts[i])){
                    newLoopMap = new HashMap<>();
                    loopMap.put(keyParts[i], newLoopMap);
                    System.out.println("Inside if clause: loopMap: " + loopMap);
                }
                else{
                    newLoopMap = (Map<String, Object>) loopMap.get(keyParts[i]);
                    System.out.println("Inside else clause: newLoopMap: " + newLoopMap);
                }

                loopMap = newLoopMap;
                System.out.println("LoopMap after KeyPart '" + keyParts[i] + "' : " + loopMap);
                System.out.println("Result after KeyPart '" + keyParts[i] + "' : " + result);
            }

            loopMap.put(keyParts[keyParts.length-1], value);
            System.out.println("LoopMap after for loop '" + keyParts[keyParts.length-1] + "' : " + loopMap);

            System.out.println("Result after Key '" + key + "' : " + result);
            System.out.println("\n**************************\n");
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println("Result is: \n" + deepMap(createFlatMap()));
    }
}
