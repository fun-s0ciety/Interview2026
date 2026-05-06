import java.util.Collections;
import java.util.PriorityQueue;

public class LC1046 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int nums[] = {2,7,4,1,8,1};
        for (int n : nums) {
            pq.add(n);
        }
        
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (y <= x) pq.add(x-y);
        }

        System.out.println(pq.peek());
    }
}
