import java.util.*;
import java.io.*;

// 매개 변수 사용
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] cards = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      cards[i] = Integer.parseInt(st.nextToken());

    // n개 카드 중 3개 뽑는 조합 구하기
    // n이 100개 이하 정수이므로 브루트포스 + 백트래킹으로 모든 조합 구함
    int r = 3; // 카드 뽑는 개수(고정)
    // int ans = 0;
    int ans = combination(m, r, 0, cards, new ArrayList<>(), 0);

    // 조합 돌면서 합 구하고, 최댓값을 갱신
    System.out.println(ans);

  }

  static int combination(int m, int r, int start, int[] cards, List<Integer> temp, int max) {
    // 골라야하는 숫자 개수만큼 다 고른 경우
    if (temp.size() == r) {
      // M을 넘지 않으면서 M에 최대한 가까운 최댓값 갱신
      int sum = 0;
      for (int t : temp)
        sum += t;
      if (sum <= m)
        max = Math.max(max, sum);
      return max; // 업데이트된 max 를 리턴하지 않으면 업데이트 되지 않아서 계속 0으로 답이 출력됨
    }

    for (int i = start; i < cards.length; i++) {
      // 현재 숫자 선택
      temp.add(cards[i]);
      // 다음 숫자 선택
      max = combination(m, r, i + 1, cards, temp, max);
      // 백트래킹: temp 리스트의 마지막 원소를 하나 제거하여 다음 원소를 체크할 준비
      temp.remove(temp.size() - 1);
    }

    return max;
  }
}

// static 변수 사용
// public class Main {
// static int[] cards;
// static List<Integer> temp = new ArrayList<>();
// static int ans = 0;
// static int m;

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());
// int n = Integer.parseInt(st.nextToken());
// m = Integer.parseInt(st.nextToken());
// cards = new int[n];
// st = new StringTokenizer(br.readLine());
// for (int i=0; i<n; i++) cards[i] = Integer.parseInt(st.nextToken());

// // n개 카드 중 3개 뽑는 조합 구하기
// // n이 100개 이하 정수이므로 브루트포스 + 백트래킹으로 모든 조합 구함
// int r = 3; // 카드 뽑는 개수(고정)
// combination(r, 0);

// // 조합 돌면서 합 구하고, 최댓값을 갱신
// System.out.println(ans);

// }

// static void combination(int r, int start) {
// // 골라야하는 숫자 개수만큼 다 고른 경우
// if (temp.size() == r) {
// // M을 넘지 않으면서 M에 최대한 가까운 최댓값 갱신
// int sum = 0;
// for (int t : temp) sum += t;
// if (sum <= m) ans = Math.max(ans, sum);
// return;
// }

// for (int i = start; i<cards.length; i++) {
// // 현재 숫자 선택
// temp.add(cards[i]);
// // 다음 숫자 선택
// combination(r, i+1);
// // 백트래킹: temp 리스트의 마지막 원소를 하나 제거하여 다음 원소를 체크할 준비
// temp.remove(temp.size() - 1);
// }
// }
// }

// Q. 위 코드를 실행하면 동일한 조합인 {1, 2, 3}과 {1, 3, 2}가 모두 result에 들어갈 수 있는 것 아닌지?
// A. 그럴 수 없음. for 루프를 start부터 1씩 증가시키면서 돌리기 때문

// 조합 개수 계산하기
// static long combination(int n, int r) {
// if (r > n) return 0; // 뽑는 개수 r은 n보다 클 수 없음
// long result = 1;
// for (int i=1; i<=r; i++) {
// result = result * (n - i + 1) / i;
// }
// return result;
// }