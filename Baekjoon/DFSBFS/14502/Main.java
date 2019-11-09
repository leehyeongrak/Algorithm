// 연구소
import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int[][] map;
    static boolean[] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m*n];
        for (int i = 0; i < m; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        makeWalls(0,0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    public static void makeWalls(int start, int count) {
        if (count == 3) {
            int[][] madeMap = new int[m][n];
            for (int i = 0; i < m*n; i++) {
                if (visited[i]) {
                    madeMap[i/n][i%n] = 1;
                } else {
                    madeMap[i/n][i%n] = map[i/n][i%n];
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (madeMap[i][j] == 2) {
                        spreadVirus(madeMap, i, j);
                    }
                }
            }

            int safeArea = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (madeMap[i][j] == 0) {
                        safeArea ++;
                    }
                }
            }
            if (safeArea > max) {
                max = safeArea;
            }

            return;
        }

        for (int i = start; i < m*n; i++) {
            if (map[i/n][i%n] == 0) {
                visited[i] = true;
                makeWalls(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    public static void spreadVirus(int[][] map, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    spreadVirus(map, nx, ny);
                }
            }
        }
    }
}
