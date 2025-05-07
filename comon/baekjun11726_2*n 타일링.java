import java.util.*;
import java.io.*;

public class Main {
  public static int[] cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if (n == 1) {
      System.out.println(1);
      return;
    }
    // cnt = new int[n + 1];
    int prev2 = 1;
    int prev1 = 2;
    int cur = 0;
    for (int i = 3; i <= n; i++) {
      cur = (prev1 + prev2) % 10007;
      prev2 = prev1;
      prev1 = cur;
      // cnt[i] = (cnt[i-1] + cnt[i-2])%10007;
    }
    // System.out.println(Arrays.toString(cnt));
    System.out.println(prev1);
  }
}

public class Main {
  public static int[] cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if (n == 1) {
      System.out.println(1);
      return;
    }
    cnt = new int[n + 1];
    cnt[1] = 1;
    cnt[2] = 2;
    /**
     * mod 연산을 한 결과값을 출력해야 할 때에는 반드시 연산할 때마다 mod 연산을 해주어야 한다.
     * 계속 숫자를 더하고 마지막 출력시에만 mod연산을 해줄 경우 Integer.MAX_VALUE를 넘어 Overflow가 발생하기 때문에
     * 잘못된 값이 출력될 수 있다.
     * 그 이유? int 최대값: 2,147,483,647 (약 21억), 이 범위를 넘는 덧셈 결과는 오버플로우 발생 → 음수로 바뀌거나 잘못된
     * 값
     * 현재 문제의 경우 cnt[i-1]와 cnt[i-2]가 모두 10억 이상일 경우, 덧셈 결과는 20억을 넘어서 오버플로우 발생
     * 따라서 항상 ~의 나머지인 mod 연산을 답으로 요구할 때는
     */
    for (int i = 3; i <= n; i++)
      cnt[i] = (cnt[i - 1] + cnt[i - 2]) % 10007;
    // System.out.println(Arrays.toString(cnt));
    System.out.println(cnt[n]);
  }
}