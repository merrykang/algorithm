// // public  softeer_yeah, but how? {
    
// // }


// // 세 번째 문풀
// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String[] brackets = br.readLine().split("");
//         StringBuilder sb = new StringBuilder();
//         // 초기값을 공백 문자 + 타입은 char로 설정
//         // 1) equals() 메서드 대신 == 연산을 사용하기 위함
//         char last = ' ';
//         // String last = "";
        
//         // 1. brackets 돌면서 1넣을지 + 넣을지 체크 (핵심 로직)
//         for (String bracket : brackets) {
//             // if 조건 체크 하지 않고 바로 본 조건으로 들어가도 사실 괜찮음
//             // if (!last.equals("")) {
//             // 그러나 bracket은 br.readLine() 으로 받아서 무조건 String, char 될 수 없음
//             if ((last == '(' && bracket.equals(")")) || last==')' && bracket.equals("(")) {
//                 // 삼항 연산자로 조건 간결하게
//                 sb.append(last == '(' ? "1" : "+");
//             }
//             // if (last.equals("(") && bracket.equals(")")) sb.append("1");
//             // else if (last.equals(")") && bracket.equals("(")) sb.append("+");
//             // }
//             // 현재 괄호 정답 문자열에 추가
//             sb.append(bracket);
//             // 직전 괄호 업데이트
//             // bracket이 String이니까 char로 저장하기 위해 charAt 메서드 사용
//             last = bracket.charAt(0);
//         }
        
//         // 2. 정답 출력
//         System.out.println(sb);
//     }
// }



// // 두 번째 문풀
// // import java.io.*;
// // import java.util.*;

// // public class Main {
// //     public static void main(String[] args) throws IOException {
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// //         String[] brackets = br.readLine().split("");
// //         StringBuilder sb = new StringBuilder();
// //         String last = "";
        
// //         // 1. brackets 돌면서 1넣을지 + 넣을지 체크 (핵심 로직)
// //         for (String bracket : brackets) {
// //             if (!last.equals("")) {
// //                 if (last.equals("(") && bracket.equals(")")) sb.append("1");
// //                 else if (last.equals(")") && bracket.equals("(")) sb.append("+");
// //             }
// //                 // sb.append(bracket);
// //             // } else {
// //             //     sb.append(bracket);
// //             // }
// //             // 현재 괄호 정답 문자열에 추가
// //             sb.append(bracket);
// //             // 직전 괄호 업데이트
// //             last = bracket;
// //         }
        
// //         // 2. 정답 출력
// //         System.out.println(sb);
// //     }
// // }



// // 첫 번째 문풀
// // import java.io.*;
// // import java.util.*;

// // public class Main {
// //     public static void main(String[] args) throws IOException {
// //         // 아무거나 출력하는 것이면 그냥 괄호 안에 1 넣기 / 괄호 아니면(닫는 괄호와 여는 괄호 사이이면) + 넣기
// //         // 스택 사용
// //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// //         String[] brackets = br.readLine().split("");
// //         StringBuilder sb = new StringBuilder();
// //         String last = "";
// //         // System.out.println("brackets: " + Arrays.toString(brackets));
        
// //         // 1. brackets 돌면서
// //         for (String bracket : brackets) {
// //             // System.out.println("last: "+last);
// //             // System.out.println("bracket: "+ bracket);
// //             // 2. 핵심 로직
// //             // 정답에 append
// //             // sb.append(bracket);
// //             // 1넣을지 + 넣을지 체크
// //             // Q. last != "" 를 메서드 사용하여 체크하는 방법?
// //             if (!last.equals("")) {
// //                 // System.out.println("여기 들어옴");
// //                 if (last.equals("(") && bracket.equals(")")) sb.append("1");
// //                 else if (last.equals(")") && bracket.equals("(")) sb.append("+");
// //                 sb.append(bracket);
// //             } else {
// //                 sb.append(bracket);
// //             }
// //             // 직전 괄호 업데이트
// //             last = bracket;
// //         }
        
// //         // 3. 정답 출력
// //         System.out.println(sb);
// //     }
// // }

