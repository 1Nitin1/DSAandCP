package cp31.pt_1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JustEatIt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            long sum=0;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                sum+=arr[i];
            }
            long maxsum=0;
            long curmax=0;

            for(int i=0;i<n-1;i++){
                curmax+=arr[i];
                if(curmax<0){
                    curmax=0;
                }else{
                    maxsum=Math.max(curmax,maxsum);
                }
            }
            curmax=0;
            for(int i=1;i<n;i++){
                curmax+=arr[i];
                if(curmax<0){
                    curmax=0;
                }else{
                    maxsum=Math.max(curmax,maxsum);
                }
            }

            if(maxsum<sum){
                out.println("yes");
            }else{
                out.println("no");
            }


        }
        out.flush();
    }
}
