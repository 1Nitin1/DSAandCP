package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EverybodyLikesGoodArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int ans = 0;
            for(int i=1;i<n;i++){
                int b = Integer.parseInt(st.nextToken());
                if((b&1)==(a&1)){
                    ans++;
                }
                a=b;
            }
            out.println(ans);
        }
        out.flush();
    }
}
