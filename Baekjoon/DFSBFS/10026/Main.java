// 적록색약
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        m = new char[n][n];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            char[] temp = s.toCharArray();
            for (int j = 0; j < n; j++) {
                m[i][j] = temp[j];
            }
        }

        visited = new boolean[n][n];
        count = 0;
        for (int i = 0; i < n*n; i++) {
            if (!visited[i/n][i%n]) {
                dfs10026(i/n, i%n, m[i/n][i%n]);
                count ++;
            }
        }
        bw.write(count + " ");
        visited = new boolean[n][n];
        count = 0;
        for (int i = 0; i < n*n; i++) {
            if (m[i/n][i%n] == 'G') {
                m[i/n][i%n] = 'R';
            }
        }
        for (int i = 0; i < n*n; i++) {
            if (!visited[i/n][i%n]) {
                dfs10026(i/n, i%n, m[i/n][i%n]);
                count ++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static void dfs10026(int x, int y, char c) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny]) {
                    if (m[nx][ny] == c) {
                        dfs10026(nx, ny, c);
                    }
                }
            }
        }
    }
}
