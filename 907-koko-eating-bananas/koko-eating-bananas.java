class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int i = 1;
        int j = piles[n-1];
        int min =j;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int count = 0;

            for (int k = 0; k < n; k++) {
                count += Math.ceil((double)piles[k] / mid);
            }
            if(count <= h){
                min = mid;
                j = mid-1;
            } else{
                i =mid+1;
            } 

        }

        return min;
    }
}