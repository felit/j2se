package com.livedrof.j2se.distributed.algorithm;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一致性hash算法讲解——Java实现: https://blog.csdn.net/qq_45744501/article/details/120906695
 * 不同中间件的迁移方式:
 * 1、 Redis
 * 2、 HBase
 * 3、Elasticsearch
 * 4、ClickHouse
 * 5、
 */
public class ConsistentHash {

    private int virNodesNum;

    private Map<String, List<Integer>> realNodeToVirNodesHashCode = new ConcurrentHashMap<>();

    private SortedMap<Integer, String> ring = new TreeMap<>();

    public ConsistentHash() {
        this.virNodesNum = 150;
    }


    public synchronized void addNode(String node) {
        if (realNodeToVirNodesHashCode.containsKey(node))
            throw new RuntimeException(node + " has already in the pool.");
        // 创建虚拟节点，并放置到环上去
        // 虚拟节点的hashcode 放入到 realNodeToVirNodesHashCode 中
        int hash;
        List<Integer> hashCodes = new ArrayList<>();
        for (int i = 0; i < this.virNodesNum; i++) {
            hash = rehash(node + "---" + i);
            ring.putIfAbsent(hash, node);
            hashCodes.add(hash);
        }
        realNodeToVirNodesHashCode.put(node, hashCodes);
    }

    public synchronized void removeNode(String node) {
        if (!realNodeToVirNodesHashCode.containsKey(node))
            throw new RuntimeException(node + " is not in the pool.");
        // 得到该节点对应的虚拟节点hashcode列表
        List<Integer> virNodes = realNodeToVirNodesHashCode.get(node);
        // 从环上依个删除
        for (Integer virNode : virNodes) {
            ring.remove(virNode);
        }
        realNodeToVirNodesHashCode.remove(node);
    }

    public String getNode(String key) {
        int hash = rehash(key);
        // 从环上选择一个顺时针方向
        // (升序方向--或者降序方向都可，这里升序)的
        // 第一个虚拟节点作为目标节点返回
        SortedMap<Integer, String> tailMap = ring.tailMap(hash); // tailMap中的所有key值>=hash
        return tailMap.isEmpty() ? ring.get(ring.firstKey()) : tailMap.get(tailMap.firstKey());
    }

    /**
     * TODO 此Hash算法是怎么来的？
     *
     * @param o
     * @return
     */
    private int rehash(Object o) {
        int hash = o.hashCode();
        hash *= 16777619;// 32 bit FNV_prime = 2^24 + 2^8 + 0x93 = 16777619
        return Math.abs(hash ^ (hash >>> 16));
    }

    @Test
    public void TestMain() {
        ConsistentHash consistentHash = new ConsistentHash();
        consistentHash.addNode("192.168.10.10");
        consistentHash.addNode("192.168.10.11");
        consistentHash.addNode("192.168.10.12");
        consistentHash.addNode("192.168.10.13");
        String[] tmp = new String[1000000];
        for (int i = 0; i < 1000000; i++) {
            tmp[i] = consistentHash.getNode(String.valueOf(i));
        }
        consistentHash.addNode("192.168.10.14");
        int cnt = 0;
        for (int i = 0; i < 1000000; i++) {
            if (tmp[i].equals(consistentHash.getNode(String.valueOf(i)))) cnt++;
            tmp[i] = consistentHash.getNode(String.valueOf(i));
        }
        System.out.println("添加一个节点后命中率：" + cnt * 1.0 / 1000000 * 100 + "%");
        consistentHash.removeNode("192.168.10.12");
        cnt = 0;
        for (int i = 0; i < 1000000; i++) {
            if (tmp[i].equals(consistentHash.getNode(String.valueOf(i)))) cnt++;
        }
        System.out.println("移除一个节点后命中率：" + cnt * 1.0 / 1000000 * 100 + "%");
    }


}
