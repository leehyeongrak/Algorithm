import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int m;
    static int[] numbers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        numbers = new int[n];
        int[] results = new int[m];
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        backtracking15650(0, 0, results);
    }

    public static void backtracking15650(int current, int count, int[] results) {

        if (count == m) {
            for (int r: results) {
                System.out.print(r+1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = current; i < n; i++) {
            if (!visited[i]) {
                current = numbers[i];
                visited[i] = true;
                results[count] = i;
                backtracking15650(current, count+1, results);
                visited[i] = false;
            }
        }
    }
}
