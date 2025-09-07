class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int idx =0;
        if(n%2 != 0){
            arr[idx++] = 0;
        }
        for(int i=1;idx<n && i<=n/2; i++){
            arr[idx++] = i;
            arr[idx++] = -i;
        }
        return arr;
    }
}