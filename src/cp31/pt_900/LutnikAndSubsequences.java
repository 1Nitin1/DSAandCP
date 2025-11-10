import java.io.*;
import java.util.*;

public class LutnikAndSubsequences {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long z = 0, o = 0;
            for (int i = 0; i < n; i++) {
                long v = Long.parseLong(st.nextToken());
                if (v == 0) z++;
                else if (v == 1) o++;
            }
            System.out.println(o*(1L<<z));
        }

    }
}

