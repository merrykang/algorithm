import java.util.*;
import java.io.*;

/**
 * 3번: 불면증
 * - 풀이 소요 시간: 45분 (문제에 대한 소회 적는 시간 제외)
 * - 문제에 대한 소회
 * 1. 문제 유형: 구현
 * 2. 풀이 과정
 * - 주어진 숫자 N의 배수(N, 2N, 3N...)를 차례로 만들어 나가며 그 숫자의 각 자리가 set에 있는지 체크합니다.
 * - 각 배수 값을 문자열로 변환한 뒤, 그 숫자를 구성하는 모든 자릿수를 추출하여 HashSet에 저장합니다.
 * - HashSet은 중복된 값을 허용하지 않으므로, 이 과정을 통해 지금까지 등장한 0에서 9까지의 모든 고유한 자릿수들이 기록됩니다.
 * - HashSet의 크기가 10이 되는 순간, 즉 0부터 9까지의 모든 숫자가 최소 한 번 이상 등장하면 반복을 멈추고 그때의 배수 값을
 * 최종 결과로 반환합니다.
 * - 만약 초기 입력값 N이 0이라면 영원히 0만 나오므로, 이 경우는 예외 처리하여 "INSOMNIA"를 출력합니다.
 * 3. 시간 복잡도
 * - main 메서드: t 크기만큼 반복문 -> O(T)
 * - checkNumInSet 메서드: while 루프의 한 번의 반복은 [checkNum 숫자의 자릿수 * while문 반복 횟수]에
 * 비례하는 시간이 걸림
 * - 그러나 제한 사항으로 볼 때 0 ≤ N ≤ 10000 이므로 [checkNum 숫자의 자릿수 * while문 반복 횟수] 는 상수
 * 시간에 수렴하는 시간 복잡도 걸림
 * - 따라서 총 시간 복잡도는 O(T) 입니다.
 */

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 1; i <= t; i++) {
      int n = Integer.parseInt(br.readLine());
      // 예외 처리: 0인 경우 다른 수를 아무리 곱해도 0~9까지 숫자를 모두 확인할 수 없으므로 INSOMNIA 출력
      if (n == 0)
        System.out.println("Case #" + i + ": INSOMNIA");
      // 0~9까지 숫자를 모두 외친 경우
      else
        System.out.println("Case #" + i + ": " + checkNumInSet(n, 1, new HashSet<>()));
    }
  }

  // 처음 보는 수(0-9)가 있는지 확인하고, 0-9의 숫자를 모두 외친 경우 현재의 체크 숫자 반환
  static int checkNumInSet(int n, int multiplier, Set<Integer> memory) {
    int num = n;
    while (memory.size() < 10) { // HashSet은 중복 없이 원소를 가지므로, 0-9의 숫자를 모두 외친 경우 = set의 크기가 10인 경우로 처리
      num = n * multiplier;
      String[] checkNum = String.valueOf(num).split("");
      for (String s : checkNum) {
        int currentNum = Integer.parseInt(s);
        memory.add(currentNum); // HashSet은 중복 없이 원소를 가지므로, currentNum의 중복 여부를 체크하지 않고 원소 삽입 가능
      }
      multiplier += 1;
    }
    return num;
  }
}