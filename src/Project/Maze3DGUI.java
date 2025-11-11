package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Maze3DGUI {

    static class Cell {
        int z, x, y;
        Cell(int z, int x, int y) { this.z = z; this.x = x; this.y = y; }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("3D Maze Solver GUI");
        f.setSize(1100, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "Enter 3D maze (layers separated by blank line). Use 0=path, #=wall. Start=(0,0,0), End=(L-1,R-1,C-1)",
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 16));
        f.add(title, BorderLayout.NORTH);

        // ---------- INPUT AREA ----------
        JTextArea input = new JTextArea();
        input.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane sp1 = new JScrollPane(input);
        sp1.setPreferredSize(new Dimension(450, 700));
        f.add(sp1, BorderLayout.WEST);

        // ---------- OUTPUT AREA ----------
        JTextArea output = new JTextArea();
        output.setFont(new Font("Monospaced", Font.PLAIN, 16));
        output.setEditable(false);
        JScrollPane sp2 = new JScrollPane(output);
        f.add(sp2, BorderLayout.CENTER);

        // ---------- SOLVE BUTTON ----------
        JButton solveBtn = new JButton("SOLVE 3D MAZE");
        solveBtn.setFont(new Font("Arial", Font.BOLD, 18));
        f.add(solveBtn, BorderLayout.SOUTH);

        solveBtn.addActionListener(e -> {

            String text = input.getText().trim();
            if (text.isEmpty()) {
                output.setText("Input is empty!");
                return;
            }

            // Split layers by blank line
            String[] layerBlocks = text.split("\\n\\s*\\n");
            int L = layerBlocks.length;

            java.util.List<char[][]> layerList = new ArrayList<>();

            int R = -1, C = -1;

            for (int z = 0; z < L; z++) {
                String[] rows = layerBlocks[z].split("\n");

                if (R == -1) R = rows.length;

                if (rows.length != R) {
                    output.setText("All layers must have the same number of rows!");
                    return;
                }

                char[][] layer = new char[R][];
                for (int r = 0; r < R; r++) {

                    String row = rows[r].replaceAll("\\s+","");
                    if (C == -1) C = row.length();

                    if (row.length() != C) {
                        output.setText("Row length mismatch in layer " + z + ", row " + r);
                        return;
                    }

                    layer[r] = row.toCharArray();

                }
                layerList.add(layer);
            }

            char[][][] maze = new char[L][R][C];
            for (int i = 0; i < L; i++) maze[i] = layerList.get(i);

            java.util.List<Cell> path = solveMaze(maze, L, R, C);

            output.setText(formatOutput(maze, path, L, R, C));

        });

        f.setVisible(true);
    }

    // -------------------------------------------
    // BFS shortest path in 3D
    // -------------------------------------------
    static java.util.List<Cell> solveMaze(char[][][] maze, int L, int R, int C) {

        boolean[][][] visited = new boolean[L][R][C];
        Cell[][][] parent = new Cell[L][R][C];

        int[] dz = {1, -1, 0, 0, 0, 0};
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {0, 0, 0, 0, 1, -1};

        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(0, 0, 0));
        visited[0][0][0] = true;

        int targetZ = L - 1, targetX = R - 1, targetY = C - 1;

        while (!q.isEmpty()) {
            Cell cur = q.poll();

            if (cur.z == targetZ && cur.x == targetX && cur.y == targetY) {
                return buildPath(parent, cur);
            }

            for (int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C) continue;
                if (maze[nz][nx][ny] == '#') continue;
                if (visited[nz][nx][ny]) continue;

                visited[nz][nx][ny] = true;
                parent[nz][nx][ny] = cur;
                q.add(new Cell(nz, nx, ny));
            }
        }

        return new ArrayList<>(); // no path found
    }

    static java.util.List<Cell> buildPath(Cell[][][] parent, Cell end) {
        java.util.List<Cell> path = new ArrayList<>();
        Cell cur = end;
        while (cur != null) {
            path.add(cur);
            cur = parent[cur.z][cur.x][cur.y];
        }
        Collections.reverse(path);
        return path;
    }

    // -------------------------------------------
    // Pretty output
    // -------------------------------------------
    static String formatOutput(char[][][] maze, java.util.List<Cell> path,
                               int L, int R, int C) {

        boolean[][][] mark = new boolean[L][R][C];
        for (Cell c : path) mark[c.z][c.x][c.y] = true;

        StringBuilder sb = new StringBuilder();

        sb.append("=== SOLVED 3D MAZE ===\n\n");

        if (path.isEmpty()) {
            sb.append("NO PATH FOUND\n");
            return sb.toString();
        }

        for (int z = 0; z < L; z++) {
            sb.append("Layer ").append(z).append(":\n");
            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    sb.append(mark[z][x][y] ? '$' : '.');
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

