// DFS와 BFS
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        int[][] edges = new int[edgeCount][edgeCount];

        for (int i = 0; i < edgeCount; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            edges[a][b] = 1;
            edges[b][a] = 1;
        }

        boolean[] marks = new boolean[edgeCount];

        dfsR(edges, marks, startVertex - 1);
        System.out.println();

        for (int i = 0; i < marks.length; i++) {
            marks[i] = false;
        }

        bfs(edges, marks, startVertex - 1);

        bw.flush();
        bw.close();
    }

    public static void dfsR(int[][] g, boolean[] m, int v) {
        m[v] = true;
        System.out.print(v+1 + " ");

        for (int i = 0; i < g.length; i++) {
            if (g[v][i] == 1 && !m[i]) {
                dfsR(g, m, i);
            }
        }
    }

    public static void bfs(int[][] g, boolean[] m, int v) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        m[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v+1 + " ");
            for (int i = 0; i < g.length; i++) {
                if (g[v][i] == 1 && !m[i]) {
                    q.add(i);
                    m[i] = true;
                }
            }
        }
    }
}
