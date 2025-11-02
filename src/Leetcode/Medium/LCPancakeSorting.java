package Leetcode.Medium;

import java.util.*;

public class LCPancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length; i >= 1; i--) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    list.add(j + 1);
                    list.add(arr[j]);
                    for (int k = 0; k <= j / 2; k++) {
                        int a = arr[k];
                        arr[k] = arr[j - k];
                        arr[j - k] = a;
                    }
                    for (int k = 0; k <i / 2; k++) {
                        int a = arr[k];
                        arr[k] = arr[i - k-1];
                        arr[i-1 - k] = a;
                    }
                    break;
                }

            }

        }
        return list;
    }
}
