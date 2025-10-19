import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ServalAndMochasArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        outerloop:
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    int a=gcd(arr[i],arr[j]);

                    if(a==1 || a==2){
                        out.println("YES");
                        continue outerloop;
                    }

                }
            }
            out.println("NO");
        }
        out.flush();
    }
    public static int gcd(int a,int b){
        while(b!=0){
            int temp=a;
            a=b;
            b=temp%b;
        }
        return a;
    }
}
