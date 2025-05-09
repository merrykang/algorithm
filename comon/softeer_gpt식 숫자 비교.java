// public class softeer_gpt식 숫자 비교 {
    
// }

/**
 * 코드 최적화
 * 1. 삼항 연산자 빡세게 씀
 * 2. 우선 순위 큐 선언할 때 .으로 체인 걸어서 씀
 */

//  import java.io.*;
// import java.util.*;
// import java.math.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         // 1. 값 입력 받기
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());

//         // 2. 우선순위 큐로 정렬 조건 적용
//         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator
//             .comparingInt((int[] a) -> a[0])
//             .thenComparingInt(a -> a[1]));

//         // 3. numbers 받아오며 큐에 add
//         for (int i=0; i<n; i++) {
//             // 1) String[] 으로 받아 split
//             String[] now = br.readLine().split("\\.");  // . 기준으로 split 하는 것은 이렇게 표현됨을 잊지 말 것
//             // 2) 소수점 뒷 자리가 없는 경우와 있는 경우 front, back 처리
//             int front = Integer.parseInt(now[0]);
//             int back = now.length > 1 ? Integer.parseInt(now[1]) : -1;
//             pq.add(new int[]{front, back});  // int 배열 생성하면서 바로 초기화하는 작업은 이렇게 함을 알아두기
//         }

//         // 3. 정답을 sb에 넣기
//         StringBuilder sb = new StringBuilder();
//         while (!pq.isEmpty()) {
//             // 1) 큐에서 값 꺼냄
//             int[] now = pq.poll();
//             // 2) 소수점 뒷 자리가 없는 경우 바로 sb.append
//             sb.append(now[1] == -1 ? now[0] : String.format("%d.%d", now[0], now[1])).append("\n");
//         }
//         System.out.println(sb);
//     }     
// }
















/**
 * 레퍼런스 보고 우선 순위 큐 사용하여 문풀
 */
// import java.io.*;
// import java.util.*;
// import java.math.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         // 1. 값 입력 받기
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());

//         // 2. 우선순위 큐로 정렬 조건 적용
//         PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
//             @Override
//             public int compare(int[] a, int[] b) {
//                 if (a[0] == b[0]) return a[1] - b[1];  // 소수점 앞자리 같으면 소수점 뒷 자리 오름차순 정렬
//                 else return a[0] - b[0];  // 소수점 앞자리 다르면 앞자리 기준 오름차순 정렬
//             }
//         });

//         // 3. numbers 받아오며 큐에 add
//         for (int i=0; i<n; i++) {
//             // 1) String[] 으로 받아 split
//             String[] now = br.readLine().split("\\.");  // . 기준으로 split 하는 것은 이렇게 표현됨을 잊지 말 것
//             // 2) 소수점 뒷 자리가 없는 경우와 있는 경우 front, back 처리
//             int front, back;  // 한 번에 2가지 값 선언 하는 방법 알아두기
//             if (now.length == 1) {  // 없는 경우
//                 front = Integer.parseInt(now[0]);
//                 back = -1;
//             } else {
//                 front = Integer.parseInt(now[0]);
//                 back = Integer.parseInt(now[1]);
//             }
//             pq.add(new int[]{front, back});  // int 배열 생성하면서 바로 초기화하는 작업은 이렇게 함을 알아두기
//         }

//         // 3. 정답을 sb에 넣기
//         StringBuilder sb = new StringBuilder();
//         while (!pq.isEmpty()) {
//             // 1) 큐에서 값 꺼냄
//             int[] now = pq.poll();
//             // 2) 소수점 뒷 자리가 없는 경우 바로 sb.append
//             if (now[1] == -1) sb.append(now[0]+"\n");
//             // 3) 소수점 뒷 자리가 있는 경우 정수에 "." 을 연결 시켜 추가
//             else sb.append(now[0]+"."+now[1]+"\n");  // sb.append에 줄바꿈 하는 형식 알아두기
//         }
//         System.out.println(sb);
//     }     
// }




/**
 * 내가 혼자 문풀: 우선순위 큐 몰라서 틀림 
 */
// import java.io.*;
// import java.util.*;
// import java.math.*;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         // 1. 값 입력 받기
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         // String[] numbers = new String[n+1];
//         double[] numbers = new double[n+1];
//         for (int i=0; i<n+1; i++) {
//           if(i==n) {
//               numbers[n] = 101.0;  // 최댓값 100으로 주어짐
//               break;
//           }
//           numbers[i] = Double.parseDouble(br.readLine());
//          }
//         // System.out.println(Arrays.toString(numbers));
        
//         // 2. 정렬 및 gpt 식 숫자 비교 로직 수행
//         // 뭔가 계속 오른쪽 옆 자리 숫자와만 비교를 수행하니까 빠진 부분이 있을 것 같은데 이거는 콘솔에 찍어봐야 알 것 같음 
//         StringBuilder sb = new StringBuilder();
//         Arrays.sort(numbers);
//         // Arrays.sort(numbers, Comparator.comparingDouble(Double::parseDouble));
//         // System.out.println("numbers: "+Arrays.toString(numbers));
//         for (int j=0; j<n; j++) {
//           // 예외 처리 : 이미 sb에 numbers[j] 가 있으면 컨티뉴
//           // if (sb.indexOf(numbers[j]) continue;
//           // int[] currentNum = new int[2];
//           // int[] nextNum = new int[2];
//           // System.out.println(numbers[j].split('.'));
//         // }
//           // for (int k=0; k<2; k++) {
              
//               // currentNum[0] = Integer.parseInt(numbers[j].split("."))[0];
//             // System.out.println(numbers[j].split(".")[0]);
//               // nextNum[k] = Integer.parseInt(numbers[j+1].split("."));
//           // }
//             System.out.println("sb: "+sb);
//             if (j == n-1) {
//                 if (sb.indexOf("numbers[j]") != -1) sb.append(numbers[j]).append('\n');
//                 break;
//             }
//             int intPart = (int) numbers[j];
//             int nextIntPart = (int) numbers[j+1];
//             if (intPart != nextIntPart) {
//                 if (sb.indexOf("numbers[j]") != -1) sb.append(numbers[j]).append('\n');
//                 continue;
//             } else {
//                 double decimalPart = Math.pow(numbers[j]-intPart, countDecimalPlaces(numbers[j]-intPart));
//                 double nextDecimalPart = Math.pow(numbers[j+1]-nextIntPart, countDecimalPlaces(numbers[j+1]-nextIntPart));
//                 if (decimalPart > nextDecimalPart) {
//                     // 3.0 같은 애들 형식 바꿔서 append 해줘야 하나? 고민 필요함
//                     sb.append(numbers[j+1]).append('\n');
//                     sb.append(numbers[j]).append('\n');
//                 }
//             }
          
//           // if (currentNum[0] != nextNum[0]) {
//           //   sb.append(numbers[j]); 
//           //   continue;
//           // } else {
//           //   // 소수점 뒤의 자리가 하나의 int로 취급되어야 원하는 대로 비교 가능
//           //   // 그런데 그러면 문자로 받아서 > split(".") > currentNum[0] != nextNum[0] 이면 컨티뉴 > else 이면 currenrNum[1] < nextNum[1] 이면 sb.append(nextNum); 하고 sb.append(currentNum);
//           //   if (currentNum[1] > nextNum[1]) {
//           //     sb.append(numbers[j+1]).append('\n');
//           //     if (sb.indexOf(numbers[j]) != -1) sb.append(numbers[j]).append('\n');
//           //   }
//           // }
//         }
//         System.out.println(sb);
//     }

//     public static int countDecimalPlaces(double num) {
//         BigDecimal bd = new BigDecimal(String.valueOf(num));
//         return bd.scale();
//     }
// }

