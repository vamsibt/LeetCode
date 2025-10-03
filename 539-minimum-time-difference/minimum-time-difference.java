class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        Collections.sort(timePoints, (a,b)->{
           String[] A = a.split(":");
           String[] B = b.split(":");

           int HourA = Integer.parseInt(A[0]);
           int MinA  = Integer.parseInt(A[1]);

           int HourB = Integer.parseInt(B[0]);
           int MinB = Integer.parseInt(B[1]);

           if(HourA != HourB){
            return HourA - HourB;
           } else{
            return MinA - MinB;
           }
        });

        String[] maxTime = timePoints.get(n-1).split(":");
        String[] minTime = timePoints.get(0).split(":");

        int diff = (23-Integer.parseInt(maxTime[0]))*60 + 
                    (60 - Integer.parseInt(maxTime[1]))+
                    (Integer.parseInt(minTime[0])*60)+
                    (Integer.parseInt(minTime[1]));

        for(int i=0; i<n-1; i++){
            if(timePoints.get(i). equals(timePoints.get(i+1))){
                return 0;
            }
            String[] local1 = timePoints.get(i).split(":");
            String[] local2 = timePoints.get(i+1).split(":");
            int local1H = Integer.parseInt(local1[0]);
            int local1M = Integer.parseInt(local1[1]);
            int local2H = Integer.parseInt(local2[0]);
            int local2M = Integer.parseInt(local2[1]);

            int hourDiff = local2H - local1H > 12 ? 24-(local2H-local1H) : local2H-local1H;

            int minDiff = local2H- local1H > 12 ? local1M- local2M : local2M - local1M;

            int totalDiff = hourDiff*60 + minDiff;

            if(totalDiff < diff){
                diff = totalDiff;
            }
        }
        

        return diff;
    }
}