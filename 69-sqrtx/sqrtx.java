class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int answer = 0;

        while(left<=right){
            int mid = left+(right-left)/2;
            long sqr = (long) mid*mid;
            if(sqr == x) return mid;
            else if(sqr < x){
                answer = mid;
                left = mid+1;
            }else if(sqr > x){
                right = mid-1;
            }
        }

        return answer;

    }
}