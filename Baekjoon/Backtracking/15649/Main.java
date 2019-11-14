import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n];

        int[] numbers = new int[n];
        int[] results = new int[m];
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        backtracking15649(0, results, visited);
    }

    public static void backtracking15649(int count, int[] results, boolean[] visited) {

        if (count == m) {
            for (int r: results) {
                System.out.print(r+1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                results[count] = i;
                backtracking15649(count+1, results, visited);
                visited[i] = false;
            }
        }
    }
}
