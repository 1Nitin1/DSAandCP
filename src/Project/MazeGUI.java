package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MazeGUI {

    static class P {
        int r, c;
        P(int r, int c) { this.r = r; this.c = c; }
    }

    public static java.util.List<P> solve(char[][] g) {
        int n = g.length, m = g[0].length;
        int[][] d = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        boolean[][] vis = new boolean[n][m];
        P[][] par = new P[n][m];
        Queue<P> q = new LinkedList<>();

        if (g[0][0] == '#') return Collections.emptyList();

        vis[0][0] = true;
        q.add(new P(0,0));

        while (!q.isEmpty()) {
            P p = q.poll();
            if (p.r == n - 1 && p.c == m - 1)
                return build(par, p);

            for (int[] mv : d) {
                int nr = p.r + mv[0], nc = p.c + mv[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m &&
                        !vis[nr][nc] && g[nr][nc] == '0') {

                    vis[nr][nc] = true;
                    par[nr][nc] = p;
                    q.add(new P(nr, nc));
                }
            }
        }
        return Collections.emptyList();
    }

    private static java.util.List<P> build(P[][] par, P end) {
        LinkedList<P> path = new LinkedList<>();
        for (P p = end; p != null; p = par[p.r][p.c])
            path.addFirst(p);
        return path;
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Maze Solver GUI");
        f.setSize(900, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        JLabel title = new JLabel("Enter Maze (0 = path, # = wall). Start at top-left, End at bottom-right.",
                SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        f.add(title, BorderLayout.NORTH);

        JTextArea input = new JTextArea();
        input.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane sp1 = new JScrollPane(input);
        f.add(sp1, BorderLayout.WEST);
        sp1.setPreferredSize(new Dimension(400, 600));

        JTextArea output = new JTextArea();
        output.setEditable(false);
        output.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane sp2 = new JScrollPane(output);
        f.add(sp2, BorderLayout.CENTER);

        JButton solveBtn = new JButton("SOLVE");
        solveBtn.setFont(new Font("Arial", Font.BOLD, 16));
        f.add(solveBtn, BorderLayout.SOUTH);

        solveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] lines = input.getText().split("\n");
                if (lines.length == 0) {
                    output.setText("Invalid maze!");
                    return;
                }

                int n = lines.length;
                int m = lines[0].length();

                char[][] g = new char[n][m];
                for (int i = 0; i < n; i++) {
                    if (lines[i].length() != m) {
                        output.setText("All rows must have equal length!");
                        return;
                    }
                    g[i] = lines[i].toCharArray();
                }

                java.util.List<P> path = solve(g);

                if (path.isEmpty()) {
                    output.setText("NO PATH FOUND");
                    return;
                }

                boolean[][] mark = new boolean[n][m];
                for (P p : path)
                    mark[p.r][p.c] = true;

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        sb.append(mark[i][j] ? '$' : '.');
                    }
                    sb.append("\n");
                }

                output.setText(sb.toString());
            }
        });

        f.setVisible(true);
    }
}
