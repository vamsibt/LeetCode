class Solution {
    public double largestTriangleArea(int[][] points) {
        double area =0;
        for(int i = 0; i<points.length-2; i++){
            for(int j=i+1; j<points.length-1; j++){
                for(int k = j+1; k<points.length; k++){
                    double res = area(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]);
                    if(res > area){
                        area = res;
                    }
                }
            }
        }

        return area;
    }

    public double area(int x1, int y1, int x2, int y2, int x3, int y3){
        return (0.5)*Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
    }
}