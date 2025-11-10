package Codeforces;

import java.util.*;

public class EvenArray {

    public static int minMovesToMakeGood(int[] a) {
        int badEven = 0; // even index has odd value
        int badOdd = 0;  // odd index has even value

        for (int i = 0; i < a.length; i++) {
            if (i % 2 != a[i] % 2) {
                if (i % 2 == 0) badEven++;
                else badOdd++;
            }
        }

        if (badEven != badOdd) return -1;
        return badEven;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            System.out.println(minMovesToMakeGood(a));
        }
    }
}
