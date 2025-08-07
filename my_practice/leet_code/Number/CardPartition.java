package my_practice.leet_code.Number;

public class CardPartition {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] freq = new int[10000]; // According to constraints: 0 <= deck[i] < 10^4
        for (int card : deck) {
            freq[card]++;
        }
        int gcd = 0;
        for (int f : freq) {
            if (f > 0) {
                if (gcd == 0) {
                    gcd = f;
                } else {
                    gcd = manualGCD(gcd, f);
                }
            }
        }
        return gcd > 1;
    }

    // Manual GCD implementation (Euclidean algorithm)
    private int manualGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Example usage
    public static void main(String[] args) {
        CardPartition cp = new CardPartition();
        int[] deck1 = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] deck2 = {1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(cp.hasGroupsSizeX(deck1)); // Output: true
        System.out.println(cp.hasGroupsSizeX(deck2)); // Output: false
    }
}

/*You are given an integer array deck where deck[i] represents the number written on the ith card.
Partition the cards into one or more groups such that:

Each group has exactly x cards where x > 1, and
All the cards in one group have the same integer written on them.
Return true if such partition is possible, or false otherwise.

Example 1:
Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:
Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.

Constraints:
1 <= deck.length <= 104
0 <= deck[i] < 104*/