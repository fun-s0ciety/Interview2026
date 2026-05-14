import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC2784 {

    public static boolean isGood(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        for(int n : nums) {
            max = Math.max(max, n);
            if (set.contains(n)) {
                if (n != nums.length-1) return false;
                maxCount++;
            }
            else {
                set.add(n);
            }
        }
        return max+1 == nums.length && maxCount == 1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 4, 4, 3, 2};
        System.out.println(isGood(nums));
    }
}
