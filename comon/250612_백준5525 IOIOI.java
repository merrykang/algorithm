import java.io.*;
import java.util.*;

/**
 * 개선 사항
 *  1. substring, equals, += 메서드 -> charAt() 메서드로 대체하여 곧바로 문자열 s 에서 추출
 *  2. cnt 를 사용하여 n의 개념이 IOI 패턴의 개수라는 정의를 이용하여 아이디어 내기: 결국 cnt == n 인 지점을 찾는 것임
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        // cnt: iOI 패턴이 만족된 횟수, 결국 cnt가 n과 같아지는 지점을 찾는 것임
        // n이 'IOI 패턴이 나타난 횟수' 라는 정의에서 아이디어 시작
        int ans = 0; int i=1; int cnt = 0;

        // charAt(i) : 문자열에서 해당 인덱스의 문자를 반환
        // if 문의 인덱스를 아래처럼 설정한 이유: if (s.charAt(i) == 'I' && s.charAt(i+1) == 'O' && s.charAt(i + 2) == 'I')와 같은 방식은 i가 문자열 끝에 가까운 위치일 때 IndexOutOfBoundsException이 발생할 수 있기 때문에, 보통 중간 인덱스를 기준으로 두는 방식이 더 안전하게 사용됩니다.
        while (i < m-1) {
            if(s.charAt(i-1) == 'I' && s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
                cnt++;
                if (cnt == n) {  // 패턴 IOI 1개 만족
                    ans++;
                    cnt--;  // IOIOI 같은 경우가 다음 순서에 또 나타날 가능성을 대비하여 cnt에 여유 두기
                }
                i+=2;
            } else {
                cnt = 0;
                i++;
            }
        }

        System.out.println(ans);
    }
}

/**
 * 아래 코드: 부분 성공 (50점)
 * 실패 이유
 *  1. String은 불변 객체. 따라서 substring 메서드와 += 메서드를 사용하는 것은 매번 새로운 문자열 객체를 생성함.
 *     따라서 이게 반복문 안에서 수천~수백만 번 반복되면 시간 초과가 당연히 발생
 *  2.  current.equals(target) 도 문자열 객체 전체를 비교하므로 문자열 길이가 k 일 때 시간 복잡도가 O(k)
 */
// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         int m = Integer.parseInt(br.readLine());
//         String[] s = br.readLine().split("");
//         int ans = 0;

//         // 찾아야 하는 목표 글자 만들기
//         String target = "I";
//         for (int i = 0; i < n; i++) target += "OI"; 
//         int targetLen = target.length();

//         // 예외: target 길이 > m 이면 return ans
//         if (targetLen > m) {
//             System.out.println(ans);
//             return;
//         }

//         // 목표 글자 길이만큼 s의 왼쪽부터 글자 저장
//         String current = "";
//         for (int i = 0; i < targetLen; i++) current += s[i];

//         // 슬라이딩 윈도우
//         // s의 길이(m) 만큼 돌면서 현재 탐색하려는 글자 조정하고, 동일하면 ans에 1개 추가
//         for (int i = 0; i < m; i++) {
//             if (current.equals(target)) ans++;
//             if (i == m-targetLen) break;
//             current = current.substring(1);  // i+1 인덱스부터 문자열의 끝까지만 남김 ( = 맨 첫 번째 문자열 제거)
//             current += s[i+targetLen];  // s에서 탐색할 다음 문자열을 current 에 추가
//         }
//         System.out.println(ans);
//     }
// }


