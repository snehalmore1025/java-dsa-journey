class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i =0; i<nums.length;i++){
            int temp=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(temp==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}