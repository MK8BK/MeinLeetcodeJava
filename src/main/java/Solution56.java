import java.util.*;

public class Solution56 {
    public static void main(String[] args) {
        int[][] r1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] r2 = new int[][]{{1,4},{4,5}};
        System.out.println(Arrays.deepToString(merge(r1)));
        System.out.println(Arrays.deepToString(merge(r2)));
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[][]{};
        var s =  Arrays.stream(intervals).sorted(Comparator.comparingInt(a -> a[0]));
        List<int[]> sortedIntervals = s.toList();
        int mergedIntervalStart = sortedIntervals.get(0)[0];
        int mergedIntervalEnd = sortedIntervals.get(0)[1];
        List<int[]> mergedIntervals = new ArrayList<>();
        for(int[] interval : sortedIntervals){
            if(interval[0]>mergedIntervalEnd) {
                mergedIntervals.add(new int[]{mergedIntervalStart, mergedIntervalEnd});
                mergedIntervalStart = interval[0];
                mergedIntervalEnd = interval[1];
            }else{
                mergedIntervalEnd = Math.max(interval[1], mergedIntervalEnd);
            }
        }
        mergedIntervals.add(new int[]{mergedIntervalStart, mergedIntervalEnd});
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
