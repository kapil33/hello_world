/*
package gfg.interviews.amazon;

public class KthLargest {
}



    Given a running stream of numbers provide the Kth largest number with each insert.


        Input - { 10, 2, 4, 5, 20, 100, 7, ...}
        K = 3

        Output - { _, _, 2, 4, 5, 10, 10, ...}


class KthLargest{
    List<Integer> list;//descending order
    int k;

    public KthLargest(int k){
        list = new ArrayList<>();
        this.k = k;
    }

    public void insert(int val){
        if(list.size() >= k && list.get(list.size()-1) >= val)
            return;

        int i=0;
        for(; i<list.size(); i++){
            if(val > list.get(i))
                break;
        }
        Stack<Integer> stack = new Stack<>();
        int j = list.size()-i;
        while(j-- > 0){
            stack.push(list.get(list.size()-1));
            list.remove(list.size()-1);
        }
        list.add(val);
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
    }

    public String getKthLargest(){
        if(list.size() < k)
            return "_";
        return Integer.toString(list.get(k-1));
    }

    public static void main(String[] args){
        KthLargest kthLargest = new KthLargest(3);
        while(true){
            int val = kthLargest.getInput();
            kthLargest.insert(val);
            getKthLargest();
        }
    }
}*/
