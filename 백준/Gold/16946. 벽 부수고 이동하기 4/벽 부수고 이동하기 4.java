import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr, result, visited;
    static int[] groupSize;
    static int groupId = 2;  // 그룹 ID는 2부터 시작 (0과 1은 이미 사용 중)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        result = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> groupSizes = new ArrayList<>();

        // BFS로 각 그룹의 크기 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && visited[i][j] == 0) {
                    int size = bfs(i, j, groupId);
                    groupSizes.add(size);
                    groupId++;
                }
            }
        }

        groupSize = new int[groupId];
        for (int i = 0; i < groupSizes.size(); i++) {
            groupSize[i + 2] = groupSizes.get(i);  // 그룹 ID는 2부터 시작
        }

        // 벽 주변의 값 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    result[i][j] = calculateSum(i, j);
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int bfs(int y, int x, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = id;
        int size = 0;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            size++;

            for (int[] dir : directions) {
                int newY = current[0] + dir[0];
                int newX = current[1] + dir[1];

                if (newY >= 0 && newY < N && newX >= 0 && newX < M && arr[newY][newX] == 0 && visited[newY][newX] == 0) {
                    queue.add(new int[]{newY, newX});
                    visited[newY][newX] = id;
                }
            }
        }
        return size;
    }

    static int calculateSum(int y, int x) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Integer> uniqueGroups = new HashSet<>();

        for (int[] dir : directions) {
            int newY = y + dir[0];
            int newX = x + dir[1];

            if (newY >= 0 && newY < N && newX >= 0 && newX < M && arr[newY][newX] == 0) {
                uniqueGroups.add(visited[newY][newX]);
            }
        }

        int sum = 1;
        for (int group : uniqueGroups) {
            sum += groupSize[group];
        }
        return sum;
    }
}