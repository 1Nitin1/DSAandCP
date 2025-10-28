package Codeforces;

import java.io.*;
import java.util.*;
public class Square {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] a=new int[4];
            for(int i=0;i<4;i++)a[i]=Integer.parseInt(st.nextToken());
            Arrays.sort(a);
            pw.println(a[0]==a[3]?"YES":"NO");
        }
        pw.flush();
    }
}
