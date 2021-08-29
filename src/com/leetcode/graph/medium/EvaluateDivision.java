package com.leetcode.graph.medium;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1---------------------");
        List<List<String>> equations = new ArrayList<>();
        List<String> equations1 = new ArrayList<>();
        equations1.add("a");
        equations1.add("b");
        List<String> equations2 = new ArrayList<>();
        equations2.add("b");
        equations2.add("c");
        equations.add(equations1);
        equations.add(equations2);

        double [] values = {2.0,3.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");

        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");

        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");

        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");

        List<String> query5 = new ArrayList<>();
        query5.add("x");
        query5.add("x");

        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);

        double [] results = calcEquation(equations , values , queries);
        System.out.println("print Result : ");
        for (double result : results)
            System.out.println(result);
        System.out.println();
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = cosntructGraph(equations, values);

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++)
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), graph);

        return result;
    }

    private static double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> graph) {
        if (!(graph.containsKey(s) && graph.containsKey(d)))
            return -1.0;
        if (s.equals(d))
            return 1.0;

        visited.add(s);
        for (Node node : graph.get(s)) {
            if (!visited.contains(node.key)) {
                double ans = dfs(node.key, d, visited, graph);
                if (ans != -1.0)
                    return ans * node.val;
            }
        }

        return -1.0;
    }


    private static Map<String, List<Node>> cosntructGraph(List<List<String>> eq, double[] values) {
        Map<String, List<Node>> g = new HashMap();
        for (int i = 0; i < values.length; i++) {
            String src = eq.get(i).get(0);
            String des = eq.get(i).get(1);
            g.putIfAbsent(src, new ArrayList());
            g.putIfAbsent(des, new ArrayList());
            g.get(src).add(new Node(des, values[i]));
            g.get(des).add(new Node(src, 1 / values[i]));
        }
        return g;
    }

    static class Node {
        String key;
        double val;

        public Node(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }
}
