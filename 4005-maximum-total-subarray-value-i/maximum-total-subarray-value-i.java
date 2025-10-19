class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for(int num: nums){
            if(num > max){
                max = num;
            } 
            if(num< min){
                min = num;
            }
        }

        long diff = max-min;

        return k*diff;
    }
}