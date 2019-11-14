import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int m;
    static int[] numbers;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        int[] results = new int[m];
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }
        sb = new StringBuilder();

        backtracking15651(0, results);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void backtracking15651(int count, int[] results) {

        if (count == m) {
            for (int r: results) {
                sb.append((r+1) + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            results[count] = i;
            backtracking15651(count+1, results);
        }
    }
}
