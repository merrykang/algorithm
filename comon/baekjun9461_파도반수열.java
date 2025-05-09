// import java.util.*;
// import java.io.*;

// public class Main {
//     public static Long[] p = new Long[101]; // N의 최댓값 100이므로
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();  // 테스트 케이스 수는 적을 것 같지만 조금이라도 메모리 아끼기 위해 사용
//         int t = Integer.parseInt(br.readLine());
//         // p에서 제일 기본값? 초기화 / L은 컴파일러에게 이 숫자가 Long 타입이라고 명확히 명시해주는 것
//         p[0] = 0L;
//         p[1] = 1L;
//         p[2] = 1L;
//         p[3] = 1L;

//         while(t-->0) {
//             sb.append(padovan(Integer.parseInt(br.readLine()))).append('\n');
//         }
//         System.out.print(sb);
//     }
//     public static long padovan(int n) {
//         if (p[n] == null) {  // null 을 체크할 수도 있고, 배열에 비어 있다는 표시를 -1로 정하여 체크해도 됨
//             p[n] = padovan(n-2) + padovan(n-3);  // 배열에 값이 비었을 경우 n-2, n-3 인덱스의 값들을 재귀적으로 호출
//         }
//         return p[n];
//     }
// }