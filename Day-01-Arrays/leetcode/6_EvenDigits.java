class Solution {
    public int findNumbers(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            int cnt=0;
            int num=nums[i];
            while(num>0){
                cnt++;
                num=num/10;
            }
            if(cnt%2==0){
                res++;
            }
        }
        return res;
    }
}