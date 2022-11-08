package GraphAlgos;

import static GraphAlgos.Representation.getDirectedGraph;
import static GraphAlgos.Representation.getUndirectedGraph;
import java.util.*;

public class DFS {

    public static void main(String[] args) {
        // dfs for undirected graph
        Map<Integer, ArrayList<Integer>> map = getUndirectedGraph();
        int n = map.size();
        List<Integer> ans = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        // for loop for multiple components
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.addAll(dfs(map, i, vis));
            }
        }
        System.out.println(ans);

        // dfs for directed graph
        map = getDirectedGraph();
        n = map.size();
        ans.clear();
        vis.clear();
        // for loop for multiple components
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.addAll(dfs(map, i, vis));
            }
        }
        System.out.println(ans);
    }

    private static List<Integer> dfs(Map<Integer, ArrayList<Integer>> map, int s, Set<Integer> vis) {
        List<Integer> ans = new ArrayList<>();
        vis.add(s);
        ans.add(s);
        map.getOrDefault(s, new ArrayList<>()).forEach(item -> {
            if (!vis.contains(item)) {
                ans.addAll(dfs(map, item, vis));
            }
        });
        return ans;
    }

}
