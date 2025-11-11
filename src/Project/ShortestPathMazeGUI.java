package Project;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ShortestPathMazeGUI extends JFrame {

    JTextArea inputArea;
    JTextArea outputArea;
    JButton solveButton;

    public ShortestPathMazeGUI() {
        setTitle("Maze Shortest Path Solver (Dijkstra)");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Input Area
        inputArea = new JTextArea();
        inputArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane leftPane = new JScrollPane(inputArea);
        leftPane.setBorder(BorderFactory.createTitledBorder("Enter Maze Here"));

        // Output Area
        outputArea = new JTextArea();
        outputArea.setFont(new Font("Monospaced", Font.BOLD, 16));
        outputArea.setEditable(false);
        JScrollPane rightPane = new JScrollPane(outputArea);
        rightPane.setBorder(BorderFactory.createTitledBorder("Solved Maze Output"));

        // ✅ Force visible split
        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                leftPane,
                rightPane
        );
        split.setDividerLocation(400); // show input side clearly
        split.setResizeWeight(0.5);

        // Solve Button
        solveButton = new JButton("Solve Maze");
        solveButton.setFont(new Font("Arial", Font.BOLD, 18));
        solveButton.addActionListener(e -> solveMaze());

        add(split, BorderLayout.CENTER);
        add(solveButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    void solveMaze() {
        try {
            String[] lines = inputArea.getText().trim().split("\n");
            int n = lines.length;
            int m = n;

            char[][] g = new char[n][m];
            int sr = -1, sc = -1, er = -1, ec = -1;

            for (int i = 0; i < n; i++) {
                String s = lines[i];
                for (int j = 0; j < m; j++) {
                    g[i][j] = s.charAt(j);
                    if (g[i][j] == 'S') { sr = i; sc = j; }
                    if (g[i][j] == 'E') { er = i; ec = j; }
                }
            }

            long start = System.currentTimeMillis();

            int[][] dist = new int[n][m];
            int[][] pr = new int[n][m];
            int[][] pc = new int[n][m];
            for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

            class Cell { int r, c, d;
                Cell(int r, int c, int d){ this.r=r; this.c=c; this.d=d; }
            }

            PriorityQueue<Cell> pq = new PriorityQueue<>((a,b)->a.d-b.d);
            dist[sr][sc] = 0;
            pq.add(new Cell(sr, sc, 0));

            int[] dr = {1, -1, 0, 0};
            int[] dc = {0, 0, 1, -1};

            while (!pq.isEmpty()) {
                Cell cur = pq.poll();
                if (cur.d != dist[cur.r][cur.c]) continue;
                if (cur.r == er && cur.c == ec) break;

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

            if (dist[er][ec] == Integer.MAX_VALUE) {
                outputArea.setText("No Path");
                return;
            }

            // reconstruct path
            int r = er, c = ec;
            while (!(r == sr && c == sc)) {
                if (g[r][c] != 'E') g[r][c] = '$';
                int nr = pr[r][c], nc = pc[r][c];
                r = nr; c = nc;
            }

            g[sr][sc] = 'S';

            long end = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder("Optimal Path:\n\n");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    char ch = g[i][j];
                    if (ch != '$' && ch != 'S' && ch != 'E') ch = '.';
                    sb.append(ch);
                }
                sb.append("\n");
            }

            sb.append("\nCost = ").append(dist[er][ec]);
            sb.append("\nExecution Time = ").append(end - start).append(" ms");

            outputArea.setText(sb.toString());

        } catch (Exception ex) {
            outputArea.setText("❌ Invalid input! Make sure all rows have same length.");
        }
    }

    public static void main(String[] args) {
        new ShortestPathMazeGUI();
    }
}
