class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0;
        int maxC = 0;
        for(int i: nums){
            if(i == 1){
                count++;
            } else{
                maxC = Math.max(maxC, count);
                count =0;
            }
        }

        maxC = Math.max(maxC, count);

        return maxC;
    }
}