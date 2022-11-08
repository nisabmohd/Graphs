package GraphAlgos;

import java.util.*;
import static GraphAlgos.GraphRepresentation.getDirectedGraph;
import static GraphAlgos.GraphRepresentation.getUndirectedGraph;

public class BFS {

    public static void main(String[] args) {
         // bfs for undirected graph
        Map<Integer, ArrayList<Integer>> map = getUndirectedGraph();
        int n = map.size();
        List<Integer> ans = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.addAll(bfs(map, i, vis));
            }
        }
        System.out.println(ans);
        
        
        
        // bfs for directed graph
        map = getDirectedGraph();
        n=map.size();
        ans.clear();
        vis.clear();
         for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.addAll(bfs(map, i, vis));
            }
        }
      System.out.println(ans);
    }

    private static List<Integer> bfs(Map<Integer, ArrayList<Integer>> map, int s, Set<Integer> vis) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        vis.add(s);
        q.add(s);
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            map.getOrDefault(s,new ArrayList<>()).forEach(item -> {
                if (!vis.contains(item)) {
                    q.add(item);
                    vis.add(item);
                }
            });
        }
        return ans;
    }
}