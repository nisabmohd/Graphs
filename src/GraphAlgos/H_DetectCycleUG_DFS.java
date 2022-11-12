package GraphAlgos;

import java.util.*;

public class H_DetectCycleUG_DFS {

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> map = GraphAlgos.A_Representation.getUndirectedGraph();
        Set<Integer> vis = new HashSet<>();
        int n = map.size();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (hasCycle(map, i, n, vis)) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println("Contains Cycle");
        } else {
            System.out.println("Does not contains cycle");
        }

    }

    public static boolean hasCycle(Map<Integer, ArrayList<Integer>> map, int source, int parent, Set<Integer> vis) {
        if (vis.contains(source)) {
            return true;
        }
        vis.add(source);
        for (int item : map.get(source)) {
            if (item != parent) {
                if (hasCycle(map, item, source, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}
