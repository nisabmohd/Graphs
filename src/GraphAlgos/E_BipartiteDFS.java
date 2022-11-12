package GraphAlgos;

import java.util.*;

public class E_BipartiteDFS {

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> map = GraphAlgos.A__Representation.getUndirectedGraph();
        int n = map.size();
        Integer[] colours = new Integer[n];
        boolean flag = true;
        // null represnts uncoloured vertex
        for (int i = 0; i < n; i++) {
            if (colours[i] == null) {
                if (!color(i, 0, map, colours)) {
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

    private static boolean color(int s, int col, Map<Integer, ArrayList<Integer>> map, Integer[] colours) {
        colours[s] = col;
        for (int item : map.get(s)) {
            if (Objects.equals(colours[s], colours[item])) {
                return false;
            }
        }
        boolean ans = true;
        for (int item : map.get(s)) {
            if (colours[item] == null) {
                if (!color(item, col == 0 ? 1 : 0, map, colours)) {
                    return false;
                }
            }
        }
        return ans;
    }
}
