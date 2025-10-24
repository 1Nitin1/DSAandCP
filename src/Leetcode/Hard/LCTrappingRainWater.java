package Leetcode.Hard;

public class LCTrappingRainWater {
    public int trap(int[] height) {
        int leftmax = Integer.MIN_VALUE;
        int rightmax = Integer.MIN_VALUE;
        int low=0;
        int high = height.length-1;
        int water = 0;
        while(low<high){
            if(height[low]<=height[high]){
                if(leftmax<height[low]){
                    leftmax=height[low];
                }else{
                    water+=leftmax-height[low];
                }
                low++;
            }else{
                if(rightmax<height[high]){
                    rightmax=height[high];
                }else{
                    water+=rightmax-height[high];
                }
                high--;
            }
        }
        return water;
    }
}
