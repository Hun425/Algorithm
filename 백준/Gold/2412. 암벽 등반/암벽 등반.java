import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
    
    // 이분 탐색을 위한 Point 객체 비교기
    static Comparator<Point> comparator = (p1, p2) -> {
        if (p1.x == p2.x) return p1.y - p2.y;
        return p1.x - p2.x;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 시작점을 포함하여 리스트 생성
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0)); // 시작점 (0,0) 추가
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        // x, y 순으로 정렬 (핵심 최적화)
        points.sort(comparator);
        
        // BFS를 위한 큐와 방문 배열
        // 큐에는 {point의 index, 이동 횟수}를 저장
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[points.size()];

        queue.add(new int[]{0, 0}); // 시작점(index 0)을 큐에 추가
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentIndex = current[0];
            int currentCount = current[1];
            Point currentPoint = points.get(currentIndex);

            if (currentPoint.y >= T) {
                System.out.println(currentCount);
                return;
            }

            // 이분 탐색으로 탐색 시작점 찾기
            // x가 currentPoint.x - 2 이상인 첫 지점을 찾는다.
            int start = findLowerBound(points, currentPoint.x - 2);

            // 좁혀진 범위 내에서만 탐색
            for (int i = start; i < points.size(); i++) {
                Point nextPoint = points.get(i);

                // x좌표가 범위를 벗어나면 탐색 종료
                if (nextPoint.x > currentPoint.x + 2) {
                    break;
                }
                
                // y좌표가 범위를 벗어나거나 이미 방문했으면 건너뜀
                if (Math.abs(nextPoint.y - currentPoint.y) > 2 || visited[i]) {
                    continue;
                }
                
                visited[i] = true;
                queue.add(new int[]{i, currentCount + 1});
            }
        }
        
        System.out.println(-1);
    }
    
    // 이분 탐색으로 targetX 이상의 x값을 갖는 첫 번째 인덱스를 찾는 함수
    private static int findLowerBound(List<Point> points, int targetX) {
        int left = 0, right = points.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if(points.get(mid).x >= targetX) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}