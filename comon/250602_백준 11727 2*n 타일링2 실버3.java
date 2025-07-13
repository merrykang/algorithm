import java.io.*;
import java.util.*;

public class Main {
    static int[] cases = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cases[1] = 1;
        cases[2] = 3;
        System.out.print(dp(n));
    }

    public static int dp(int n) {
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0)
                cases[i] = (cases[i - 1] * 2 + 1) % 10007;
            else
                cases[i] = (cases[i - 1] * 2 - 1) % 10007;
        }
        return cases[n];
    }
}
