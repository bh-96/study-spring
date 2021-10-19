package com.bh.study.test;

import org.junit.jupiter.api.Test;

public class DFSTest {

    @Test
    public void 이진트리_순회_DFS() {
        Node tree = new Node(1);
        tree.lt = new Node(2);
        tree.rt = new Node(3);
        tree.lt.lt = new Node(4);
        tree.lt.rt = new Node(5);
        tree.rt.lt = new Node(6);
        tree.rt.rt = new Node(7);

        binaryDFS(tree);
    }

    // Stack (LIFO, push(), pop())
    public void binaryDFS(Node root) {
        if (root == null) {
            return;
        }

        // 전위순회
        System.out.print(root.data + " ");
        binaryDFS(root.lt);
        // 중위순회
        binaryDFS(root.rt);
        // 후위순회
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
    public void 부분집합() {
        int[] arr = {1,2,3};
        int n = arr.length;
        int[] visited = new int[n];

        System.out.println("permutation");
        permutationDFS(arr, visited, n, 0);

        System.out.println("combination");
        combinationDFS(arr, visited, n, 2, 0);
    }

    // 순열 (순서 O, 중복 X)
    public void permutationDFS(int[] arr, int[] visited, int n, int d) {
        if (n == d) {
            print(arr, visited, n);
            return;
        }

        visited[d] = 1;
        permutationDFS(arr, visited, n, d + 1);
        visited[d] = 0;
        permutationDFS(arr, visited, n, d + 1);
    }

    // 조합 (n개의 원소 중 r개를 순서 없이 골라낸 것)
    public void combinationDFS(int[] arr, int[] visited, int n, int r, int d) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        if (d == n) {
            return;
        }

        visited[d] = 1;
        combinationDFS(arr, visited, n, r - 1, d + 1);
        visited[d] = 0;
        combinationDFS(arr, visited, n, r, d + 1);
    }

    private void print(int[] arr, int[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
