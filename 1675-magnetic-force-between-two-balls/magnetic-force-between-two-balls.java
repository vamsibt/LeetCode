class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int high = position[position.length-1]- position[0];
        int low = 1;
        int ans =0;

        while(low <=high){
            int mid = low+(high-low)/2;
            if(canBePlaced(mid, m,position)){
                ans = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return  ans;
    }

    public boolean canBePlaced(int mid, int m, int[] pos){
        int count =1;
        int lastplaced = pos[0];
        for(int i=1; i<pos.length; i++){
            if(pos[i] - lastplaced >= mid){
                count++;
                lastplaced = pos[i];
            }
            if(count >= m){
                return true;
            }
        }
        return false;
    }

}