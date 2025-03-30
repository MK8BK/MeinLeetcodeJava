public class Solution55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJumpBetter(new int[]{2,3,1,1,4}));
        System.out.println(canJumpBetter(new int[]{3,2,1,0,4}));
    }
    public static boolean canJumpBetter(int[] nums){
        int gas = 0;
        for(int n : nums){
            if(gas<0) return false;
            else if (n>gas) gas = n;
            gas--;
        }
        return true;
    }
    public static boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        boolean flag; // if got true inside
        for(int i=1; i<nums.length; i++){
            canReach[i] = false;
            for(int j=i-1; j>=0; j--){
                if(canReach[j] && nums[j] >= i-j){
                    canReach[i] = true;
                    break;
                }
            }
            if(!canReach[i]) return false;
        }
        return true;
    }
}
