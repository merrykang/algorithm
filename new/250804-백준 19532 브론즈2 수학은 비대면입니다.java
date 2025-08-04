import java.util.*;
import java.io.*;

/**
 * - public class는 파일 1개에 1개만 선언되어야 함
 * - 정수인지 판단하는 방법
 * 1. Object + instanceof
 * 2. num % 1 == 0 인지
 * - 처음에 틀렸던 이유: 나누는 수(b)가 0인 경우를 고려하지 않음
 * -> 즉 예외는 1) 나누는 수가 0인 경우 2) 나눈 나머지가 0이 아닌 경우(정수가 아닌 경우)
 * - 두 번째 틀린 이유: 계속 처리해줘야 하는 예외가 늘어나서
 * -> 결국 예외 처리 너무 많이 하려다 보니까 틀림. ex) 나누는 수인 b=0인 경우
 * -> 문제 그대로 구하는게 중요함
 */

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = br.readLine().split(" ");
    int a = Integer.parseInt(arr[0]);
    int b = Integer.parseInt(arr[1]);
    int c = Integer.parseInt(arr[2]);
    int d = Integer.parseInt(arr[3]);
    int e = Integer.parseInt(arr[4]);
    int f = Integer.parseInt(arr[5]);

    for (int x = -999; x <= 999; x++) {
      for (int y = -999; y <= 999; y++) {
        if (a * x + b * y == c && d * x + e * y == f) {
          System.out.println(x + " " + y);
          return;
        }
      }
    }
  }
}