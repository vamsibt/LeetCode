class Solution {
    // public int[][] rotateGrid(int[][] grid, int k) {
    //     while (k > 0) {
    //         int top = 0;
    //         int bottom = grid.length - 1;
    //         int left = 0;
    //         int right = grid[0].length - 1;

    //         while (top < bottom && left < right) {
    //             int temp = grid[top][left];
    //             //top
    //             for (int i = left; i < right; i++) {
    //                 grid[top][i] = grid[top][i + 1];
    //             }

    //             //right
    //             for (int i = top; i < bottom; i++) {
    //                 grid[i][right] = grid[i + 1][right];
    //             }

    //             //bottom
    //             for (int i = right; i > left; i--) {
    //                 grid[bottom][i] = grid[bottom][i - 1];
    //             }

    //             //left
    //             for (int i = bottom; i > top; i--) {
    //                 if (i == top + 1) {
    //                     grid[i][left] = temp;
    //                 } else {
    //                     grid[i][left] = grid[i - 1][left];
    //                 }

    //             }

    //             top++;
    //             left++;
    //             bottom--;
    //             right--;
    //         }
    //         k--;
    //     }

    //     return grid;

    // }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m,n)/2;

        for(int l = 0; l< layers; l++){
            List<Integer> layer = new ArrayList<>();
            int top = l;
            int left = l;
            int bottom = m-l-1;
            int right = n-l-1;

            //top
            for(int i=left; i<right; i++){
                layer.add(grid[top][i]);
            }

            //right
            for(int i = top; i<bottom; i++){
                layer.add(grid[i][right]);
            }

            //bottom
            for(int i=right; i> left; i--){
                layer.add(grid[bottom][i]);
            }

            //left
            for(int i= bottom; i> top; i--){
                layer.add(grid[i][left]);
            }

            int size = layer.size();
            int idx = k%size;

            List<Integer> rotated = new ArrayList<>();
            rotated.addAll(layer.subList(idx, size));
            rotated.addAll(layer.subList(0, idx));

            //top
            int j=0;
            for(int i=left; i<right; i++){
                grid[top][i] = rotated.get(j++);
            }

            //right
            for(int i = top; i<bottom; i++){
                grid[i][right] = rotated.get(j++);
            }

            //bottom
            for(int i=right; i> left; i--){
                grid[bottom][i] = rotated.get(j++);
            }

            //left
            for(int i= bottom; i> top; i--){
                grid[i][left] = rotated.get(j++);
            }

        }

        return grid;
    }
    
}