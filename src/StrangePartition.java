package cp31;

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
            float x = Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int sum = 0;
            int max=0;
            for(int i=0;i<n;i++){
                int a = Integer.parseInt(st.nextToken());
                sum+=a;
                max+=Math.ceil((float)a/x);
            }
            sum= (int) Math.ceil(sum/x);
            out.println(sum+" "+max);
        }
        out.flush();
    }
}
