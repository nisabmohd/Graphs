package GraphAlgos;

import static GraphAlgos.C_DFS.dfs;
import static GraphAlgos.B_BFS.bfs;
import static GraphAlgos.A_Representation.getDirectedGraph;
import static GraphAlgos.A_Representation.getUndirectedGraph;
import java.util.*;

public class D_ConnectedComponents {

    public static void main(String[] args) {
        
        // connected components search for undirected graph using dfs
        Map<Integer, ArrayList<Integer>> map = getUndirectedGraph();
        int n = map.size();
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.add(dfs(map, i, vis));
            }
        }
        System.out.println(ans);

        // connected components search for undirected graph using bfs
        ans.clear();
        vis.clear();
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.add(bfs(map, i, vis));
            }
        }
        System.out.println(ans);

        // connected components search for directed graph using dfs
        map = getDirectedGraph();
        ans.clear();
        vis.clear();
        n = map.size();
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.add(dfs(map, i, vis));
            }
        }
        System.out.println(ans);

        // connected components search for directed graph using bfs
        ans.clear();
        vis.clear();
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                ans.add(bfs(map, i, vis));
            }
        }
        System.out.println(ans);
    }
}
