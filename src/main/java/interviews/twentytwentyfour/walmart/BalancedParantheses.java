package interviews.twentytwentyfour.walmart;

import java.util.ArrayList;
import java.util.List;

public class BalancedParantheses {
    /*
    * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    Example 2:
    Input: n = 1
    Output: ["()"]
    *
    * n=2: (()), ()()
    * n=4: (((()))), (()()()), ((()())), (())(()), ((()))()
    * */

    private void dfs(String str, int n, int open, int close, List<String> result) {
        if (str.length() == 2*n) {
            result.add(str);
            return;
        }

        if (open < n)
            dfs(str + "(", n, open+1, close, result);
        if (close < open)
            dfs(str +")", n, open, close+1, result);
    }

    public void generateParanthese(int n) {
        List<String> result = new ArrayList<>();
        dfs("", n, 0, 0, result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BalancedParantheses balancedParantheses = new BalancedParantheses();
        balancedParantheses.generateParanthese(2);
        balancedParantheses.generateParanthese(3);
        balancedParantheses.generateParanthese(4);
    }
}
