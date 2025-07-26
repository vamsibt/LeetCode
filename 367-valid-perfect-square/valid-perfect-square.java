class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }

        int i= 0;
        int j= num;
        while(i<j){
            long mid =(long) i+ (j-i)/2;
            if(mid*mid < num){
                i = (int)mid+1;
            }
            else if(mid*mid > num){
                j = (int)mid;
            } else{
                return true;
            }
            
        }
        return false;
    }
}