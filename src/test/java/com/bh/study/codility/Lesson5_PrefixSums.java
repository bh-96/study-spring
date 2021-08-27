package com.bh.study.codility;

import org.junit.jupiter.api.Test;

public class Lesson5_PrefixSums {

    @Test
    public void test1_PassingCars() {
        int[] A = {0,1,0,1,1,1,0,1};
        System.out.println(solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int answer = 0;

        int n = A.length;

        if (n == 1) {
            return answer;
        }

        int x = 0;

        for (int i = 1; i < n; i++) {
            int p = A[i - 1];
            int q = A[i];

            if (p == 0) {
                x++;
            }

            if (q == 1) {
                answer += q * x;
            }
        }

        if (answer > 1000000000 || answer < 0) {
            answer = -1;
        }

        return answer;
    }

    @Test
    public void test2_MinAvgTwoSlice() {
        int[] A = {4,2,2,5,1,5,8};
        System.out.println(solution2(A));
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        int answer = 0;

        int n = A.length;

        double min = average(A[0] + A[1], 2);

//        for (int i = 0; i < n; i++) {
//            int sum = A[0];
//            int k = 1;
//
//            for (int j = i + 1; j < n; j++) {
//                int b = B[i][j];
//                sum += b;
//                k++;
//
//                double avg = average(sum, k);
//
//                if (min > avg) {
//                    min = avg;
//                    answer = i;
//                }
//            }
//        }

        return answer;
    }

    private double average(int sum, int n) {
        return (double) sum / n;
    }
}
