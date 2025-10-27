import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JohnnyandAncientComputer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            boolean isP=true;
            if(a==b){
                out.println(0);
            }else if(a<b){
                if(((b/a)&(b/a-1))==0 && b%a==0){
                    int ans=0;
                    int k = (int) (Math.log10((b/a))/Math.log10(2));
                    //out.println(k);
                    ans+=k/3;
                    k-=(k/3)*3;
                    ans+=k/2;
                    k-=(k/2)*2;
                    ans+=k;
                    out.println(ans);
                }else{
                    out.println(-1);
                }
            }else{
                if(((a/b)&(a/b-1))==0 && a%b==0){
                    int ans=0;
                    int k = (int) (Math.log10((a/b))/Math.log10(2));

                    ans+=k/3;
                    k-=(k/3)*3;
                    ans+=k/2;
                    k-=(k/2)*2;
                    ans+=k;
                    out.println(ans);
                }else{
                    out.println(-1);
                }
            }
        }
        out.flush();
    }
}
