package com.kar.algoexpert.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class OutcoPractice {
    public static void main(String[] args) {
        int vertices = 7;
        char[][] edges = {{'A', 'B'}, {'A', 'C'}, {'A', 'D'}, {'B', 'E'}, {'C', 'F'}, {'D', 'G'}, {'E', 'G'}, {'F', 'G'}};
        

        
    }

    private static Map<Character, List<Character>> adjacencyMap(char[][] edges) {
        Map<Character, List<Character>> adjacencyMap = new HashMap<>();

        for(char[] edge: edges) {
            System.out.println(edge[0] + " " + edge[1]);
            if(!adjacencyMap.containsKey(edge[0])) {
                adjacencyMap.put(edge[0], new ArrayList<>(Arrays.asList(edge[1])));
            } else {
                adjacencyMap.get(edge[0]).add(edge[1]);
            }

            if(!adjacencyMap.containsKey(edge[1])) {
                adjacencyMap.put(edge[1], new ArrayList<>(Arrays.asList(edge[0])));
            } else {
                adjacencyMap.get(edge[1]).add(edge[0]);
            }
        }

        return adjacencyMap;
    }
}
