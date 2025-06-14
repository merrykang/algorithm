import java.util.*;
import java.io.*;

/**
 * 문제 풀다가 궁금했던 부분
 * 1. "같은 색으로 이루어져 있는지" 판단하는 메서드 필요. 그 메서드는 무엇으로 구성되어 있어야 할까?
 *  - isUniform(x, y, size) : for (i=x~x+size) for (i=y~x+size) papers[x][y] != color 인지 아닌지 판단
 *  - return true: 해당 구역이 같은 색으로 이루어져 있음 / false: 다른 색이 있음
 * 
 * 2. 그렇다면 isUniform 메서드는 언제 호출되어야할까?
 *  - 구역을 나눌지 말지 결정할 때
 *  - isUniform = true 이면 색종이 개수를 세고, false이면 size/2로 구역을 나누어야 하기 때문
 *  - 계속 구역을 나누는 작업이 1개 색종이가 되거나, 구역의 모든 색종이의 색이 같다면 true
 *  - 1개 색종이라면 size=1 이라 같은 색인지 판단하는 반복문이 1번만 도니까 굳이 별도의 로직 필요 없음
 */

/**
 *  📘 분할 정복(🧩 Divide and Conquer) 알고리즘이란?
    ✅ 핵심 개념
    문제를 작고 유사한 하위 문제로 나눈 후(Divide),
    각각을 재귀적으로 해결하고(Conquer),
    그 결과를 합쳐서(Combine) 원래 문제의 해답을 구하는 방식입니다.
 */

 /**
  * ✅ 왜 재귀 함수(divide 메서드)를 main 함수 외부로 분리하는가?
    1. 코드를 역할별로 분리할 수 있어서 관리가 쉬움
    - main() 함수는 보통 입력 처리 + 출력에 집중
    - divide()는 문제의 재귀적 분할 처리만 담당
    2. 재귀 호출에는 자기 자신을 반복적으로 호출해야 하므로 함수화가 필수적
    - main() 함수 내에서 직접 divide(x, y, size)를 반복적으로 호출하는 구조는 어렵고 비효율적
  */

  /**
   * 왜 divide(x, y, half) 같은 재귀 호출을 4번 해야 하고, divide(...)를 한 번만 호출하면 안 되는 걸까?
   * 🔹 현재 영역이 4등분되기 때문에, 4개의 서브영역 각각에 대해 재귀 호출을 해야 합니다.
     🔸 한 번만 호출하면 그건 1개의 서브영역만 검사하는 것에 불과하므로, 전체 탐색을 하지 않게 되어 오답이 됩니다.
   */

public class Main {
    static int[][] papers;
    static int blue = 0; static int white = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 탐색 대상인 색종이 배열 입력 받기
        papers = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // (0,0) 위치부터 n 크기의 색종이 만들기
        divide(0, 0, n);

        // 정답 출력
        System.out.println(white);
        System.out.println(blue);
    }

    /**
     * 체크하려는 구역의 색종이가 같은 색인지 확인하고, 
     * 색종이의 개수를 세거나, 구역을 나누는 메서드
     * - 하나의 정사각형 칸이 된 것은 확인하지 않아도 되는지
     * 
     * @param x - 현재 탐색하는 x 인덱스
     * @param y - 현재 탐색하는 y 인덱스
     * @param size - 같은 색인지 탐색하는 색종이 크기
     */
    static void divide(int x, int y, int size) {
        if (isUniform(x, y, size)) {  // 잘라진 모든 색종이가 같은 색인 경우
            if (papers[x][y] == 1) blue++;
            else white++;
            return;
        }
        // 잘라진 색종이가 다른 색이 있는 경우 -> 구역을 size/2 크기로 4등분
        int half = size/2;
        divide(x, y, half);
        divide(x+half, y, half);
        divide(x, y+half, half);
        divide(x+half, y+half, half);
    }

    /**
     * 체크하려는 구역의 색종이가 같은 색인지 확인하는 메서드
     * 
     * @param x - 현재 탐색하는 x 인덱스
     * @param y - 현재 탐색하는 y 인덱스
     * @param size - 같은 색인지 탐색하는 색종이 크기
     * @return 현재 size 크기의 색종이가 모두 같은 색인지 여부
     */
    static boolean isUniform(int x, int y, int size) {
        int color = papers[x][y];  // 기준 색
        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (papers[i][j] != color) return false;  // 다른 색이 있으면 false
            }
        }
        return true;  // 모두 같은 색이면 true
    }
 }
