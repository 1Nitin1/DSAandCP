package Leetcode.Medium;

public class LCMinimumOperationstoTransformArray {
    public long minOperations(int[] nums1, int[] nums2) {
        int closest=nums1[0];
        long ans=0;

        int x = nums2[nums2.length-1];
        int bestDiff=Math.abs(nums1[0]-x);
        for(int i=0;i<nums1.length;i++){
            ans += Math.abs(nums1[i] - nums2[i]);

            int low = Math.min(nums1[i], nums2[i]);
            int high = Math.max(nums1[i], nums2[i]);
            int diff;
            if (x >= low && x <= high) diff = 0;
            else diff = Math.min(Math.abs(nums1[i] - x), Math.abs(nums2[i] - x));

            if (diff < bestDiff) {
                bestDiff = diff;
                closest = (diff == 0 ? x : (Math.abs(nums1[i] - x) < Math.abs(nums2[i] - x) ? nums1[i] : nums2[i]));
            }
        }
        ans+=Math.abs(closest-x);
        return ans+1;
    }
}
