package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlankSpace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int ct=0;
            int ans=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    ans=Math.max(ans,ct);
                    ct=0;
                }else{
                    ct++;
                }
            }
            ans=Math.max(ans,ct);
            out.println(ans);

        }
        out.flush();
    }
}
