// import java.io.*;
// import java.util.*;

/**
 * 카잉 달력 문제
 * - 현재 (x, y) 값을 반복적으로 증가시키면서 (X, Y)를 찾는 방식
 * - 핵심 아이디어
    > x값을 기준으로 주기를 m으로 반복하므로, x를 기준으로만 순회
    > x 값을 고정하고(O), year를 m으로만 늘리면서(O), y가 n과 같은지만 확인(X)
    > 그러나 y도 순회하므로 단순히 n과 같은지 확인하면 안 되고 (year-y)%n = 0 이어야 함 > 이 식은 수치 전개되는 것 보면 알 수 있음
   - 개선된 알고리즘
    > x를 기준으로 x + m*k 꼴의 값을 순회하면서, 해당 값이 (x, y) 조건을 만족하는지 확인
    > 이때 y == n이 아니라, **(year - y) % n == 0**을 체크
   - 시간 초과 해결 방법
 */
// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine());
//         while(t-->0) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int m = Integer.parseInt(st.nextToken());
//             int n = Integer.parseInt(st.nextToken());
//             int x = Integer.parseInt(st.nextToken());
//             int y = Integer.parseInt(st.nextToken());
//             int year = x;  // m 주기로 업데이트할 것이므로 초기값을 x로 설정
//             boolean found = false;  // 정답 찾았는지 여부; 찾지 못 한 경우 -1 출력해야 하므로 필요
//             int max = lcm(m,n);  // 시간 초과 나지 않도록 반복할 최댓값인 m, n의 최소 공배수 구하기
//             while (year<=max) {
//                 if ((year - y)%n ==0) {
//                     System.out.println(year);
//                     found = true;
//                     break;
//                 }
//                 year += m;
//             }
//             if (!found) System.out.println(-1);

//         }
//     }
//     // 최대공약수
//     public static int gcd(int a, int b) {
//         if (b==0) return a;
//         return gcd(b, a%b);
//     }
//     // 최소공배수
//     public static int lcm(int a, int b) {
//         return a*b / gcd(a, b);
//     }
// }
// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine());
//         while(t-->0) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int m = Integer.parseInt(st.nextToken());
//             int n = Integer.parseInt(st.nextToken());
//             int x = Integer.parseInt(st.nextToken());
//             int y = Integer.parseInt(st.nextToken());
//             int ans = 1; int currentX = 1; int currentY = 1;  // 올림 메서드를 쓰기 위해 int가 아닌 double 선언

//             while (currentX != m || currentY !=n) {
//                 if(currentX==x && currentY==y) {
//                     System.out.println(ans); break;
//                 } 
//                 // if (currentX==m && currentY==n) {
//                 //     System.out.println(-1); break;
//                 // }
//                 currentX= currentX < m ? currentX+1 : 1;
//                 currentY = currentY < n ? currentY+1 : 1;
//                 ans++;
//             }
//             if (currentX==m || currentY==n) System.out.println(-1);
//         }
//     }
// }

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine());
//         while(t-->0) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int m = Integer.parseInt(st.nextToken());
//             int n = Integer.parseInt(st.nextToken());
//             double x = Integer.parseInt(st.nextToken());  // 올림 메서드를 쓰기 위해 int가 아닌 double 선언
//             double y = Integer.parseInt(st.nextToken());
//             double ans; double currentX; double currentY;  // 올림 메서드를 쓰기 위해 int가 아닌 double 선언

//             if(m>n) {  // 첫 번째 조건문과 두 번째 조건문 모듈화
//                 System.out.println("m>n 들어옴");
//                 currentX = m; currentY = Math.ceil(y/(m-n));
//                 ans = m*(m-n)*currentY;
//                 while (currentY<=y) {
//                     if(currentX==x && currentY==y) {
//                         System.out.println(ans); return;
//                     }
//                     currentY++;
//                     currentX = currentX < m ? currentX+1 : 1;
//                     ans++;
//                 }
//             } else if(m<n) {
//                 System.out.println("m<n 들어옴");
//                 currentY = n; currentX = Math.ceil(x/(n-m));
//                 System.out.println("currentY: "+currentY);
//                 System.out.println("currentX: "+currentX);
//                 System.out.println("x/(n-m): "+x/(n-m));
//                 ans = n*(currentX/(n-m));  // 초기값을 큰 값(n)이 초기화되는 x, y와 가장 가까운 시점으로 설정
//                 System.out.println("ans: "+ans);
//                 while (currentX != x) {
//                     System.out.println("currentX<=x 들어옴");
//                     System.out.println("currentY 2: "+currentY);
//                     System.out.println("currentX 2: "+currentX);
//                     if(currentX==x && currentY==y) {
//                         System.out.println(ans); return;
//                     }
//                     currentX= currentX < m ? currentX+1 : 1;
//                     currentY = currentY < n ? currentY+1 : 1;
//                     ans++;
//                 }
//             } else if (m==n) {
//                 System.out.println(m);
//                 return;            
//             }
//             System.out.println(-1);
//         }
//     }
// }