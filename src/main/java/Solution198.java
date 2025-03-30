public class Solution198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] R = new int[nums.length+1];
        R[0] = 0;
        R[1] = nums[0]; // assuming positive rewards at each house
        int ti;
        for(int i=2; i<=nums.length; i++){
            ti = nums[i-1];
            R[i] = Math.max(ti+R[i-2], R[i-1]);
        }
        return R[nums.length];
    }
}
