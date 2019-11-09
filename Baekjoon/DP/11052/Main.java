// 카드 구매하기
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

        s = bf.readLine();
        st = new StringTokenizer(s);

        int[] cards = new int[caseNumber];
        for (int i = 0; i < caseNumber; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
        int value = baekjoon11052(cards, caseNumber - 1, dp);

        bw.write(String.valueOf(value));
        bw.flush();
        bw.close();
    }

    public static int baekjoon11052(int[] cards, int index, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        } else if (index == -1) {
            return 0;
        } else if (index == 0) {
            return cards[0];
        } else {
            int max = 0;
            for (int i = 0; i <= index; i++) {
                int price = cards[i] + baekjoon11052(cards, index - i - 1, dp);
                if (price > max) {
                    max = price;
                }
            }
            dp.put(index, max);
            return max;
        }
    }
}

// 총 카드의 개수가 10개라고 치면, 카드를 1개짜리 팩을 사면 9개를 살 때의 최댓값 => dp(9)을 가져와야 함
// 카드를 2개짜리 팩을 사면 나머지 8개를 살 때의 dp 최댓값을 가져와야 함
// …
// 카드 10개짜리 팩을 사면 dp를 가져오지 않아도 됨
// 위의 경우의 수 중에서 max 값을 구함
