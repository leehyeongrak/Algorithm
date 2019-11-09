// 피보나치
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

        int value = fibonacciDP(number, dp);
        bw.write(String.valueOf(value));
        bw.flush();
        bw.close();
    }

    public static int fibonacciDP(int index, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        } else if (index == 0) {
            return 0;
        } else if (index <= 2) {
            return 1;
        } else {
            int value = fibonacciDP(index - 1, dp) + fibonacciDP(index - 2, dp);
            dp.put(index, value);
            return value;
        }
    }
}
