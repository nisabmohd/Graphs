package GraphAlgos;

import java.util.*;

public class I_DetectCycleDG_DFS {

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> map = GraphAlgos.A__Representation.getDirectedGraph();
        int n = map.size();
        Set<Integer> vis = new HashSet<>();
        Set<Integer> rec = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                if (hasCycle(map, i, vis, rec)) {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("Has Cycle");
        } else {
            System.out.println("No cycle");
        }
    }

    public static boolean hasCycle(Map<Integer, ArrayList<Integer>> map, int s, Set<Integer> vis, Set<Integer> rec) {
        vis.add(s);
        rec.add(s);
        for (int item : map.get(s)) {
            if (!vis.contains(item)) {
                if (hasCycle(map, item, vis, rec)) {
                    return true;
                }
            } else if (rec.contains(item)) {
                return true;
            }
        }
        return false;
    }
}
