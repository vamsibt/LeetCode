class Solution {
    public int maxScore(String s) {
        int maxCount =0;
        int leftCount = 0;
        int rightCount = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') rightCount++;
        }
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == '0'){
                leftCount++;
            } else{
                rightCount--;
            }

            maxCount = Math.max(leftCount+rightCount, maxCount);
        }

        return maxCount;
    }
}