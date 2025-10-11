package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StrangePartition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double x = Double.parseDouble(st.nextToken());
            st=new StringTokenizer(br.readLine());
            double sum = 0;
            long max=0;
            for(int i=0;i<n;i++){
                int a = Integer.parseInt(st.nextToken());
                sum+=a;
                max+=Math.ceil(a/x);
            }
            sum= (long) Math.ceil(sum/x);
            out.println((long)sum+" "+max);
        }
        out.flush();
    }
}
