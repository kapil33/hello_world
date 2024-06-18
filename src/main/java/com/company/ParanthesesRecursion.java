package com.company;

import java.util.ArrayList;
import java.util.List;

public class ParanthesesRecursion {
    public static int index;

    public static void directGenerateBalancedParentheses(int leftParens, int rightParens, String prefix, List<String> result) {
        if (leftParens == 0 && rightParens == 0) {
            result.add(prefix);
            System.out.println(index++ + " : " + result);
            return;
        }

        if (leftParens > 0)
            directGenerateBalancedParentheses(leftParens - 1, rightParens, prefix + "(", result);
        if (leftParens < rightParens)
            directGenerateBalancedParentheses(leftParens, rightParens - 1, prefix + ")", result);
    }

    public static void main(String[] args) {
        index = 0;
        List<String> result = new ArrayList<>();
        directGenerateBalancedParentheses(3, 3, "", result);
        System.out.println(result);
    }
}

