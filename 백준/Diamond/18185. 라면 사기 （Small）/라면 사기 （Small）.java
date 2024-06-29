import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 값 처리
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[N + 2]; // 배열 크기 N+2로 설정

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int totalCost = 0;

        while (index < N) {
            if (heights[index] > 0) {
                int currentHeight = heights[index];
                
                // 첫 번째 작업 비용
                totalCost += 3 * currentHeight;

                // 두 번째 작업 비용
                currentHeight = Math.min(currentHeight, heights[index + 1]);
                totalCost += 2 * currentHeight;
                heights[index + 1] -= currentHeight;

                // 세 번째 작업 비용
                currentHeight = Math.min(currentHeight, heights[index + 2] - Math.min(heights[index + 1], heights[index + 2]));
                totalCost += 2 * currentHeight;
                heights[index + 2] -= currentHeight;
            }
            index++;
        }

        System.out.println(totalCost);
    }
}