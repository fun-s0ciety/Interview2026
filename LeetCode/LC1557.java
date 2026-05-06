import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1557 {
    
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int indegree[] = new int[n];

        for (List<Integer> edge : edges) indegree[edge.getLast()]++;

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i<indegree.length; i++) {
            if (indegree[i] == 0) res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = new ArrayList<>(Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(0, 2),
            Arrays.asList(2, 5),
            Arrays.asList(3, 4),
            Arrays.asList(4, 2)
        ));

        System.out.println(findSmallestSetOfVertices(n, edges));
    }
    
}
