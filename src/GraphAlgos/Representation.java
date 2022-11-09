package GraphAlgos;

import java.util.*;

public class Representation {
    // check out graph implementation in my data structure repo link : 
    // https://github.com/nisabmohd/Data-Structures/tree/master/src/Graphs

    // We wil be using this graphs for entire graph theory for avoiding creation of graph every single time
    private static final Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static Map<Integer, ArrayList<Integer>> getDirectedGraph() {
        //    0 -> {1}
        //    1 -> {2}
        //    2 -> {0}
        //    3 -> {4}
        //    4 -> {}
        map.clear();
        map.put(0, new ArrayList<>(Arrays.asList(1)));
        map.put(1, new ArrayList<>(Arrays.asList(2)));
        map.put(2, new ArrayList<>(Arrays.asList(0)));
        map.put(3, new ArrayList<>(Arrays.asList(4)));
        map.put(4, new ArrayList<>());
        return map;
    }

    public static Map<Integer, ArrayList<Integer>> getUndirectedGraph() {
        //    0 -> {1,2}
        //    1 -> {0,4}
        //    2 -> {0,3}
        //    3 -> {2,4}
        //    4 -> {3,1}
        //    5 ->  {6}
        //    6 ->  {5}
        map.clear();
        map.put(0, new ArrayList<>(Arrays.asList(1, 2)));
        map.put(1, new ArrayList<>(Arrays.asList(0, 4)));
        map.put(2, new ArrayList<>(Arrays.asList(0, 3)));
        map.put(3, new ArrayList<>(Arrays.asList(2, 7)));
        map.put(4, new ArrayList<>(Arrays.asList(7, 1)));
        map.put(5, new ArrayList<>(Arrays.asList(6)));
        map.put(6, new ArrayList<>(Arrays.asList(5)));
        map.put(7, new ArrayList<>(Arrays.asList(4, 3)));

        return map;
    }
}
