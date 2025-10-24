package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StrangeMachine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        outerloop:
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            boolean B=false;
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[q];
            for(int i=0;i<q;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            for(char a : s.toCharArray()){
                if(a=='B'){
                    B=true;
                    break;
                }
            }
            for(int i=0;i<q;i++){
                int ans=0;
                if(B){
                    int l=0;
                    while(arr[i]>0){
                        if(s.charAt(l)=='A'){
                            arr[i]--;
                        }else{
                            arr[i]/=2;
                        }
                        l=(l+1)%n;
                        ans++;
                    }
                    out.println(ans);
                }else{
                    out.println(arr[i]);
                }

            }
        }
        out.flush();
    }
}
