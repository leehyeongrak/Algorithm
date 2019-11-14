import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());

        int start = 1;
        int sum = 0;
        while (true) {
            int last = start +2*(n-1);
            sum += start;
            sum += last;
            n --;
            start = last + 2*n;
            n --;
            if (n == 1) {
                sum += start;
                break;
            } else if (n == 0) {
                break;
            }
        }

        System.out.print(sum);
    }
}
