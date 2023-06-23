package com.livedrof.algs.list;

/**
 * 有序链表？
 */
public class OrderedLinkedList {
    Node head;
    // 为了添加
    Node tail;


    public boolean isEmpty() {
        return head == null;
    }

    /*
        链表迭代算法：TODO -> 迭代器
        Node tmp = head;
        while (tmp != null) {
            .....
            tmp = tmp.next;
        }
     */
    public int size() {
        int size = 0;
        Node tmp = head;
        while (tmp != null) {

            size += 1;

            tmp = tmp.next;
        }
        return size;
    }

    public OrderedLinkedList() {
    }

    /**
     * 创建对象，并插入链表；尾部插入，中间元素插入、双向链表插入
     *
     * @param d
     */
    public void add(String d) {
        Node t = new Node(d);
        if (head == null) {
            head = t;
            tail = head;
        } else {
            tail.next = t;
            tail = tail.next;
        }
    }

    /**
     * 有序链表
     * 所有迭代要有，向前推进及终止条件，且两个是互斥的？
     *
     * @param d
     */
    public void addOrdered(String d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            Node c = head;
            //TODO 重点
            Node previous = null;
            while (c != null) {
                //停止条件 顺序
                if (c.getDataInt() > Integer.parseInt(d)) {
                    System.out.println("->" + d);
                    //HEAD
                    if (previous == null) {
                        newNode.next = c;
                        head = newNode;
                        //非Head
                    } else {
                        previous.next = newNode;
                        newNode.next = c;
                    }
                    break;
                } else {
                    //中间,继承迭代
                    previous = c;
                    //TODO 链式存储，向前迭代的方法
                    c = c.next;
                    //结尾条件
                    if (c == null) {
                        previous.next = newNode;
                    }
                }
            }
        }

    }

    public OrderedLinkedList addOrdered3(String ss) {
        this.addOrdered(ss);
        return this;
    }

    /**
     * 合并链表
     */

    public Node merge(Node orderHead, Node orderHead2) {
        if (orderHead == null) {
            return orderHead2;
        } else if (orderHead2 == null) {
            return orderHead;
        }
        Node one = orderHead;
        Node other = orderHead2;
        Node rHead = null, rTail = null;
        while (one != null && other != null) {
            // 初始化部分
            if (rHead == null) {
                if (one.getDataInt() < other.getDataInt()) {
                    rHead = one;
                    one = one.next;

                    rTail = rHead;
                    rTail.next = null;
                } else {
                    rHead = other;
                    other = other.next;

                    rTail = rHead;
                    rTail.next = null;
                }
                continue;
            }
            // 合并过程，取最小的数添加至尾部
            if (one.getDataInt() < other.getDataInt()) {
                //合并one
                rTail.next = one;
                rTail = rTail.next;
                one = one.next;
            } else {
                rTail.next = other;
                rTail = rTail.next;
                other = other.next;
            }
        }

        //结尾部分
        if (one != null) {
            rTail.next = one;
        } else if (other != null) {
            rTail.next = other;
        }
        return rHead;
    }

    public void addOrdered2(String d) {

    }

    /**
     * 反转链表
     */
    public Node reverseList(Node node) {
        Node pre = null, cur = node, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void print(Node head) {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public void print() {
        Node tmp = head;
        while (tmp != null) {

            System.out.println(tmp.data);

            tmp = tmp.next;
        }
    }

    public static void main(String args[]) {
        OrderedLinkedList ss = new OrderedLinkedList();
        ss.addOrdered("2");
        ss.addOrdered("1");
        ss.addOrdered("3");
        ss.addOrdered("5");
        ss.addOrdered("7");
        ss.addOrdered("8");
        ss.addOrdered("9");
        ss.addOrdered("21");
        ss.addOrdered("10");
        ss.print();
        System.out.println("----->" + ss.size());

        OrderedLinkedList s = new OrderedLinkedList();
        s.add("-4");
        s.add("4");
        s.add("6");
        s.add("11");
        s.add("12");
        Node result = s.merge(ss.head, s.head);
        s.print(result);
    }

    static class Node {
        String data;

        public Node(String data) {
            this.data = data;
        }

        public int getDataInt() {
            return Integer.parseInt(data);
        }

        Node next;
    }
}
