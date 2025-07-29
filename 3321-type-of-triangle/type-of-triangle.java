class Solution {
    public String triangleType(int[] nums) {
        //Equilateral
        if(nums[0] == nums[1] && nums[1] == nums[2]){
            return "equilateral";
        }
        //Isosceles
        else if(nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0]){
            if(nums[0]+ nums[1] > nums[2] && nums[1]+nums[2] > nums[0] && nums[2]+nums[0] > nums[1]){
                return "isosceles";
            }
            return "none";

        }
        //Scalene
        else if(nums[0]+ nums[1] > nums[2] && nums[1]+nums[2] > nums[0] && nums[2]+nums[0] > nums[1]){
            return "scalene";
        } else{
            return "none";
        }
        
    }
}