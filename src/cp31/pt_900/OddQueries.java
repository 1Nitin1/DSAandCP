import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OddQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long q = Long.parseLong(st.nextToken());
            long[] arr = new long[(int)n];
            st=new StringTokenizer(br.readLine());
            arr[0]=Long.parseLong(st.nextToken());
            for(int i=1;i<n;i++){
                arr[i]=arr[i-1]+Long.parseLong(st.nextToken());
            }
            for(int i=0;i<q;i++){
                st=new StringTokenizer(br.readLine());
                long l = Long.parseLong(st.nextToken());
                long r = Long.parseLong(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                long sum=arr[(int)n-1];
                if(l==1){
                    sum-=arr[(int)r-1];
                }else{
                    sum-=arr[(int)r-1]-arr[(int)l-2];
                }
                sum+=(r-l+1)*k;
                out.println(sum%2==1?"yes":"no");
            }

        }
        out.flush();
    }
}
