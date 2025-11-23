package my_practice.leet_code.Stack;

public class WaterTrap {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                ans += left_max - height[left];
                ++left;
            } else {
                right_max = Math.max(right_max, height[right]);
                ans += right_max - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WaterTrap obj = new WaterTrap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = obj.trap(height);
        System.out.println("The total amount of trapped water is: " + result);
    }
}

//      4,2,0,3,2,5
// lm   4,4,4,4,4,5
// rm   5,5,5,5,5,5
// w    0,2,4,1,2,0