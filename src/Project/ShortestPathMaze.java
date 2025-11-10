package Project;

import java.util.*;

public class ShortestPathMaze {

    static class Node implements Comparable<Node> {
        int r, c, d;
        Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        char[][] a = new char[n][m];
        int sr = 0, scs = 0, er = 0, ec = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] == 'S') { sr = i; scs = j; }
                if (a[i][j] == 'E') { er = i; ec = j; }
            }
        }

        int[][] dist = new int[n][m];
        for (int[] r : dist) Arrays.fill(r, Integer.MAX_VALUE);
        int[][] pr = new int[n][m];
        int[][] pc = new int[n][m];
        for (int[] r : pr) Arrays.fill(r, -1);
        for (int[] c : pc) Arrays.fill(c, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(sr, scs, 0));
        dist[sr][scs] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.d != dist[cur.r][cur.c]) continue;
            if (cur.r == er && cur.c == ec) break;

            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (a[nr][nc] == '#') continue;

                int w = (a[nr][nc] == 'S' || a[nr][nc] == 'E') ? 0 : (a[nr][nc] - '0');
                int nd = cur.d + w;

                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    pq.add(new Node(nr, nc, nd));
                    pr[nr][nc] = cur.r;
                    pc[nr][nc] = cur.c;
                }
            }
        }

        char[][] o = new char[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(o[i], '.');

        int r = er, c = ec;
        while (!(r == sr && c == scs)) {
            o[r][c] = '$';
            int rr = pr[r][c], cc = pc[r][c];
            r = rr;
            c = cc;
        }
        o[sr][scs] = '$';
        System.out.println("Fastest Path : ");
        for (int i = 0; i < n; i++) {
            System.out.println(new String(o[i]));
        }

        System.out.printf("Time Taken : %d units",dist[er][ec]);
    }
}

