package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OneAndTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int ct=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                if(arr[i]==2){
                    ct++;
                }
            }
            if(ct%2==1){
                out.println(-1);
            }else{
                int a = 0;
                for(int i=0;i<n;i++){
                    if(arr[i]==2){
                        a++;
                    }
                    if(a==ct/2){
                        out.println(i+1);
                        break;
                    }
                }
            }

        }
        out.flush();
    }
}
