import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0], new ArrayList<>());

        bw.write(max + "\n");
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int currentResult, List<Integer> expression) {
        if (depth == N) {
            int result = calculateExpression(expression);
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                List<Integer> newExpression = new ArrayList<>(expression);
                newExpression.add(i);
                newExpression.add(numbers[depth]);
                dfs(depth + 1, currentResult, newExpression);
                operators[i]++;
            }
        }
    }

    static int calculateExpression(List<Integer> expression) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> operators = new ArrayList<>();

        numbers.add(Main.numbers[0]);
        for (int i = 0; i < expression.size(); i += 2) {
            operators.add(expression.get(i));
            numbers.add(Main.numbers[i/2 + 1]);
        }

        //곱셉이랑 나눗셈 먼저 하기
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == 2 || operators.get(i) == 3) {
                int left = numbers.get(i);
                int right = numbers.get(i + 1);
                int result = (operators.get(i) == 2) ? left * right : left / right;
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            }
        }


        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == 0) {
                result += numbers.get(i + 1);
            } else {
                result -= numbers.get(i + 1);
            }
        }

        return result;
    }
}