package my_practice.leet_code.Number;

public class AddDigits {
    public int addDigits(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        AddDigits solution = new AddDigits();
        System.out.println(solution.addDigits(38)); // Output: 2
        System.out.println(solution.addDigits(0));  // Output: 0
        System.out.println(solution.addDigits(9));  // Output: 9
        System.out.println(solution.addDigits(123)); // Output: 6
    }
}

/*Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.

Example 2:
Input: num = 0
Output: 0

Constraints:
0 <= num <= 231 - 1

Follow up: Could you do it without any loop/recursion in O(1) runtime?*/