package GraphAlgos;

import java.util.*;
import static GraphAlgos.A_Representation.getDirectedGraph;
import static GraphAlgos.A_Representation.getUndirectedGraph;

public class B_BFS {

    public static void main(String[] args) {
        // bfs for undirected graph
        Map<Integer, ArrayList<Integer>> map = getUndirectedGraph();
        int n = map.size();
        List<Integer> ans = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        // for loop for multiple components
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.addAll(bfs(map, i, vis));
            }
        }
        System.out.println(ans);

//         bfs for directed graph
        map = getDirectedGraph();
        n = map.size();
        ans.clear();
        vis.clear();
        // for loop for multiple components
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.addAll(bfs(map, i, vis));
            }
        }
        System.out.println(ans);
    }

    public static List<Integer> bfs(Map<Integer, ArrayList<Integer>> map, int s, Set<Integer> vis) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        vis.add(s);
        q.add(s);
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            map.get(node).forEach(item -> {
                if (!vis.contains(item)) {
                    q.add(item);
                    vis.add(item);
                }
            });
        }
        return ans;
    }
}
