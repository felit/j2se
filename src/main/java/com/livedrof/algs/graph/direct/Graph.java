package com.livedrof.algs.graph.direct;

import com.google.common.base.Joiner;

import java.util.*;
import java.util.stream.Collectors;

public class Graph<T> {
    int verNum;
    int edgeNum;
    List<Vertex> verArr = new LinkedList<>();
    Map<T, Vertex<T>> vertexIndex = new HashMap<>();

    public void addVertex(Vertex<T> v) {
        verArr.add(v);
        vertexIndex.put(v.getKey(), v);
    }

    public Vertex<T> getVertex(T key) {
        return this.vertexIndex.get(key);
    }

    public void addEdge(Edge<T> edge) {
        Vertex<T> vertex = this.vertexIndex.get(edge.getFirst().getKey());
        this.addEdge(vertex, edge);
        System.out.println(edge.getLast());//TODO
        this.addEdge(this.vertexIndex.get(edge.getLast().getKey()), edge.clone());
    }

    private void addEdge(Vertex<T> vertex, Edge<T> edge) {
        Edge<T> endEdge = vertex.edge;
        if (endEdge == null) {
            vertex.edge = edge;
        } else {
            while (endEdge.next == null) {
                endEdge.next = edge;
            }
        }
    }

    public void print() {
        System.out.println("key:\n");
       String ss = Joiner.on(",").join(this.verArr.stream().map(v -> v.getKey().toString()).collect(Collectors.toList()));
        System.out.println(ss);
        System.out.println("edge:\n");
        this.verArr.forEach(v -> {
            System.out.println("\nvertex:"+v.getKey());
            v.getEdgeKeys().forEach((k) -> {
                System.out.println(k);
            });
        });

    }

    public static void main(String args[]) {
        Graph<String> graph = new Graph<>();
        String[] vertex = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K","L"};
        for (String s : vertex) {
            graph.addVertex(new Vertex(s));
        }
        List<String[]> edge = new LinkedList<>();
        edge.add(new String[]{"A", "G"});
        edge.add(new String[]{"A", "E"});
        edge.add(new String[]{"B", "F"});
        edge.add(new String[]{"C", "L"});
        edge.add(new String[]{"B", "D"});
        edge.add(new String[]{"E", "G"});
        edge.add(new String[]{"G", "K"});
        edge.add(new String[]{"G", "H"});
        edge.add(new String[]{"G", "I"});
        edge.add(new String[]{"C", "G"});
        edge.add(new String[]{"C", "J"});
        edge.add(new String[]{"C", "I"});
        edge.forEach((k) -> {
            System.out.println(k[0]+":"+k[1]);
            graph.addEdge(new Edge<>(graph.getVertex(k[0]), graph.getVertex(k[1])));
        });
        graph.print();

    }
}
