class Solution {
    public int longestOnes(int[] nums, int k) {
        int start =0;
        int end =0;
        int res =0;
        int count =0;
        while(end < nums.length){
            if(nums[end] == 0){
                count++;
            }

            while(count > k){
                if(nums[start] == 0){
                    count--;
                }
                start++;
            }

            res = Math.max(res, end-start+1);
            end++;
        }

        return res;
    }
}