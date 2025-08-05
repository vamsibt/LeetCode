class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int total = 1<<n;
        for(int i=0; i<total; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<n; j++){
                if((i & (1 << j)) != 0){
                    temp.add(nums[j]);
                }
            }
            result.add(temp);
        }

        return result;
    }
}