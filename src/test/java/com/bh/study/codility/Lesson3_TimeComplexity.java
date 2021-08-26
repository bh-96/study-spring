package com.bh.study.codility;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Lesson3_TimeComplexity {

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MICROSECONDS)
    public void test1_frogJmp() {
        System.out.println(solution(10, 220, 10));
    }

    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int div = (Y - X) / D;
        if (Y > X + D * div) {
            return div + 1;
        } else {
            return div;
        }
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MICROSECONDS)
    public void test2_permMissingElem() {
        int[] A = {1,2,3,4,5,6,7,8,9,10,12,13};
        System.out.println(solution2(A));
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int N = A.length;

        if (N == 0 || A[0] != 1) {
            return 1;
        }

        for (int i = 0; i < N - 1; i++) {
            if (A[i] + 1 != A[i + 1]) {
                return A[i] + 1;
            }
        }

        return A[N - 1] + 1;
    }

    /**
     * 88% (time out)
     */
    @Test
    @Timeout(value = 111, unit = TimeUnit.MILLISECONDS)
    public void test3_tapeEquilibrium() {
        int[] A = {3,1,2,4,3};
        System.out.println(solution3(A));
    }

    public int solution3(int[] A) {
        // write your code in Java SE 8
        int total = Arrays.stream(A).sum();
        int N = A.length;

        int lt = 0;

        ArrayList<Integer> absList = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            lt += A[i];
            int rt = total - lt;
            int abs = Math.abs(lt - rt);
            absList.add(abs);
        }

        return Collections.min(absList);
    }
}
