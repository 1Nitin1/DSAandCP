package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class DFSMazeGUI extends JFrame {

    JTextField nField, mField;
    JTextArea mazeInput, mazeOutput;
    JButton solveButton;

    int n, m;
    char[][] a;
    boolean[][] v;

    int sx, sy, ex, ey;

    int best = Integer.MAX_VALUE;
    List<int[]> bestpath = new ArrayList<>();
    List<int[]> cur = new ArrayList<>();

    int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

    public DFSMazeGUI() {
        setTitle("DFS Weighted Maze Solver");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new GridLayout(2, 4, 10, 10));

        top.add(new JLabel("Rows (n):"));
        nField = new JTextField();
        top.add(nField);

        top.add(new JLabel("Cols (m):"));
        mField = new JTextField();
        top.add(mField);

        solveButton = new JButton("Solve Maze");
        top.add(new JLabel(""));
        top.add(solveButton);

        add(top, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(1, 2));

        mazeInput = new JTextArea();
        mazeInput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        mazeInput.setBorder(BorderFactory.createTitledBorder("Enter Maze (n lines of m characters)"));
        center.add(new JScrollPane(mazeInput));

        mazeOutput = new JTextArea();
        mazeOutput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        mazeOutput.setEditable(false);
        mazeOutput.setBorder(BorderFactory.createTitledBorder("Output"));
        center.add(new JScrollPane(mazeOutput));

        add(center, BorderLayout.CENTER);

        solveButton.addActionListener(e -> solve());
    }

    // ===================== DFS Function =====================

    void dfs(int x, int y, int cost) {
        if (cost >= best) return;

        if (x == ex && y == ey) {
            best = cost;
            bestpath = new ArrayList<>(cur);
            return;
        }

        for (int[] mv : d) {
            int nx = x + mv[0];
            int ny = y + mv[1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (v[nx][ny] || a[nx][ny] == '#') continue;

            int w = 0;
            if (a[nx][ny] >= '1' && a[nx][ny] <= '9') {
                w = a[nx][ny] - '0';
            }

            v[nx][ny] = true;
            cur.add(new int[]{nx, ny});

            dfs(nx, ny, cost + w);

            cur.remove(cur.size() - 1);
            v[nx][ny] = false;
        }
    }

    // ===================== Solve Button Handler =====================

    void solve() {
        mazeOutput.setText("");
        best = Integer.MAX_VALUE;
        bestpath.clear();
        cur.clear();

        try {
            n = Integer.parseInt(nField.getText());
            m = Integer.parseInt(mField.getText());

            a = new char[n][m];
            v = new boolean[n][m];

            String[] lines = mazeInput.getText().split("\n");

            if (lines.length != n) {
                mazeOutput.setText("Error: You must enter exactly " + n + " lines.");
                return;
            }

            for (int i = 0; i < n; i++) {
                String row = lines[i].trim();
                if (row.length() != m) {
                    mazeOutput.setText("Row " + i + " must be exactly " + m + " characters.");
                    return;
                }

                a[i] = row.toCharArray();

                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 'S') { sx = i; sy = j; }
                    if (a[i][j] == 'E') { ex = i; ey = j; }
                }
            }

            long start = System.currentTimeMillis();

            v[sx][sy] = true;
            cur.add(new int[]{sx, sy});
            dfs(sx, sy, 0);

            long end = System.currentTimeMillis();

            // Render result
            char[][] out = new char[n][m];
            for (int i = 0; i < n; i++)
                Arrays.fill(out[i], '.');

            if (best != Integer.MAX_VALUE) {
                for (int[] p : bestpath)
                    out[p[0]][p[1]] = '$';
            }

            StringBuilder sb = new StringBuilder();
            sb.append("=== Optimal Path ===\n");
            for (int i = 0; i < n; i++)
                sb.append(new String(out[i])).append("\n");

            if (best == Integer.MAX_VALUE)
                sb.append("\nNo path exists.\n");
            else
                sb.append("\nPath Cost: ").append(best).append(" units\n");

            sb.append("Execution Time: ").append(end - start).append(" ms\n");

            mazeOutput.setText(sb.toString());

        } catch (Exception ex) {
            mazeOutput.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DFSMazeGUI().setVisible(true));
    }
}

