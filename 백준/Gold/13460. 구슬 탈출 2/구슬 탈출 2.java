import java.util.*;
import java.io.*;

public class Main {

    static char[][] board = new char[11][11];
    static boolean[][][][] visited = new boolean[11][11][11][11];
    static int N, M;
    static int holeY, holeX;
    static Marble red;
    static Marble blue;
    static final int[] dx = {1, 0, -1, 0};  // 이동 방향: 오른쪽, 아래, 왼쪽, 위
    static final int[] dy = {0, 1, 0, -1};  // 이동 방향: 오른쪽, 아래, 왼쪽, 위

    static Marble moveMarble(Marble marble, int dir) {
        int y = marble.y;
        int x = marble.x;

        // 벽에 닿거나 구멍에 빠질 때까지 이동
        while (board[y + dy[dir]][x + dx[dir]] != '#') {
            y += dy[dir];
            x += dx[dir];
            if (y == holeY && x == holeX) break;  // 구멍에 빠지면 멈춤
        }

        return new Marble(y, x);
    }

    static int bfs() {
        visited[blue.y][blue.x][red.y][red.x] = true;
        Queue<MarblePair> queue = new LinkedList<>();
        queue.add(new MarblePair(blue, red, 0));

        while (!queue.isEmpty()) {
            MarblePair marbles = queue.poll();

            // 10번 이하로 움직여서 구슬을 빼낼 수 없으면 실패
            if (marbles.cnt > 10) return -1;

            // 빨간 구슬이 구멍에 빠진 경우
            if (marbles.red.y == holeY && marbles.red.x == holeX) return marbles.cnt;

            for (int i = 0; i < 4; i++) {
                Marble newBlue = moveMarble(marbles.blue, i);
                Marble newRed = moveMarble(marbles.red, i);

                // 파란 구슬이 구멍에 빠지면 실패
                if (newBlue.y == holeY && newBlue.x == holeX) continue;

                // 두 구슬이 같은 위치에 있는 경우 위치 조정
                if (newBlue.y == newRed.y && newBlue.x == newRed.x) {
                    adjustMarblesPosition(marbles, newBlue, newRed, i);
                }

                // 새로운 위치가 방문하지 않은 위치인 경우 큐에 추가
                if (!visited[newBlue.y][newBlue.x][newRed.y][newRed.x]) {
                    visited[newBlue.y][newBlue.x][newRed.y][newRed.x] = true;
                    queue.add(new MarblePair(newBlue, newRed, marbles.cnt + 1));
                }
            }
        }
        return -1;
    }

    static void adjustMarblesPosition(MarblePair marbles, Marble newBlue, Marble newRed, int direction) {
        switch (direction) {
            case 0: // 오른쪽
                if (marbles.blue.x > marbles.red.x) newRed.x--;
                else newBlue.x--;
                break;
            case 1: // 아래쪽
                if (marbles.blue.y > marbles.red.y) newRed.y--;
                else newBlue.y--;
                break;
            case 2: // 왼쪽
                if (marbles.blue.x > marbles.red.x) newBlue.x++;
                else newRed.x++;
                break;
            case 3: // 위쪽
                if (marbles.blue.y > marbles.red.y) newBlue.y++;
                else newRed.y++;
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 보드 설정 및 구슬 위치 초기화
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'B') blue = new Marble(i, j);
                else if (board[i][j] == 'R') red = new Marble(i, j);
                else if (board[i][j] == 'O') {
                    holeY = i;
                    holeX = j;
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }
}

class Marble {
    int y, x;

    public Marble(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class MarblePair {
    Marble blue, red;
    int cnt;

    public MarblePair(Marble blue, Marble red, int cnt) {
        this.blue = blue;
        this.red = red;
        this.cnt = cnt;
    }
}