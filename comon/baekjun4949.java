import java.io.*;
import java.util.*;

/**
 * 주석: 두 번째 정답 맞은 풀이
 */
public class baekjun4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> bracketSet = Set.of("(", "[", "]", ")");
            
        while(true) {
            List<String> brackets = new ArrayList<>();
            String[] str = br.readLine().split("");
            // 종료 조건: . 이면 종료
            if (str[0].equals(".")) break; 
            // 괄호 짝 맞추기
            for (String s : str) {
                if (!bracketSet.contains(s)) continue;  // 괄호가 아니면 건너뛰기
                if (!brackets.isEmpty()) {
                    String last = brackets.get(brackets.size() -1);
                    if ((s.equals(")") && last.equals("(")) || (s.equals("]") && last.equals("["))) {
                        brackets.remove(brackets.size()-1);
                        continue;
                    }
                }
                brackets.add(s);
            }
            // for (int i=0; i<str.length; i++) {
            //     int bSize = brackets.size();
            //     if (bSize!=0 && str[i].equals(")") && brackets.get(bSize - 1).equals("(")) {
            //         brackets.remove(bSize-1);
            //     } else if (bSize!=0 && str[i].equals("]") && brackets.get(bSize - 1).equals("[")) {
            //         brackets.remove(bSize-1);
            //     } else if (str[i].equals("(") || str[i].equals("[") || str[i].equals(")") || str[i].equals("]")) {
            //         brackets.add(str[i]);
            //     }
            // }
            // 균형 맞는지 판별
            System.out.println(brackets.isEmpty() ? "yes" : "no");
            // if (brackets.size() == 0) System.out.println("yes");
            // else System.out.println("no");
        }
    }
}

/**
 * 맨 처음 정답 맞은 풀이
 */

//  public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         while(true) {
//             // String[] brackets = new String[100];  // 최대 100자 만큼 > but 배열은 크기가 고정되니까 ArrayList를 사용하여 크기 정의 없이 자유롭게 추가했다 빼기
//             // Q. ArrayList에서 자주 사용되는 메서드?
//             List<String> brackets = new ArrayList<>();
//             // brackets.add(" ");
//             String[] str = br.readLine().split("");  // 공백 포함하여 한 글자씩 나누기; 만약 공백 기준으로 나눌 것이었다면 split(" ") 하면 됨
//             // System.out.println("str: "+Arrays.toString(str));
//             if (str[0].equals(".")) break;  // Q. 계속 반복되는 이유?  A. 문자열 비교를 == 연산자로 수행했기 때문! equals 항상 기억할 것
//             for (int i=0; i<str.length; i++) {
//                 // System.out.println("str[i]: "+str[i]);
//                 // Q. 짝 맞는 괄호가 brackets 내에 있으면 배열 내에 괄호 지우기 + continue (remove): contains()
//                 // int lastIndex = 0;
//                 int bSize = brackets.size();
//                 if (bSize == 0 && (str[i].equals(")") || str[i].equals("]") || str[i].equals("(") || str[i].equals("["))) {
//                     brackets.add(str[i]);
//                 } else if (str[i].equals(")")) {
//                 // if (str[i].equals(")")) {
//                     // Q. 짝 있으면 remove
//                     if (brackets.get(bSize - 1).equals("(")) {
//                         // Q. 어떻게 하나만 삭제하지
//                         // lastIndex = brackets.lastIndexOf("(");
//                         // // System.out.print("lastIndex: "+lastIndex);
//                         // if (lastIndex != -1) brackets.remove(lastIndex);
//                         brackets.remove(bSize-1);
//                     } else {
//                         brackets.add(str[i]);
//                     }
//                     // 짝 없으면 put
//                 } else if (str[i].equals("]")) {
//                     if (brackets.get(bSize - 1).equals("[")) {
//                         // 어떻게 하나만 삭제하지
//                         // lastIndex = brackets.lastIndexOf("[");
//                         // if (lastIndex != -1) brackets.remove(lastIndex);
//                         brackets.remove(bSize-1);
//                     } else {
//                         brackets.add(str[i]);
//                     }
//                 } else if (str[i].equals("(") || str[i].equals("[")) {
//                     // Q. 짝 맞는 괄호 없으면 brackets에 넣기 (put)
//                     // Q. 괄호만 추출해서 put 하는 방법?
//                     brackets.add(str[i]);
//                 }
//                 // System.out.println("brackets: "+(brackets));
//             }
//             if (brackets.size() == 0) {
//                 System.out.println("yes");
//             } else {
//                 System.out.println("no");
//             }
//         }
//     }
// }

