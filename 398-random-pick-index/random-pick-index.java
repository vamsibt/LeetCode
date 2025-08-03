class Solution {
    int[] nums;
    HashMap<Integer, ArrayList<Integer>> map;

    public Solution(int[] nums) {
        this.nums = new int[nums.length];
        this.map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            this.nums[i] = nums[i];
            ArrayList<Integer> temp;

            if(map.containsKey(nums[i])){
                temp = map.get(nums[i]);
            } else{
                temp = new ArrayList<>();
            }
            temp.add(i);
            map.put(nums[i], temp);
        }
    }
    
    public int pick(int target) {
        List<Integer> tar = map.get(target);
        int randomIdx = new Random().nextInt(tar.size());
        return tar.get(randomIdx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */