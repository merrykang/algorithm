import java.io.*;
import java.util.*;

// 1차 문풀
// public class Main {
//     public static void main(String[] args) throws IOException {
//         // N묶음의 정수가 생김 <=> 표시되는 수는 1-N
//         // 가로 줄, 세로 줄로 탐색하는 것은 의미가 없으므로 사방을 탐색해야 하는 것 같음
//         // Q. 그러나 사방을 탐색하여 같은 구역을 찾아내는 로직 모르겠음
//         // Q. 입력 값을 배열로 어떻게 받아야 하는지도 모르겠음

//         // Q. 같은 구역과 다른 구역을 구분하는 기준?
//         // Q. 그런데 그러면 항상 가로줄, 세로줄만 출력하면 되는거 아닌가? A. 맞다고 함
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         // int[][] ans = new int[n][n];
//         StringBuilder sb = new StringBuilder();
//         // System.out.print("n: "+n);
//         for (int i=0; i<n; i++) {
//             // 걍 1-6으로 도배
//             for (int j=0; j<n; j++) {
//                 // ans[i][j] = i+1;
//                 // if (j == n-1) sb.append(i+1);
//                 // else sb.append(i+1).append(" ");
//                 sb.append(i+1).append(" ");
//             }
//             sb.append("\n");
//         }
//         // System.out.print(Arrays.deepToString(ans));  // 2차원 배열은 이렇게 출력함을 잊지 말기!
//         System.out.print(sb);
//     }
// }