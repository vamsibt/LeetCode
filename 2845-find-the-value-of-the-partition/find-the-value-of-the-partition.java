class Solution {
    public int findValueOfPartition(int[] nums) {
        long diff =Long.MAX_VALUE;

        Arrays.sort(nums);

        for(int i=1; i<=nums.length-1; i++){
            if(nums[i]- nums[i-1] < diff){
                diff = nums[i]-nums[i-1];
            }
        }

        return (int)diff;
    }
}