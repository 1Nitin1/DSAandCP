package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class YourName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int k = Integer.parseInt(br.readLine());
        while(k-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s=st.nextToken();
            String t=st.nextToken();
            char[] a=s.toCharArray(),b=t.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            out.println(Arrays.equals(a,b)?"YES":"NO");
        }
        out.flush();
    }
}
