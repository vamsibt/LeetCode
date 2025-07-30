class Solution {
    public int[] decompressRLElist(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i=i+2){
            count += nums[i];
        }
        int[] arr = new int[count];
        int j=0;
        for(int i=0; i<nums.length; i = i+2){
            int freq = nums[i];
            while(freq>0){
                arr[j] = nums[i+1];
                freq--;
                j++;
            }
        }
        return arr;
    }
}