/*
package chegg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://www.jabberwocky.com/carroll/walrus.html").get();
        String doctext = doc.body().text();
        TreeMap<String, Integer> map = new TreeMap<>();

        Scanner in = new Scanner(doctext);
        in.useDelimiter("\\W+|\\d+");

        while (in.hasNext()){
            String word = in.next();
            word = word.toLowerCase();

            Integer count = map.get(word);
            if (count == null)
                map.put(word, 1);
            else
                map.put(word, count + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println("Word: " + entry.getKey() + " | Count: " + entry.getValue());

        return;
    }
}
*/
