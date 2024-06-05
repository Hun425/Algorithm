import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] card = new int[N / 2][2];

        for (int i = 0; i < N / 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (PlayGame(card, N)) {
            System.out.println("WIN");
        } else {
            System.out.println("LOSE");
        }
    }

    static Boolean PlayGame(int[][] card, int N) {
        PriorityQueue<int[]> state = new PriorityQueue<>((o1, o2) -> o2[4] - o1[4]);
        Set<String> visited = new HashSet<>();

        int[] playing = {0, 0, 101, 101, 0};
        state.add(playing);
        visited.add(Arrays.toString(playing));

        while (!state.isEmpty()) {
            int[] now = state.poll();
            int idx = now[4];
            if (now[4] == N) return true;
            int[] v = card[idx / 2];

            processState(now, v, state, visited);
            int temp = v[0];
            v[0] = v[1];
            v[1] = temp;
            processState(now, v, state, visited);
        }

        return false;
    }

    private static void processState(int[] now, int[] v, PriorityQueue<int[]> state, Set<String> visited) {
        for (int i = 0; i < 4; i++) {
            if ((i < 2 && (now[i] < v[0] || now[i] - 10 == v[0])) || (i >= 2 && (now[i] > v[0] || now[i] + 10 == v[0]))) {
                int[] next = now.clone();
                next[i] = v[0];
                next[4]++;
                addState(next, v, state, visited);
            }
        }
    }

    private static void addState(int[] next, int[] v, PriorityQueue<int[]> state, Set<String> visited) {
        for (int j = 0; j < 4; j++) {
            if ((j < 2 && (next[j] < v[1] || next[j] - 10 == v[1])) || (j >= 2 && (next[j] > v[1] || next[j] + 10 == v[1]))) {
                int[] result = next.clone();
                result[j] = v[1];
                result[4]++;
                if (!visited.contains(Arrays.toString(result))) {
                    state.add(result);
                    visited.add(Arrays.toString(result));
                }
            }
        }
    }
}