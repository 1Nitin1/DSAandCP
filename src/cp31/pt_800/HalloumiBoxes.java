package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HalloumiBoxes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            StringTokenizer s = new StringTokenizer(br.readLine());
            arr[0]=Integer.parseInt(s.nextToken());
            boolean isSorted=true;
            for(int i=1;i<n;i++){

                arr[i]=Integer.parseInt(s.nextToken());
                if(arr[i]<arr[i-1]){
                    isSorted=false;
                }
            }
            if(!isSorted && k==1){
                out.println("NO");
            }else{
                out.println("YES");
            }



        }
        out.flush();

    }
}
