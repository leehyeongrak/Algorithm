// 1, 2, 3 더하기
import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int caseNumber = Integer.parseInt(st.nextToken());
        for (int i = 0; i < caseNumber; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);

            int number = Integer.parseInt(st.nextToken());
            HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
            int value = baekjoon9095(number, dp);

            bw.write(String.valueOf(value)+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int baekjoon9095(int index, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 2;
        } else if (index == 3) {
            return 4;
        } else {
            int value = baekjoon9095(index - 1, dp) + baekjoon9095(index - 2, dp) + baekjoon9095(index - 3, dp);
            dp.put(index, value);
            return value;
        }
    }
}
