package Project;

import java.util.*;

public class DFSPathMaze {
    static int n, m;
    static char[][] a;
    static boolean[][] v;
    static int sx, sy, ex, ey;
    static int best = Integer.MAX_VALUE;
    static List<int[]> bestpath = new ArrayList<>();
    static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    static List<int[]> cur = new ArrayList<>();

    static void dfs(int x, int y, int cost) {
        if (cost >= best) return;
        if (x == ex && y == ey) {
            best = cost;
            bestpath = new ArrayList<>(cur);
            return;
        }
        for (int[] mv : d) {
            int nx = x + mv[0], ny = y + mv[1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (v[nx][ny] || a[nx][ny] == '#') continue;
            int w = 0;
            if (a[nx][ny] >= '1' && a[nx][ny] <= '9') w = a[nx][ny] - '0';
            v[nx][ny] = true;
            cur.add(new int[]{nx, ny});
            dfs(nx, ny, cost + w);
            cur.remove(cur.size() - 1);
            v[nx][ny] = false;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            a[i] = s.toCharArray();
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'S') {
                    sx = i; sy = j;
                }
                if (a[i][j] == 'E') {
                    ex = i; ey = j;
                }
            }
        }

        v[sx][sy] = true;
        cur.add(new int[]{sx, sy});
        dfs(sx, sy, 0);

        char[][] out = new char[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                out[i][j] = '.';

        if (best != Integer.MAX_VALUE) {
            for (int[] p : bestpath)
                out[p[0]][p[1]] = '$';
        }
        System.out.println("Optimal Path :");
        for (int i = 0; i < n; i++)
            System.out.println(new String(out[i]));

        if (best == Integer.MAX_VALUE) System.out.println("No path exists");
        else System.out.printf("Time Taken : %d units\n",best);
        long end=System.currentTimeMillis();
        System.out.printf("Time taken to execute : %d ms",(end-start));
    }
}

