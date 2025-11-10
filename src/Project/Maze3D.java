package Project;

import java.util.*;

public class Maze3D {

    static class Cell {
        int z, x, y;
        Cell(int z, int x, int y) { this.z = z; this.x = x; this.y = y; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read dimensions
        System.out.print("Enter number of layers: ");
        int L = sc.nextInt();
        System.out.print("Enter number of rows: ");
        int R = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int C = sc.nextInt();
        sc.nextLine();

        char[][][] maze = new char[L][R][C];

        // -------- Input Layer by Layer ----------
        // replace the original layer input block with this safe version
        for (int z = 0; z < L; z++) {
            System.out.println("Layer " + z + ":");
            for (int r = 0; r < R; r++) {
                String row = sc.nextLine();
                row = row.replaceAll("\\s+","");        // remove any spaces
                while (row.length() != C) {
                    System.out.println("Row length must be " + C + " characters (0 or #). Re-enter layer " + z + " row " + r + ":");
                    row = sc.nextLine();
                    row = row.replaceAll("\\s+","");
                }
                maze[z][r] = row.toCharArray();
            }
        }


        // BFS to find optimal path
        List<Cell> path = solveMaze(maze, L, R, C);

        // Print result
        printMazeWithPath(maze, path, L, R, C);
    }

    // BFS shortest path in 3D
    static List<Cell> solveMaze(char[][][] maze, int L, int R, int C) {
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

        return new ArrayList<>(); // no path
    }

    // Reconstruct BFS path
    static List<Cell> buildPath(Cell[][][] parent, Cell end) {
        List<Cell> path = new ArrayList<>();
        Cell cur = end;
        while (cur != null) {
            path.add(cur);
            cur = parent[cur.z][cur.x][cur.y];
        }
        Collections.reverse(path);
        return path;
    }

    // Print maze with $ for path and . for everything else
    static void printMazeWithPath(char[][][] maze, List<Cell> path, int L, int R, int C) {
        boolean[][][] mark = new boolean[L][R][C];

        for (Cell c : path) {
            mark[c.z][c.x][c.y] = true;
        }

        System.out.println("\n=== SOLVED MAZE ===");
        for (int z = 0; z < L; z++) {
            System.out.println("Layer " + z + ":");
            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    if (mark[z][x][y]) System.out.print('$');
                    else System.out.print('.');
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
