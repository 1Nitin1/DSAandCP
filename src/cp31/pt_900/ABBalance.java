import java.io.*;

public class ABBalance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String s = br.readLine();
            int ab=0;
            int ba=0;
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i)=='a'&&s.charAt(i+1)=='b'){
                    ab++;
                }else if(s.charAt(i)=='b'&&s.charAt(i+1)=='a'){
                    ba++;
                }
            }
            if(ab==ba){
                out.println(s);
                continue;
            }
            StringBuilder str1 = new StringBuilder(s);
            char prev1 = str1.charAt(str1.length()-1);
            str1.setCharAt(str1.length()-1,prev1=='a'?'b':'a');
            out.println(str1.toString());

        }
        out.flush();
    }
}
