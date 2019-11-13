import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] relations;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int computers = Integer.parseInt(st.nextToken());
        visited = new boolean[computers+1];
        s = br.readLine();
        st = new StringTokenizer(s);
        int networks = Integer.parseInt(st.nextToken());

        relations = new int[computers][computers];
        for (int i = 0; i < networks; i++) {
            s = br.readLine();
            st = new StringTokenizer(s);
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            relations[left][right] = 1;
            relations[right][left] = 1;
        }

        for (int i = 0; i < computers; i++) {
            if (relations[0][i] == 1) {
                dfs2606(i);
            }
        }

        int count = 0;
        for (boolean v: visited) {
            if(v) {
                count ++;
            }
        }

        System.out.print(count - 1);
    }

    public static void dfs2606(int index) {
        if (!visited[index]) {
            visited[index] = true;
        }

        for (int i = 0; i < relations.length; i++) {
            if (relations[index][i] == 1 && !visited[i]) {
                dfs2606(i);
            }
        }
    }
}
