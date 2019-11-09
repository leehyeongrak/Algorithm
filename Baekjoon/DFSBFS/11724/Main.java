// 연결 요소의 개수
import java.io.*;
import java.util.*;

public class Main {
    static int count;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        int[][] m = new int[vertexCount][vertexCount];

        for (int i = 0; i < edgeCount; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            m[first-1][second-1] = 1;
            m[second-1][first-1] = 1;
        }

        count = 1;
        visited = new int[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            if (visited[i] == 0) {
                dfs11724(m, i);
                count++;
            }
        }

        bw.write(count-1 + "");
        bw.flush();
        bw.close();
    }

    public static void dfs11724(int[][] m, int v) {
        visited[v] = count;

        for (int i = 0; i < m.length; i++) {
            if (m[v][i] == 1 && visited[i] == 0) {
                dfs11724(m, i);
            }
        }
    }
}
