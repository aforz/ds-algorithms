package my_practice.stack;

// Problem: https://platform.bosscoderacademy.com/course/1YtfAvmdVrhPWJ9ylcc5/assignment/coding?problemId=expression_reduntant_bracket
class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n + 1];
        int top = -1, maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // add dummy 0 at end
            while (top >= 0 && h < heights[stack[top]]) {
                int height = heights[stack[top--]];
                int width = (top == -1) ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++top] = i;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram solver = new LargestRectangleHistogram();
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + solver.largestRectangleArea(heights1)); // Output: 10

        int[] heights2 = {2, 4};
        System.out.println("Largest Rectangle Area: " + solver.largestRectangleArea(heights2)); // Output: 4
    }
}
