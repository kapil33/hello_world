package interviews.twentytwentyfour.sprinklr;

public class Round1 {
    /*
    *




Given two BST. Merge into single BST.

		5
  3		7
 2 4 6

 		4
	1		8

  -> L-> N -> R
   = 2,3,4,5,6,7 : 1,4,8
   = 1,2,3,4,4,5,6,7,8

   O(m + n + (m+nlog(m+n)) + m + n) = if m=n then O(nlogn)

   1
   	2
     3

===================================

HashMap {
	value get(key); O(1)

	void put(key, value); O(1)

	// additional
	void putAll(value); // updates all existing keys in the map with this value O(1)
}


MyMap m = new MyMap();

m.put(1, 11);
m.put(2, 13);

m.get(1); -> 11
m.get(2); -> 13

m.putAll(21);
m.put(2, 14);

m.get(1) -> 21
m.get(2) -> 14

m.putAll(41);

m.get(1) -> 41
m.get(2) -> 41
m.get(3) -> null


  GlobalValue=41, set=[]

  1->1
  2->13
  putAll
  2-> 14

*******************************
  1. How does garbage collection work?
  2. What is virtual memory?
  3. There is a threadpool with n no. of threads then who manages the thread lifecycle? OS or JVM?
  4. What is a daemon thread?

    * */
}