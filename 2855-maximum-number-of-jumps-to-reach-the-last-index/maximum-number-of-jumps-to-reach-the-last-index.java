class Solution {
    public int maximumJumps(int[] nums, int target) {
        int steps = 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] =0;
        for(int i=1; i<n; i++){
            dp[i] = -1;
        }

        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(nums[j]-nums[i] >= -target && nums[j]-nums[i] <= target && dp[i]!=-1){
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                }
            }
        }

        return dp[n-1];


    }
}