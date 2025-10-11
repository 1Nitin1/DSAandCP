package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArrayColoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ans=0;
            for(int i=0;i<n;i++){
                int a = Integer.parseInt(st.nextToken());
                if((a&1)==1){
                    ans^=1;
                }
            }
            String s = ans==1?"NO":"YES";
            out.println(s);
        }
        out.flush();
    }
}
