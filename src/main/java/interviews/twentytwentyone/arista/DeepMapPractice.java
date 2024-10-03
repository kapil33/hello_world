package interviews.twentytwentyone.arista;

import java.util.*;

public class DeepMapPractice {

    private static List<String> createFlatMap(){
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

    public static Map<String, Object> deepMap(List<String> flatMap){
        Map<String, Object> result = new HashMap<>();

        for (String entry: flatMap){
            String[] keyAndValue = entry.split(":");
            String key = keyAndValue[0].trim();
            String value = keyAndValue[1].trim();
            String[] keyParts = key.split("\\.");
            Map<String, Object> loopMap = result;

            for (int i=0; i<keyParts.length-1; i++){
                loopMap = (Map<String, Object>) loopMap.computeIfAbsent(keyParts[i], k -> new HashMap<String, Object>());
            }

            loopMap.put(keyParts[keyParts.length-1], value);
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println("Result is: \n" + deepMap(createFlatMap()));
    }
}
