package com.bh.study.codility;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Lesson4_CountingElements {

    @Test
    public void test1_FrogRiverOne() {

    }

    /**
     * 88% (time out) -> O(N+M)
     */
    @Test
    public void test2_MaxCounters() {
        int N = 5;
        int[] A = {3,4,4,6,1,4,4};
        int[] answer = solution2(N, A);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public int[] solution2(int N, int[] A) {
        // write your code in Java SE 8
        int[] answer = new int[N];

        int max = 0, maxCounter = 0;

        for (int x : A) {
            if (x >= 1 && x <= N) {
                answer[x - 1]++;
                int k = answer[x - 1];
                if (max < k) {
                    max = k;
                }
            } else if (x == N + 1) {
                maxCounter += max;
                max = 0;
                answer = new int[N];
            }
        }

        for (int i = 0; i < N; i++) {
            answer[i] += maxCounter;
        }

        return answer;
    }
}
