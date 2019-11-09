// 경로 찾기
import java.io.*;
import java.util.*;

public class Main {
    static int[][] m;
    static int[] v;
    static int[][] r;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int vertexCount = Integer.parseInt(st.nextToken());

        m = new int[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < vertexCount; j++) {
                int value = Integer.parseInt(st.nextToken());
                m[i][j] = value;
            }
        }

        v = new int[vertexCount];
        r = new int[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            dfs11403(m, i);
            for (int j = 0; j < vertexCount; j++) {
                r[i][j] = v[j];
            }
            Arrays.fill(v, 0);
        }

        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                bw.write(r[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs11403(int[][] m, int s) {
        for (int i = 0; i < m.length; i++) {
            if (m[s][i] == 1 && !(v[i] == 1)) {
                v[i] = 1;
                dfs11403(m, i);
            }
        }
    }
}
