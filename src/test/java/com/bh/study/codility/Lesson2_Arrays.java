package com.bh.study.codility;

import org.junit.jupiter.api.Test;

public class Lesson2_Arrays {

    @Test
    public void test1_CyclicRotation() {
        int[] A = {3,6};
        int K = 0;
        int[] answer = solution(A, K);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
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

    }
}
