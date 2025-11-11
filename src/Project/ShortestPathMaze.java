package Project;

import javax.sound.midi.Soundbank;
import java.util.*;

import java.util.*;

public class ShortestPathMaze {
    static class Cell {
        int r, c, d;
        Cell(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n;
        sc.nextLine();

        char[][] g = new char[n][m];
        int sr = -1, scs = -1, er = -1, ecs = -1;

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                g[i][j] = s.charAt(j);
                if (g[i][j] == 'S') {
                    sr = i;
                    scs = j;
                }
                if (g[i][j] == 'E') {
                    er = i;
                    ecs = j;
                }
            }
        }
        long start = System.currentTimeMillis();
        int[][] dist = new int[n][m];
        for (int[] a : dist) Arrays.fill(a, Integer.MAX_VALUE);

        int[][] pr = new int[n][m];
        int[][] pc = new int[n][m];

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        dist[sr][scs] = 0;
        pq.add(new Cell(sr, scs, 0));

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            if (cur.d != dist[cur.r][cur.c]) continue;
            if (cur.r == er && cur.c == ecs) break;

            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (g[nr][nc] == '#') continue;

                int w = (g[nr][nc] == 'S' || g[nr][nc] == 'E') ? 0 : (g[nr][nc] - '0');
                int nd = cur.d + w;

                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    pr[nr][nc] = cur.r;
                    pc[nr][nc] = cur.c;
                    pq.add(new Cell(nr, nc, nd));
                }
            }
        }

        if (dist[er][ecs] == Integer.MAX_VALUE) {
            System.out.println("No Path");
            return;
        }

        int r = er, c = ecs;
        while (!(r == sr && c == scs)) {
            if (g[r][c] != 'E') g[r][c] = '$';
            int nr = pr[r][c];
            int nc = pc[r][c];
            r = nr;
            c = nc;
        }
        g[sr][scs] = 'S';
        System.out.println("Optimal Path :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = g[i][j];
                if (ch != '$' && ch != 'S' && ch != 'E') ch = '.';
                System.out.print(ch);
            }
            System.out.println();
        }
        long end=System.currentTimeMillis();
        System.out.println("Time Taken = " + dist[er][ecs]);
        System.out.printf("Time Taken To Execute : %d ms",end-start);
    }
}
