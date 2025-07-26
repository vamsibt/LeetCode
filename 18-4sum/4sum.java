class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1; j<nums.length; j++){

                if(j> i+1 && nums[j] == nums[j-1]) continue;
                
                int k= j+1;
                int m = nums.length-1;

                while(k<m){
                    List<Integer> temp = new ArrayList<>();
                    long sum = (long) nums[i]+nums[j]+nums[k]+nums[m];
                    if(sum < target){
                        k++;
                    } else if(sum > target){
                        m--;
                    } else{

                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));

                        while(k< m && nums[k] == nums[k+1]) k++;
                        while(k< m && nums[m] == nums[m-1]) m--;

                        k++;
                        m--;
                    }
                }
            }
        }

        return result;
    }
}