import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        // P1 -> P2 벡터와 P2 -> P3 벡터의 외적 계산
        int crossProduct = (x[1] - x[0]) * (y[2] - y[0]) - (y[1] - y[0]) * (x[2] - x[0]);

        // 외적의 값으로 방향 판별
        if (crossProduct > 0) {
            System.out.println("1"); // 반시계 방향
        } else if (crossProduct < 0) {
            System.out.println("-1"); // 시계 방향
        } else {
            System.out.println("0"); // 일직선
        }
        
        br.close();
    }
}