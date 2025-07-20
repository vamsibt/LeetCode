class Solution {
    int count =0;
    public int reversePairs(int[] nums) {
        

        divide(nums, 0, nums.length-1);

        return count;
    }

    public void divide(int[] nums, int start, int end){
        if(start< end){
            int mid = start+(end-start)/2;

            divide(nums, start, mid );
            divide(nums, mid+1, end);

            conquer(nums, start, mid, end);
        }
        
    }

    public void conquer(int[] nums, int start, int mid, int end){
        int j =mid+1;
        for(int i=start; i<=mid; i++){
            while(j<=end && (long)nums[i]> 2L*nums[j]){
                j++;
            }

            count += j-(mid+1);
        }

        List<Integer> list = new ArrayList<>();

        int left = start;
        int right = mid+1;

        while(left <= mid && right <= end){
            if(nums[left]< nums[right]){
                list.add(nums[left]);
                left++;
            } else{
                list.add(nums[right]);
                right++;
            }
        }

        while(left<= mid){
            list.add(nums[left]);
            left++;
        }
        while(right<=end){
            list.add(nums[right]);
            right++;
        }

        for(int i=start; i<=end; i++){
            nums[i] = list.get(i-start);
        }
    }
}