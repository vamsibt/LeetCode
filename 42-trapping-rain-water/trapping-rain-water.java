class Solution {
    // public int trap(int[] height) {
    //     int l =0;
    //     int r = height.length -1;
    //     int lmax = Integer.MIN_VALUE;
    //     int rmax =Integer.MIN_VALUE;
    //     int water =0;
    //     while(l< r){
    //         lmax = Math.max(lmax, height[l]);
    //         rmax = Math.max(rmax, height[r]);
    //         if(lmax < rmax){
    //             water += lmax-height[l];
    //             l++;
    //         } else {
    //             water += rmax-height[r];
    //             r--;
    //         }
            
    //     }
    //     return water;
    // }

    public int trap(int[] height){
        int left =0;
        int right = height.length-1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int water =0;
        while(left< right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax){
                water += leftMax-height[left];
                left++;
            } else {
                water += rightMax- height[right];
                right--;
            }
        }
        return water;
    }
}