// /**
//  * 두번째 문풀
//  */
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         // Q. Scanner 로 받을 수 있는데도 BufferedReader로 받으면 효율성 면에서 안 좋을까?
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int k = Integer.parseInt(st.nextToken());
//         int p = Integer.parseInt(st.nextToken());
//         int n = Integer.parseInt(st.nextToken());

//         // n초당 p배씩 증가하는 바이러스 수 구하기
//         long ans = k;  // ans(바이러스 수)를 처음 바이러스 수로 초기화; k, p, n의 범위를 고려할 때 최대 바이러스 수가 21억을 초과할 수 있으므로 long 타입 선언
//         // n의 최댓값이 10의 6제곱으로 한 번에 ans를 구할 수 없어 n번 반복
//         while (n-->0) ans = (ans*p)%1000000007;  // 각 반복마다 1000000007의 나머지를 구하여 메모리 절약
//         System.out.println(ans);
//     }
// }

// /*
//  * 첫번째 문풀
//  */
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         // Q. Scanner 로 받을 수 있는데도 BufferedReader로 받으면 효율성 면에서 안 좋을까?
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int k = Integer.parseInt(st.nextToken());
//         int p = Integer.parseInt(st.nextToken());
//         int n = Integer.parseInt(st.nextToken());

//         long ans = k;
//         while (n-->0) {
//             ans *= p%1000000007;
//         }
//         System.out.println(ans);
//     }
// }
