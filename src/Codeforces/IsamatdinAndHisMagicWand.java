package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.StringTokenizer;

public class IsamatdinAndHisMagicWand {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a=new int[n];

            boolean o=false,e=false;
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(st.nextToken());
                if(a[i]%2==0)e=true;else o=true;
            }
            if(o&&e)Arrays.sort(a);
            for(int i=0;i<n;i++)pw.print(a[i]+" ");
            pw.println();
        }
        pw.flush();
    }
}
