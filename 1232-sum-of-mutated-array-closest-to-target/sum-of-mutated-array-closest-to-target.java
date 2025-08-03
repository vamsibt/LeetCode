class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int i= 0;
        int j = arr[n-1];
        int min = target;
        int minVal = Integer.MAX_VALUE;
        while(i<=j){
            int mid = i+ (j-i)/2;
            int sum =0;
            int k=0;
            while(arr[k]< mid){
                sum += arr[k];
                k++;
            }
            sum += mid*(n-k);

            if(sum <= target){
                i = mid+1;
            } else{
                j = mid-1;
            }

            if(Math.abs(target-sum) <= min){
                if(Math.abs(target-sum) == min){
                    minVal = Math.min(mid, minVal);
                } else{
                    min = Math.abs(target-sum);
                    minVal = mid;
                }
            }
        }

        return minVal;
    }
}