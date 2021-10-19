package com.bh.study.test;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTest {

    @Test
    public void 이진트리_순회_BFS() {
        Node tree = new Node(1);
        tree.lt = new Node(2);
        tree.rt = new Node(3);
        tree.lt.lt = new Node(4);
        tree.lt.rt = new Node(5);
        tree.rt.lt = new Node(6);
        tree.rt.rt = new Node(7);

        binaryBFS(tree);
    }

    // Queue (FIFO, offer(), poll())
    public void binaryBFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print("level : " + L + " | ");

            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");

                if (cur.lt != null) {
                    queue.offer(cur.lt);
                }

                if (cur.rt != null) {
                    queue.offer(cur.rt);
                }
            }

            L++;
            System.out.println();
        }
    }

    public class Node {
        private int data;
        private Node lt;
        private Node rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }
    }

    @Test
    public void 최단거리_알고리즘() {
        int s = 5;  // 출발지점
        int e = 14; // 도착지점
        int d = 5;  // 이동거리

        int[] dis = {1, -1, d};
        int[] ch = new int[10001];  // 1 ~ 10000
        ch[s] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        int answer = stateTreeBFS(queue, dis, ch, e);
        System.out.println(answer);
    }

    // 상태트리 탐색
    public int stateTreeBFS(Queue<Integer> queue, int[] dis, int[] ch, int e) {
        int L = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int x = queue.poll();

                if (x == e) {
                    return L;
                }

                for (int d : dis) {
                    // +1, -1, +이동거리
                    int nx = x + d;

                    if (nx == e) {
                        return L + 1;
                    }

                    // 1 ~ 10000 사이, 방문하지 않은 index
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }

            L++;
        }

        return 0;
    }
}
