import java.util.*;
import java.io.*;

/**
 * 4번: 닥터스트레인저
 * - 풀이 소요 시간: 1시간 10분 (문제에 대한 소회 적는 시간 제외)
 * - 문제에 대한 소회
 * 1. 문제 유형: 완전 탐색, 재귀
 * 2. 풀이 과정
 * - 남은 경기에 대해 모든 가능한 승패 결과를 시뮬레이션 해야하므로 재귀 함수를 사용하였습니다.
 * - main 함수: 입력값에 따라 남은 경기인지, 진행된 경기인지 저장하고 재귀 함수 호출 후 정답 출력
 * - 재귀 함수
 * -> team1 이 승리 또는 team2가 승리하는 시나리오에 따라 재귀 함수 재호출
 * -> 모든 남은 경기의 승패가 결정되었다면 함수 종료, 팀 K가 단독 우승 했다면 정답 카운트
 * - 팀 K가 단독 우승 했는지 체크하는 메서드(예외 처리 담당)
 * -> 가장 많이 우승한 횟수가 팀 k의 우승 횟수가 아니라면 false 리턴
 * -> 가장 많이 우승한 횟수인 팀이 2팀 이상이라면 false 리턴
 * -> 그 외의 경우 true 리턴
 * 3. 시간 복잡도
 * - 입력 처리: 아직 진행되지 않은 경기와 현재 진행 결과 반복문으로 처리 -> O(M)
 * - 재귀 함수: remainingGames.size() 만큼 각각 2가지 시나리오가 만들어지므로 2^R 만큼 시간 걸림 -> O(2^R)
 * - isKSoloWinner 메서드: N개의 팀을 2번 탐색 -> O(N)
 * - 따라서 총 시간 복잡도는 O(2^R)
 */

public class Main {
  static int n, m, k;
  static ArrayList<int[]> remainingGames; // '남은 경기' 목록을 저장할 리스트
  static int ans; // 팀 K가 우승하는 경우의 수를 저장할 변수

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    int[] wins = new int[n + 1]; // 각 팀의 현재 승리 횟수를 저장할 배열 (인덱스는 1부터 사용)
    remainingGames = new ArrayList<>(); // 남은 게임(진행되어야 할 게임)을 담은 리스트

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int t1 = Integer.parseInt(st.nextToken());
      int t2 = Integer.parseInt(st.nextToken());
      int res = Integer.parseInt(st.nextToken());

      if (res == 0)
        remainingGames.add(new int[] { t1, t2 }); // 아직 진행되지 않은 경기는 리스트에 추가
      else if (res == 1)
        wins[res]++; // team1 승리
      else
        wins[res]++; // team2 승리
    }
    // 0번째 남은 경기부터 모든 경우의 수 탐색 시작
    ans = 0;
    solve(0, wins);
    System.out.println(ans);
  }

  /**
   * 남은 경기들에 대해 모든 승패 경우의 수를 탐색하는 재귀 함수
   * 
   * @param gameIndex   현재 결정할 경기의 인덱스 (remainingGames 리스트 기준)
   * @param currentWins 현재까지의 승리 횟수 배열
   */
  static void solve(int gameIndex, int[] currentWins) {
    if (gameIndex == remainingGames.size()) { // 모든 남은 경기의 승패가 결정된 경우 함수 종료
      if (isKSoloWinner(currentWins))
        ans++; // 팀 K가 단독 우승했다면 정답에 카운트
      return; // 재귀 종료
    }

    int[] game = remainingGames.get(gameIndex);
    int teamA = game[0];
    int teamB = game[1];

    // 경우 1: teamA가 승리하는 시나리오
    currentWins[teamA]++;
    solve(gameIndex + 1, currentWins);
    currentWins[teamA]--; // 상태 원상 복구 (백트래킹)

    // 경우 2: teamB가 승리하는 시나리오
    currentWins[teamB]++;
    solve(gameIndex + 1, currentWins);
    currentWins[teamB]--; // 상태 원상 복구 (백트래킹)
  }

  /**
   * 주어진 승리 횟수 배열에서 팀 K가 단독 우승했는지 판별하는 메서드
   * 
   * @param wins 최종 승리 횟수 배열
   * @return 단독 우승 여부 (true/false)
   */
  static boolean isKSoloWinner(int[] wins) {
    int kWins = wins[k];
    int maxWins = 0;
    int maxWinsTeamCount = 0;

    // 전체 팀을 순회하며 최대 승리 횟수를 찾음
    for (int i = 1; i <= n; i++) {
      if (wins[i] > maxWins)
        maxWins = wins[i];
    }

    // 팀 K의 승리 횟수가 최대 승리 횟수와 다르면 우승이 아님
    if (kWins != maxWins)
      return false;

    // 최대 승리 횟수인 팀이 몇 팀인지 카운트
    for (int i = 1; i <= n; i++) {
      if (wins[i] == maxWins)
        maxWinsTeamCount++;
    }

    // 최대 승리 횟수인 팀이 1팀일 경우에만 단독 우승(true). 2팀 이상이면 false
    return maxWinsTeamCount == 1;
  }
}