class Solution {
    public boolean isPalindrome(int x) {
        int num=0;
        int temp =x;
        while(temp>0){
            int r = temp%10;
            num = num*10 + r;
            temp = temp/10;
        }
        return x==num ? true: false;
    }
}