package my_practice.leetcode_icc;

import my_practice.experiment.Test;

public class Recursion {
    public void function(int n) {
        if (n > 4) {
            return;
        }
        System.out.println(n);
        function(n + 1);
        System.out.println("End of the call with n = " + n);
        return;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.function(1);
    }
}
