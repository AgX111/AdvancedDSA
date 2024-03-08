package org.personal.DataStructures;

import java.util.Arrays;

public class UnionFind {
    private int[] parent;
    private int[] rank;

    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];

        Arrays.setAll(parent, i -> i);
    }

    public int find(int x){
        if(parent[x] == x){
            return x;
        }   
        return parent[x] = find(parent[x]);
    }

    public boolean union(int a, int b){
        int pA = find(a);
        int pB = find(b);
        if(pA == pB)
            return false;

        if(rank[pA]>rank[pB]){
            parent[pB] = pA;
        } else if(rank[pA]<rank[pB]){
            parent[pA] = pB;
        } else{
            parent[pB] = pA;
            rank[pA]++;
        }
        return true;
    }

    public boolean isConnected(int a, int b){
        return find(a) == find(b);
    }
}
