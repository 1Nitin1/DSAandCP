package Project;

import java.util.*;

public class Maze2D {

    static class P {
        int r, c;
        P(int r, int c) { this.r = r; this.c = c; }
    }

    public static List<P> solve(char[][] g) {
        int n = g.length, m = g[0].length;
        int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] vis = new boolean[n][m];
        P[][] par = new P[n][m];
        Queue<P> q = new LinkedList<>();

        if (g[0][0] == '#') return Collections.emptyList();
        vis[0][0] = true;
        q.add(new P(0,0));

        while (!q.isEmpty()) {
            P p = q.poll();
            if (p.r == n-1 && p.c == m-1) return build(par, p);

            for (int[] x : d) {
                int nr = p.r + x[0], nc = p.c + x[1];
                if (nr>=0 && nc>=0 && nr<n && nc<m && !vis[nr][nc] && g[nr][nc]=='0') {
                    vis[nr][nc] = true;
                    par[nr][nc] = p;
                    q.add(new P(nr,nc));
                }
            }
        }
        return Collections.emptyList();
    }

    private static List<P> build(P[][] par, P end) {
        LinkedList<P> path = new LinkedList<>();
        for (P p=end; p!=null; p=par[p.r][p.c]) path.addFirst(p);
        return path;
    }

    public static void printMaze(char[][] g) {
        System.out.println("[");
        for (int i=0; i<g.length; i++) {
            System.out.print("  [");
            for (int j=0; j<g[0].length; j++) {
                char ch = (g[i][j] == '$') ? '$' : '.';
                System.out.print("'" + ch + "'");
                if (j < g[0].length - 1) System.out.print(", ");
            }
            System.out.println("]" + (i < g.length - 1 ? "," : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        System.out.print("Enter columns: ");
        int m = sc.nextInt();
        sc.nextLine();

        char[][] g = new char[n][m];

        System.out.println("Enter maze rows:");
        for (int i=0; i<n; i++) {
            g[i] = sc.nextLine().toCharArray();
        }

        List<P> ans = solve(g);

        if (ans.isEmpty()) {
            System.out.println("NO PATH FOUND");
            return;
        }

        for (P p : ans) g[p.r][p.c] = '$';

        printMaze(g);
    }
}
