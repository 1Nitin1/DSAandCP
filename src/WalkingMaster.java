import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WalkingMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());
            int d =Integer.parseInt(st.nextToken());
            int ans=0;
            if(d<b){
                out.println(-1);
                continue;
            }else{
                ans+=d-b;
                a+=ans;
                if(c>a){
                    out.println(-1);
                    continue;
                }else{
                    ans+=a-c;
                }
            }
            out.println(ans);

        }
        out.flush();
    }
}
