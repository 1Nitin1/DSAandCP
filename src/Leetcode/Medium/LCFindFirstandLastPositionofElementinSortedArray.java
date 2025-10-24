package Leetcode.Medium;

public class LCFindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];


        arr[0]=fsearch(nums,target);
        arr[1]=lsearch(nums,target);
        return arr;


    }
    public int fsearch(int[] nums,int target){
        int low = 0;
        int high=nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public int lsearch(int[] nums,int target){
        int low = 0;
        int high=nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
