package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class WordCapitalization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder s = new StringBuilder(br.readLine());
        if(s.charAt(0)>='A' && s.charAt(0)<='Z'){
            out.println(s.toString());
        }else{
            String a = String.valueOf(s.charAt(0));
            s.replace(0,1,a.toUpperCase());
            out.println(s.toString());
        }
        out.flush();
    }
}
