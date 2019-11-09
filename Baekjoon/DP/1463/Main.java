// 1로 만들기
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

        int value = baekjoon1463(number, dp);

        bw.write(String.valueOf(value));
        bw.flush();
        bw.close();
    }

    public static int baekjoon1463(int index, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        } else if (index == 1) {
            return 0;
        } else {
            int min = makeToOneDP(index - 1, dp);
            if (index % 3 == 0) {
                int modThree = baekjoon1463(index / 3, dp);
                if (modThree < min) {
                    min = modThree;
                }
            }
            if (index % 2 == 0) {
                int modTwo = baekjoon1463(index / 2, dp);
                if (modTwo < min) {
                    min = modTwo;
                }
            }
            int value = min + 1;
            dp.put(index, value);
            return value;
        }
    }
}
