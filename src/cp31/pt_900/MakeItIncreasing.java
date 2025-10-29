package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakeItIncreasing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        outerloop:
        while(t-->0){
            int ans=0;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=n-2;i>=0;i--){

                while(arr[i]>=arr[i+1]){
                    if(arr[i+1]==0){
                        out.println(-1);
                        continue outerloop;
                    }
                    arr[i]/=2;
                    ans++;
                }
            }
            out.println(ans);

        }
        out.flush();
    }
}
