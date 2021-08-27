package com.bh.study.codility;

import org.junit.jupiter.api.Test;

public class Lesson4_CountingElements {

    @Test
    public void test1_FrogRiverOne() {
        int X = 4;
        int[] A = {1,3,1,4,2,3,5,4};
        System.out.println(solution(X, A));
    }

    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int answer = -1;

        int[] visited = new int[X];
        int n = A.length;
        int v = 0;

        for (int i = 0; i < n; i++) {
            int k = A[i];

            if (visited[k - 1] == 0) {
                visited[k - 1]++;
                v++;
            }

            if (v == X) {
                answer = i;
                break;
            }
        }

        return answer;
    }

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
                int k = answer[x - 1];

                if (maxCounter >= k) {
                    answer[x - 1] = maxCounter + 1;
                } else {
                    answer[x - 1]++;
                }

                max = Math.max(max, answer[x - 1]);
            } else if (x == N + 1) {
                maxCounter = max;
            }
        }

        if (maxCounter > 0) {
            for (int i = 0; i < N; i++) {
                if (maxCounter > answer[i]) {
                    answer[i] = maxCounter;
                }
            }
        }

        return answer;
    }
}
