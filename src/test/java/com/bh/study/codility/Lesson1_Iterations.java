package com.bh.study.codility;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Lesson1_Iterations {

    @Test
    public void test_binaryGap() {
        System.out.println(solution(32));
    }

    /**
     * 0의 최대 길이 구하기 (마지막이 0이면 체크하지 않는다. ex) 10000 -> 0)
     */
    public int solution(int N) {
        String bin = binary(N);
        String[] binArr = bin.split("1");

        int max = 0;

        for (int i = 1; i < binArr.length; i++) {
            String b = binArr[i];

            if (i == binArr.length - 1 && bin.charAt(bin.length() - 1) == '0') {
                continue;
            }

            if (b.length() > max) {
                max = b.length();
            }
        }

        return max;
    }

    /**
     * 2진수 생성
     */
    private String binary(int n) {
        ArrayList<String> binArr = new ArrayList<>();

        while (n != 0) {
            binArr.add(Integer.toString(n % 2));
            n = n / 2;
        }

        Collections.reverse(binArr);

        StringBuilder b = new StringBuilder();

        for (String bin : binArr) {
            b.append(bin);
        }

        return b.toString();
    }
}
