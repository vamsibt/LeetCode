class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest =Integer.MAX_VALUE;
        int result=0;
        for(int i=0; i<nums.length; i++){
            int j=i+1;
            int k =nums.length-1;
            while(j<k){
                int sum =nums[i]+nums[j]+nums[k];
                if(sum> target){
                    k--;
                } else if(sum < target){
                    j++;
                } else{
                    result = sum;
                    return result;
                }
                if( Math.abs(target-sum)< closest){
                    closest = Math.abs(target-sum);
                    result = sum;
                }
            }

            
        }
        return result;
    }
}