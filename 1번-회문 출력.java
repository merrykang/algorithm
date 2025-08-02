import java.util.*;
import java.io.*;

/**
 * 1번: 회문 출력
 * - 풀이 소요 시간: 35분 (문제에 대한 소회 적는 시간 제외)
 * - 문제에 대한 소회
 * 1. 문제 유형: 팰린드롬 수 찾기, 구현
 * 2. 풀이 과정
 * - '앞으로 읽으나 뒤로 읽으나 같은 수'를 팰린드롬 수라고 하며, 이를 구하는 문제입니다.
 * - 입력값 n에 따라 1부터 반복하며 팰린드롬 수 인지 판단하고, 팰린드롬 수라면 해당 숫자를 StringBuilder에 저장합니다.
 * - 팰린드롬 수인지 판단하는 로직은 기존 숫자를 문자열로 변환하고, StringBuilder 를 사용해 거꾸로 된 문자열을 만들어 양자가
 * 같은지 비교하는 것입니다.
 * 3. 시간 복잡도
 * - findPalindromes 메서드: 반복문에 의해 O(N) 발생
 * - isPalindrome 메서드: 문자열 길이에 따라 logN 시간 발생 * n번 반복 -> NlogN
 * - 따라서 총 시간 복잡도는 O(N logN)
 * 4. 기타
 * - 입력값의 제한이 있었다면 보다 명확한 코드를 작성할 수 있었을 것 같아 아쉽습니다!
 * - 현재 코드는 n이 5,000,000 정도이면 시간 초과가 발생합니다.
 * - 만약 시간 초과가 발생한다면 팰린드롬 수인지 확인하는 것이 아니라, 특정 숫자가 주어지면 팰린드롬 수를 생성하는 방식으로 구현하면 좋을
 * 것 같습니다. ex) 123이라는 숫자로 12321 생성
 */

public class Main {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // 팰린드롬 수 찾고, 정답 출력
    findPalindromes(n);
    System.out.println(sb);
  }

  static void findPalindromes(int n) {
    for (int i = 1; i <= n; i++) {
      if (isPalindrome(i))
        sb.append(i + ", ");
    }
    sb.setLength(sb.length() - 2); // 마지막 글자와 두 번째 마지막 글자에 추가된 ,와 공백 제거
    return;
  }

  static boolean isPalindrome(int i) {
    String original = String.valueOf(i); // 기존 숫자를 문자열로 변경
    String reversed = new StringBuilder(original).reverse().toString(); // 기존 숫자를 거꾸로 저장
    return original.equals(reversed); // 기존 숫자와 거꾸로 된 숫자가 동일하면 true, 그 외는 false
  }
}