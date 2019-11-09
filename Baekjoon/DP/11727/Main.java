// 2*N 타일링 2
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
        int value = baekjoon11727(number, dp);

        bw.write(String.valueOf(value));
        bw.flush();
        bw.close();
    }

    public static int baekjoon11727(int index, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        } else if (index == 1) {
            return 1;
        } else if (index == 2) {
            return 3;
        } else {
            int value = baekjoon11727(index - 1, dp) + baekjoon11727(index - 2, dp)*2;
            value %= 10007;
            dp.put(index, value);
            return value;
        }
    }
}
// 타일링 1번에서 2*2 타일 추가, N번째는 N-1번째에 2*1 타일을 하나 붙일 수 있고, N-2번째에 2*1타일 두개와 2*2 타일 하나를 붙일 수 있기 때문에 N = N-1 + (N-2)*2 점화식이 성립
