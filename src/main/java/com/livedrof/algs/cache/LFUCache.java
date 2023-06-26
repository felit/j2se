package com.livedrof.algs.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LFUCache {
    Map<Integer, Node> freq;
    Map<String, Node> index;
    int capacity;
    int minFreq;

    public LFUCache() {
        freq = new HashMap<>();
        index = new HashMap<>();
        capacity = 0;
    }

    public String get(String key) {
        //TODO
        if (!index.containsKey(key)) {
            return null;
        } else {
            //
            Node node = index.get(key);
            int freq2 = node.freq.get();
            node.freq.incrementAndGet();
            Node head = freq.get(freq2);

            // 从旧列表移除
            node.pre.next = node.next;
            node.next.pre = node.pre;

            // 加入新的列表
            node.next = head;
            head.pre = node;
            node.pre = null;
            freq.put(freq2, node);
            return node.value;
        }
    }

    public String put(String key, String value) {
        if (!index.containsKey(key)) {

        } else {

        }
        //TODO
        return null;
    }

    /**
     * 双端
     */
    static class MapNode {
        Node head;
        Node tail;
    }

    /**
     * 需要尾部删除，所以要双向链表
     */
    static class Node {
        Node pre;
        Node next;
        AtomicInteger freq;

        String key;
        String value;
    }
}

