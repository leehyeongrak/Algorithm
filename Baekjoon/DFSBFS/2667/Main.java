// 단지번호붙이기
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int nSize = Integer.parseInt(st.nextToken());
        int[][] m = new int[nSize][nSize];

        for (int i = 0; i < nSize; i++) {
            s = bf.readLine();
            for (int j = 0; j < nSize; j++) {
                int isPresent = s.charAt(j) - '0';
                m[i][j] = isPresent;
            }
        }

        int count = 2;
        int[] sum = new int[nSize*nSize];

        for (int i = 0; i < nSize; i++) {
            for (int j = 0; j < nSize; j++) {
                if (m[i][j] == 1) {
                    dfs2667(m, i, j, count, sum);
                    count ++;
                }
            }
        }

        Arrays.sort(sum);
        bw.write(count-2 + "\n");
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] != 0) {
                bw.write(sum[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void dfs2667(int[][] m, int x, int y, int count, int[] sum) {
        m[x][y] = count;
        sum[count] ++;

        for (int i = 0; i < m.length; i++) {
            if (x < m.length-1 && m[x+1][y] == 1) {
                m[x+1][y] = count;
                dfs2667(m, x+1, y, count, sum);
            }
            if (x > 0 && m[x-1][y] == 1) {
                m[x-1][y] = count;
                dfs2667(m, x-1, y, count, sum);
            }
            if (y < m.length-1 && m[x][y+1] == 1) {
                m[x][y+1] = count;
                dfs2667(m, x, y+1, count, sum);
            }
            if (y > 0 && m[x][y-1] == 1) {
                m[x][y-1] = count;
                dfs2667(m, x, y-1, count, sum);
            }
        }
    }
}
