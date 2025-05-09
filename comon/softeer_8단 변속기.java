// // public class softeer_8단 변속기 {
    
// // }

// // 세 번째 문풀
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         // 1. 데이터 입력 받으면서 ascending, descending, mixed 판별
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         // 내가 무의식적으로 boolean 사용하지 않고 cnt 사용하려고 하는 특성 있음! 그러지 말자!
//         boolean isAscending = true; boolean isDescending = true;

//         for (int i=0; i<8; i++) {
//             int num = Integer.parseInt(st.nextToken());
//             if (num != i+1) isAscending = false;
//             // Q. 왜 이게 else if 조건이 들어가면 안 되지?
//             // A. mixed 인 경우 때문
//             // mixed인 경우에는 isAscending = false && isDescending = false임
//             // 그런데 else if 로 조건 체크하면 isAscending = false 인 경우에는 무조건 isDescending = true 되어버림
//             if (num != 8-i) isDescending = false;
//         }
//         System.out.print(isAscending ? "ascending" : isDescending ? "descending" : "mixed");
//         // int[] target = new int[8];
//         // for (int i=0; i<8; i++) target[i] = Integer.parseInt(st.nextToken());

//         // int cnt = 0;
//         // for (int j=0; j<8; j++) {
//         //     if (target[j] == j+1) cnt++;
//         //     else if (target[j] == 8-j) cnt+=2;
//         // }
//         // System.out.print(cnt==8 ? "ascending" : cnt==16 ? "descending" : "mixed");
//     }
// }



// // // 두 번째 문풀
// // import java.io.*;
// // import java.util.*;

// // public class Main {
// //     public static void main(String[] args) throws IOException {
// //         // 1. 데이터 입력 받기
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// //         StringTokenizer st = new StringTokenizer(br.readLine());
// //         int[] target = new int[8];
// //         for (int i=0; i<8; i++) target[i] = Integer.parseInt(st.nextToken());

// //         // 2. 8번 반복하면서 ascending, descending, mixed 판별
// //         int cnt = 0;
// //         for (int j=0; j<8; j++) {
// //             if (target[j] == j+1) cnt++;
// //             else if (target[j] == 8-j) cnt+=2;
// //         }
// //         System.out.print(cnt==8 ? "ascending" : cnt==16 ? "descending" : "mixed");
// //     }
// // }



// // 첫 번째 문풀

// // import java.io.*;
// // import java.util.*;

// // public class Main {
// //     public static void main(String[] args) throws IOException {
// //         // 1. 데이터 입력 받기
// //         // Q. 어떻게 데이터 입력 받아야 가장 효율적으로 받을 수 있는지?
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// //         StringTokenizer st = new StringTokenizer(br.readLine());
// //         int[] target = new int[8];
// //         for (int i=0; i<8; i++) {
// //             target[i] = Integer.parseInt(st.nextToken());
// //         }
// //         // System.out.print("target: "+Arrays.toString(target));

// //         // 2. 8번 반복하면서 ascending, descending, mixed 판별
// //         int ascCnt = 0; int desCnt = 0;
// //         for (int j=0; j<8; j++) {
// //             if (target[j] == j+1) ascCnt++;
// //             else if (target[j] == 8-j) desCnt++;
// //         }
// //         System.out.print(ascCnt==8 ? "ascending" : desCnt==8 ? "descending" : "mixed");
// //     }
// // }
