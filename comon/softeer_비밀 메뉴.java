// public class softeer_비밀 메뉴 {
    
// }
/**
 * 두 번째 문풀
 */
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int m = Integer.parseInt(st.nextToken());  // 비밀 메뉴 길이
//         int n = Integer.parseInt(st.nextToken());  // 전체 입력된 조작 길이
//         int k = Integer.parseInt(st.nextToken());
//         if (n<m) {
//             System.out.println("normal");
//             return;
//         }

//         // 1. 값 입력 받기
//         st = new StringTokenizer(br.readLine());
//         int[] target = new int[m];
//         for (int i=0; i<m; i++) target[i] = Integer.parseInt(st.nextToken());
//         st = new StringTokenizer(br.readLine());
//         int[] arr = new int[n];
//         for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

//         // 2. 슬라이딩 윈도우로 풀이
//         // boolean match = true; > match는 매번 초기화되므로 반복문 내에서만 선언하면 됨
//         // 나는 normal을 출력할 때의 if(!match) 조건 때문에 반복문 외에 match 변수를 선언하였으나
//         // 사실 반복문을 모두 돌고도 secret이 출력되지 않은 경우 normal 이므로 normal 출력하면 됨
//         // 전체 arr 탐색
//         // n=m인 경우 고려하여 인덱스 설정을 i<=n-m으로 하기
//         for (int i=0; i<=n-m; i++) {
//             // matcch = true;
//             boolean match = true;
//             for (int j=0; j<m; j++) {  // target 배열 탐색
//                 // arr은 비교할 배열을 변경하며 비교, target은 정해진 배열을 위치 옮겨 가며 비교
//                 if (arr[i+j] != target[j]) {  // 연속된 수 배열이 1개라도 다르다면
//                     match = false;  // 같지 않다고 표시하고
//                     break;  // 반복문 빠져 나오기
//                 }
//             }
//             if (match) {  // 목표하는 연속된 수 배열 target이 순서와 내용이 같게 arr에 존재한다면
//                 System.out.println("secret");  // 비밀 메뉴라고 표시하고
//                 return;  // 비밀 메뉴라고 출력하면 아예 main 실행 함수 자체를 종료하면 됨
//                 // break;  // 그 후에 비밀 메뉴 또 나오든 안 나오든 체크하지 않겠다
//             }
//         }
//         System.out.println("normal");
//         // if (!match) System.out.println("normal");  // 전체 arr 탐색 종료 시에도 match가 false이면 normal 출력
//     }
// }

/**
 * 첫 번째 문풀
 */
// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int m = Integer.parseInt(st.nextToken());
//         int n = Integer.parseInt(st.nextToken());
//         int k = Integer.parseInt(st.nextToken());
//         if (n<m) {
//             System.out.println("normal");
//             return;
//         }
//         // System.out.println("n:"+n);

//         // 1. 값 입력 받기
//         st = new StringTokenizer(br.readLine());
//         int[] target = new int[m];
//         for (int i=0; i<m; i++) target[i] = Integer.parseInt(st.nextToken());
//         st = new StringTokenizer(br.readLine());
//         int[] arr = new int[n];
//         for (int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
//         // System.out.println(Arrays.toString(menu));
//         // System.out.println(Arrays.toString(operation));
//         // if (n==m) 

//         // 2. 슬라이딩 윈도우로 풀이
//         boolean match = true;
//         for (int i=0; i<=n-m; i++) {
//             match = true;
//             for (int j=0; j<m; j++) {
//                 // System.out.println("arr[i]: "+arr[i]);
//                 // System.out.println("target[j]: "+target[j]);
//                 // System.out.println("arr[i+j]: "+arr[i+j]);
//                 if (arr[i+j] != target[j]) {
//                     match = false;
//                     break;
//                 }
//             }
//             if (match) {
//                 // System.out.println("여기 들어옴");
//                 System.out.println("secret");
//                 break;
//             }
//         }
//         if (!match) System.out.println("normal");

//         // 2. 이중 반복문 돌면서 사용자가 비밀 메뉴 식권을 받을 수 있는지 체크
//         // M, N은 100 이하 이므로 O(N^2) 여도 충분히 구현할 수 있음
//         // int cnt = 0;
//         // int a = 0;
//         // for (int i=0; i<m; i++) {
//         //     for (int j=a; j<n; j++) {
//         //         /**
//         //         Q. 순서를 체크하는 로직이 없어서 틀렸나?
//         //         */
//         //         if (operation[j] == menu[i]) {  // 비밀 메뉴 시작과 동일한 위치 찾으면
//         //             cnt++;
//         //             a = j+1;  // 그 다음 반복문에서 시작해야 할 인덱스 업데이트 
//         //             break;
//         //         }
//         //     }
//         // }
//         // System.out.println(cnt==m ? "secret" : "normal");
//     }
// }













            