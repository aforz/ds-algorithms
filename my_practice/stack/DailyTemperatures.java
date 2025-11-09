package my_practice.stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        int[] stack = new int[n]; // store indexes
        int top = -1;

        for (int i = 0; i < n; i++) {
            // While the stack is not empty and current temp is warmer than the temp at the index on top of the stack
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                answer[idx] = i - idx;
            }
            stack[++top] = i;
        }
        // For all remaining indexes in stack, answer[] is already 0
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures solver = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solver.dailyTemperatures(temperatures);
        // Expected output: [1, 1, 4, 2, 1, 1, 0, 0]
        for (int days : result) {
            System.out.print(days + " ");
        }

        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = solver.dailyTemperatures(temperatures2);
        // Expected output: [1, 1, 1, 0]
        System.out.println();
        for (int days : result2) {
            System.out.print(days + " ");
        }
    }
}
