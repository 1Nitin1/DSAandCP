package cp31.pt_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TrianglesOnARectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            st=new StringTokenizer(br.readLine());
            long[] x1=new long[Integer.parseInt(st.nextToken())];
            for(int i=0;i<x1.length;i++){
                x1[i]=Long.parseLong(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            long[] x2=new long[Integer.parseInt(st.nextToken())];
            for(int i=0;i<x2.length;i++){
                x2[i]=Long.parseLong(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            long[] x3=new long[Integer.parseInt(st.nextToken())];
            for(int i=0;i<x3.length;i++){
                x3[i]=Long.parseLong(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            long[] x4=new long[Integer.parseInt(st.nextToken())];
            for(int i=0;i<x4.length;i++){
                x4[i]=Long.parseLong(st.nextToken());
            }

            long ans=Math.max(Math.max((x1[x1.length-1]-x1[0])*y,(x2[x2.length-1]-x2[0])*y)
                    ,Math.max((x3[x3.length-1]-x3[0])*x,(x4[x4.length-1]-x4[0])*x));
            out.println(ans);
        }
        out.flush();
    }
}
