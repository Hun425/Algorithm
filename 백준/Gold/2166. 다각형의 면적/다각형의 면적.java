import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 점의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 좌표를 저장할 long 타입 배열
        // int로 하면 좌표 곱셈 시 오버플로우 발생 가능
        long[] x = new long[N];
        long[] y = new long[N];

        // N개의 점 좌표 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        // 신발끈 공식을 위한 두 개의 합 변수 (long 타입)
        long sum1 = 0; // x_i * y_{i+1} 의 합
        long sum2 = 0; // y_i * x_{i+1} 의 합

        // 신발끈 공식 계산
        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N; // 다음 점의 인덱스 (마지막 점은 첫 번째 점과 연결)
            sum1 += x[i] * y[next];
            sum2 += y[i] * x[next];
        }

        // 면적 계산: |sum1 - sum2| / 2.0
        // 2.0으로 나누어 double 타입으로 결과를 얻음
        double area = Math.abs(sum1 - sum2) / 2.0;

        // 소수점 첫째 자리까지 형식에 맞춰 출력
        System.out.printf("%.1f\n", area);
    }
}