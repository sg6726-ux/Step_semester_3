package Searching_Sorting.class_problems;
public class MaxContainerArea {
    static int maxContainerArea(int[] heights) {
        int left = 0, right = heights.length - 1, max = 0;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int area = height * (right - left);
            max = Math.max(max, area);
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights));
    }
}