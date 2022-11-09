package GraphAlgos;

import static GraphAlgos.Representation.getUndirectedGraph;
import java.util.*;

public class BipartiteBFS {

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> map = getUndirectedGraph();
        int n = map.size();
        Integer[] colours = new Integer[n];
        boolean flag = true;
        // null represnts uncoloured vertex
        for (int i = 0; i < n; i++) {
            if (colours[i] == null) {
                if (!color(map, i, colours)) {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("Unable to color the graph");
        } else {
            System.out.println(Arrays.toString(colours));
        }
    }

    private static boolean color(Map<Integer, ArrayList<Integer>> map, int s, Integer[] colours) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        colours[s] = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            for (int item : map.get(node)) {
                if (colours[item] == null) {
                    colours[item] = colours[node] == 1 ? 0 : 1;
                    q.add(item);
                } else if (colours[item] == colours[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
