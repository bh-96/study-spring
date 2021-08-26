package com.bh.study.codility;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Lesson2_Arrays {

    @Test
    public void test1_CyclicRotation() {
        int[] A = {3,6};
        int K = 0;
        int[] answer = solution(A, K);

        for (int n : answer) {
            System.out.print(n);
        }
    }

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int N = A.length;

        int[] answer = new int[N];

        if (N == 0) {
            return answer;
        }

        int start = K == 0 || N == K ? 0 : K % N;

        if (start == 0) {
            return A;
        }

        int x = start;

        for (int i = 0; i < N - start; i++) {
            answer[x++] = A[i];
        }

        x = N - start;

        for (int i = 0; i < start; i++) {
            answer[i] = A[x++];
        }

        return answer;
    }

    @Test
    public void test2_OddOccurrencesInArray() {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution2(A));
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        int N = A.length;

        if (N == 1) {
            return A[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : A) {
            if (map.containsKey(n)) {
                int cnt = map.get(n) + 1;
                map.put(n, cnt);
            } else {
                map.put(n, 1);
            }
        }

        for (int n : map.keySet()) {
            int cnt = map.get(n);
            if (cnt % 2 == 1) {
                return n;
            }
        }

        return 0;
    }
}
