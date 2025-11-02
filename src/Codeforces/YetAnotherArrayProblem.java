package Codeforces;

import java.io.*;
import java.util.*;
public class YetAnotherArrayProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int M = 200;
        boolean[] s = new boolean[M + 1];
        Arrays.fill(s, true);
        List<Integer> p = new ArrayList<>();
        for (int i = 2; i <= M; i++) {
            if (s[i]) {
                p.add(i);
                for (long j = 1L * i * i; j <= M; j += i) s[(int) j] = false;
            }
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long g = 0;
            for (int i = 0; i < n; i++) {
                long x = Long.parseLong(st.nextToken());
                g = (i == 0 ? x : gcd(g, x));
            }
            boolean ok = false;
            for (int q : p) {
                if (g % q != 0) {
                    out.println(q);
                    ok = true;
                    break;
                }
            }
            if (!ok) out.println(-1);
        }
        out.flush();
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}