package Codeforces;

import java.io.*;
import java.util.*;

public class PetyaAndStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String a = br.readLine().toLowerCase();
        String b = br.readLine().toLowerCase();
        int cmp = a.compareTo(b);
        if (cmp < 0) pw.println(-1);
        else if (cmp > 0) pw.println(1);
        else pw.println(0);
        pw.flush();
    }
}
