package com.livedrof.algs.list;

/**
 * 有序链表？
 * 旋转
 * 分组反转
 * 反转
 * 排序
 * 是否有环？
 * 相加
 * 相交？
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
            //反转
            next = cur.next;
            cur.next = pre;
            // 移动
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 倒数第K个元素
     *
     * @param node
     * @param k
     * @return
     */
    public Node kIndex(Node node, int k) {
        Node cur = node, kNode = null;
        int c = 0;
        while (cur != null) {
            if (c < k - 1) {
                c++;
            } else if (c == k - 1) {
                kNode = node;
                c++;
            } else {
                kNode = kNode.next;
            }
            cur = cur.next;
        }
        return kNode;
    }

    /**
     * TODO 两个链表相加，逆序？
     *
     * @param node
     * @param otherNode
     * @return
     */
    public Node numPlus(Node node, Node otherNode) {
        return null;
    }

    /**
     * 正序 两个数相加
     *
     * @param node
     * @param otherNode
     * @return
     */
    public Node numPlus2(Node node, Node otherNode) {
        return null;
    }

    /**
     * 两两交换链表中的节点
     *
     * @param node
     * @return
     */
    public Node swapTwoNodes(Node node) {
        Node pre = null, cur = node, next, newHead = null;
        while (cur != null && cur.next != null) {
            if (pre == null) {//表头
                next = cur.next.next;
                newHead = cur.next;
                cur.next.next = cur;
                cur.next = next;

                pre = cur;
                cur = next;
            } else {
                next = cur.next.next;
                pre.next = cur.next;
                cur.next.next = cur;
                cur.next = next;

                pre = cur;
                cur = next;
            }
        }
        return newHead;
    }

    /**
     * TODO 回文链表
     *
     * @param node
     * @return
     */
    public boolean isHuiwen(Node node) {
        return false;
    }

    /**
     * TODO
     *
     * @param node
     * @return
     */
    public boolean hasCircle(Node node) {
        return false;
    }

    /**
     * TODO
     * 求两个链表的交点+求环形链表的入环点: https://blog.csdn.net/weixin_44343938/article/details/127754878
     *
     * @return
     */
    public boolean 链表相交() {
        // https://blog.csdn.net/weixin_61203642/article/details/124847959
        return false;
    }

    /**
     * TODO
     *
     * @param node
     * @return
     */
    public boolean sort(Node node) {
        return false;
    }

    /**
     * TODO 右侧最大
     *
     * @param node
     * @return
     */
    public Node rightMax(Node node) {
        return null;
    }

    public Node rotateList(Node node, int k) {
        Node cur = node, kNode = null, k1Node = null;
        int c = 0;
        while (cur != null) {
            if (c < k - 1) {
                c++;
            } else if (c == k - 1) {
                kNode = node;
                c++;
            } else {
                k1Node = kNode;
                kNode = kNode.next;
            }

            if (cur.next == null) {
                //转换链表头信息
                cur.next = node;
                k1Node.next = null;
                cur = null;
            } else {
                cur = cur.next;
            }
        }
        return kNode;
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
        System.out.println("-----");
        Node sss = s.reverseList(s.head);
        s.print(sss);
        System.out.println("-----");
        Node r = s.rotateList(sss, 4);
        s.print(r);
        System.out.println("-----");
        Node rr= s.swapTwoNodes(r);
        s.print(rr);

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

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }
}
