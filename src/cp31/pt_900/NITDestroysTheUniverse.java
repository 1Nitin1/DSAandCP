package cp31.pt_900;

import java.io.*;
import java.util.*;

public class NITDestroysTheUniverse {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

            int groups = 0;
            boolean inGroup = false;
            for (int i = 0; i < n; i++) {
                if (a[i] != 0) {
                    if (!inGroup) {
                        groups++;
                        inGroup = true;
                    }
                } else {
                    inGroup = false;
                }
            }
            if(groups>=2){
                out.println(2);
            }else{
                out.println(groups);
            }

        }
        out.flush();
    }
}
