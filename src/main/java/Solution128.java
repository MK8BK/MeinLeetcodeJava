import java.util.*;


class Solution128 {
    public static void main(String[] args) {
        int res = longestConsecutive(new int[]{100,4,200,1,3,2});
        System.out.println(res);
    }
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {s.add(num);}
        int longest = -1;
        int cnt;
        for (int num : nums) {
            if(s.contains(num-1))
                continue;
            cnt = 1;
            int x = num;
            while(s.contains(x+1)){
                cnt++;
                x++;
                s.remove(x);
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}