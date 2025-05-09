/**
 * 재귀로 풀기
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     static int[][] memo = new int[15][15];
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine());
//         StringBuilder sb = new StringBuilder();
//         // 1. 재귀 함수 호출
//         while (t-- > 0) {
//             int k = Integer.parseInt(br.readLine());
//             int n = Integer.parseInt(br.readLine());
//             sb.append(getResidents(k, n)+"\n");
//         }
//         System.out.println(sb);
//     }
//     // 2. 재귀 조건 정의
//     static int getResidents(int k, int n) {
//         // if (k==0) memo[0][n] = n;  // 0층이면 무조건 n > 점화식처럼 계속 값 할당하려고 하지 말고 return 할 값을 생각해!
//         if (k==0) return n;
//         if (n==1) return 1;  // 1호이면 무조건 1명
//         // 그런데 어떻게 이런 생각 할 수 있지 A. 값이 하나씩 줄어서 내려가면서 (3,3) 계산하기 위해서도 (2, 3) 계산하고, (2,4) 계산하기 위해서도 (2,3) 계산함
//         if (memo[k][n] != 0) return memo[k][n];  // 이미 기록된 값 있으면 그것 쓰기. 
//         // 변수에 값을 재할당하면서 바로 재귀 함수 호출 가능
//         return memo[k][n] = getResidents(k, n-1) + getResidents(k-1, n);  // 현재 호수 거주 사람 수 = 동일 층 이전 호 + 이전 층 동일 호
//     }
// }

/**
 * DP로 풀기
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine());

//         // 1. 0층 초기화
//         int[][] dp = new int[15][15];  // 1<= k, n <= 14 이므로; 15층 14호까지 계산 가능
//         for (int i=1; i<=14; i++) dp[0][i] = i;  // 호는 1부터 있으니까 이렇게 계산, 1열의 0은 호라고 취급X
//         // System.out.println("dp: "+Arrays.deepToString(dp));
        
//         // 2. dp 점화식 계산
//         for (int i=1; i<=14; i++) {
//             for (int j=1; j<=14; j++) {
//                 dp[i][j] = dp[i][j-1] + dp[i-1][j];
//             }
//         }

//         // 3. 정답 출력
//         while (t-- > 0) {
//             int k = Integer.parseInt(br.readLine());
//             int n = Integer.parseInt(br.readLine());
//             System.out.println(dp[k][n]);
//         }
//     }
// }