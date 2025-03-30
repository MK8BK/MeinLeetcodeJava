public class Solution152 {
    public static void main(String[] args) {
        int[] example1 = {2,3,-2,4};
        int[] example2 = {-2,0,-1};
        System.out.println(maxProduct(example1));
        System.out.println(maxProduct(example2));
    }
    public static int maxProduct(int[] nums) {
        if(nums.length==0) return 1;
        int maxProd = nums[0];
        int minSofar = maxProd;
        int maxSofar = maxProd;
        int temp;
        int current;
        for(int i=1; i<nums.length; i++){
            temp = maxSofar;
            current = nums[i];
            maxSofar = Math.max(maxSofar*current, Math.max(current, minSofar*current));
            minSofar = Math.min(minSofar*current, Math.min(current, temp*current));
            maxProd = Math.max(maxSofar, maxProd);
        }
        return maxProd;
    }
}
