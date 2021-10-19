package com.bh.study.test;

import org.junit.jupiter.api.Test;

public class SortTest {

    @Test
    public void 선택정렬() {
        int[] arr = {13,5,11,7,23};
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int idx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        print(arr);
    }

    @Test
    public void 버블정렬() {
        int[] arr = {13,5,11,7,23};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        print(arr);
    }

    @Test
    public void 삽입정렬() {
        int[] arr = {11,7,5,6,10,9};
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j;

            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = tmp;
        }

        print(arr);
    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
