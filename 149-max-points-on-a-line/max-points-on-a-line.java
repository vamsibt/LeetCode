class Solution {
    // public int maxPoints(int[][] points) {
    //     if(points.length <= 1){
    //         return points.length;
    //     }
        
    //     HashMap<Double, Integer> map = new HashMap<>();

    //     for(int i=0; i<points.length; i++){
    //         for(int j=i+1; j<points.length; j++){
    //             double slop =  slope(points[i], points[j]);
    //             if(slop == Double.MAX_VALUE ) continue;
    //             map.put(slop, map.getOrDefault(slop, 0)+1);
    //         }
    //     }
    //     int result =0;

    //     for(int val: map.values()){
    //         result = Math.max(result,val);
    //     }

    //     return result;

    // }

    


    // public double slope(int[] a, int[] b){
    //     if(b[0]-a[0]> 0){
    //         return (b[1]-a[1])/(b[0]-a[0]);
    //     }

    //     return Double.MAX_VALUE;
       
    // }

    public int maxPoints(int[][] points) {
        if(points.length <= 2){
            return points.length;
        }
        
        int maxPoints=0;
        for(int i=0; i<points.length; i++){
            HashMap<Double, Integer> map = new HashMap<>();
            int same = 0;
            int vertical = 0;
            int local = 0;
            for(int j=0; j<points.length; j++){
                if(i == j) continue;

                int y = points[j][1] - points[i][1];
                int x = points[j][0] - points[i][0];
                if(y == 0 && x == 0){
                    same++;
                } else if(x==0){
                    vertical++;
                } else{
                    double slope =(double)y/x;

                    map.put(slope, map.getOrDefault(slope, 0)+1);
                    local = Math.max(local, map.get(slope));
                }

                
            }
            local = Math.max(local, vertical);
            maxPoints = Math.max(maxPoints, local+same+1);
        }

        return maxPoints;
        

    }

    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(a, a%b);
    }

    


    
}