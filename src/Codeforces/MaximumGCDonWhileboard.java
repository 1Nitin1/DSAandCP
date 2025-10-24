package Codeforces;

import java.io.*;
import java.util.*;

public class MaximumGCDonWhileboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] a = readArray(br, n);
            int ans = maxGCD(n, k, a);
            out.println(ans);
        }
        out.flush();
    }

    static int[] readArray(BufferedReader br, int n) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    static int maxGCD(int n, int k, int[] a) {
        long[] freq = new long[n + 1];
        for (int x : a) freq[x]++;
        long[] cum = new long[n + 1];
        for (int i = 1; i <= n; i++) cum[i] = cum[i - 1] + freq[i];

        for (int d = n; d >= 1; d--) {
            if (isGood(d, n, k, freq, cum)) return d;
        }
        return 1;
    }

    static boolean isGood(int d, int n, int k, long[] freq, long[] cum) {
        long fourD = 4L * d;
        long up = Math.min(n, fourD - 1);
        long totalSmall = up >= 1 ? cum[(int) up] : 0;
        long sm = freq[d];
        if (2L * d <= n) sm += freq[2 * d];
        if (3L * d <= n) sm += freq[3 * d];
        long bad = totalSmall - sm;
        return bad <= k;
    }
}
