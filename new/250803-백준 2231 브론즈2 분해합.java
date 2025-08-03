import java.util.*;
import java.io.*;

// 아이디어 생각
// String.valueOf()
// constructro.get(0)
// 예외 처리
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n + 1];
    for (int i = 1; i < arr.length; i++)
      arr[i] = i;

    // n의 생성자 리스트 구하기
    // 현재 숫자의 각 자리 수의 합을 구해야 하므로 String으로 변환하여 각 자리를 split
    List<Integer> constructor = new ArrayList<>();
    for (int i = 1; i < arr.length; i++) {
      int sum = i;
      String numToString = String.valueOf(arr[i]);
      String[] strArr = numToString.split("");
      for (int j = 0; j < strArr.length; j++)
        sum += Integer.parseInt(strArr[j]);
      if (sum == n)
        constructor.add(i);
    }

    // 정답 출력
    // 가장 작은 값을 출력하기 위해 정렬 후 첫 번째 원소 출력
    // 예외 처리 하지 않으면 indexOutOfBounds 에러 출력됨
    Collections.sort(constructor);
    System.out.println(constructor.size() > 0 ? constructor.get(0) : 0);
  }
}