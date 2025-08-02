import java.util.*;
import java.io.*;

/**
 * 2번: 이름 가공 로봇
 * - 풀이 소요 시간: 25분 (문제에 대한 소회 적는 시간 제외)
 * - 문제에 대한 소회
 * 1. 문제 유형: 문자열, 구현
 * 2. 풀이 과정
 * - 문제에서 주어진 이름 가공 순서에 따라 구현하였고, 각 과정의 핵심 메서드는 이하 소스 코드에 표기하였습니다.
 * 3. 시간 복잡도
 * - 입력 처리: split 할 때 O(N)
 * - 1번 과정: for문으로 인해 O(N)
 * - 2번 과정: 문자열 길이 최대 N만큼 실행되므로 O(N)
 * - 3번, 4번, 5번 과정: insert, reverse 메서드는 문자열 길이에 비례하는 시간 복잡도를 가지므로 O(N)
 * - 따라서 총 시간 복잡도는 O(N) 입니다.
 */

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int num = Integer.parseInt(input[0]);
    String[] name = input[1].split("");

    // 1. 중복되는 글자 제거 (글자 순서 유지) -> 이를 위해 LinkedHashSet 자료 구조 이용
    Set<String> notDuplicate = new LinkedHashSet<>();
    int duplicateCnt = 0;
    for (int i = 0; i < name.length; i++) {
      if (!notDuplicate.add(name[i]))
        duplicateCnt++;
    }

    // 2. 1번 절차로 가공된 이름 뒤에 중복되서 제거한 문자의 갯수를 덧붙임 -> 이를 위해 append() 메서드 이용
    StringBuilder sb = new StringBuilder();
    for (String s : notDuplicate)
      sb.append(s);
    sb.append(duplicateCnt);

    // 3. 2번 절차로 가공된 문자열 앞에 영어이름의 일련번호를 덧붙임 -> 이를 위해 insert() 메서드 이용
    sb.insert(0, num);

    // 4. 3번 절차로 가공된 문자열을 거꾸로 뒤집음 -> 이를 위해 reverse() 메서드 이용
    sb.reverse();

    // 5. 4번을 통해 만들어진 문자열 맨 앞에 "ilovenam_"를 붙임
    sb.insert(0, "ilovenam_");

    // 정답 출력
    System.out.println(sb);
  }
}