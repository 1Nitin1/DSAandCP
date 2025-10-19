import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SequenceGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int ct=n;
            for(int i=0;i<n;i++){

                arr[i]=Integer.parseInt(st.nextToken());
                if(i>0){
                    if(arr[i]<arr[i-1]){
                        ct++;
                    }
                }
            }
            out.println(ct);
            int prev = arr[0];
            out.print(arr[0]+" ");
            for(int i=1;i<n;i++){
                if(arr[i]>=prev){
                    out.print(arr[i]+" ");

                }else{
                    out.print(arr[i]+" "+arr[i]+" ");
                }
                prev=arr[i];
            }
            out.println();
        }
        out.flush();
    }
}
