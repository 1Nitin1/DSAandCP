package Codeforces;

import java.io.*;
import java.util.*;

public class NearlyLuckyNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int cnt = 0;
        for (char c : n.toCharArray()) if (c == '4' || c == '7') cnt++;
        if (cnt == 0) {
            out.println("NO");
        } else {
            String s = Integer.toString(cnt);
            boolean lucky = true;
            for (char c : s.toCharArray()) if (c != '4' && c != '7') { lucky = false; break; }
            out.println(lucky ? "YES" : "NO");
        }
        out.flush();
    }
}
