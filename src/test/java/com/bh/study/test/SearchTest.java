package com.bh.study.test;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class SearchTest {

    @Test
    public void 이분검색() {
        int[] arr = {23,87,65,12,57,32,99,81};
        int m = 32; // 검색값

        // 정렬 필수
        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length - 1;

        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            } else if (arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
