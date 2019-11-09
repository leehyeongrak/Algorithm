// 2*N 타일링 1
import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int number = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
        int value = baekjoon11726(number, dp);

        bw.write(String.valueOf(value));
        bw.flush();
        bw.close();
    }

    public static int baekjoon11726(int index, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 2;
        } else {
            int value = baekjoon11726(index - 1, dp) + baekjoon11726(index - 2, dp);
            value %= 10007;
            dp.put(index, value);
            return value;
        }
    }
}
