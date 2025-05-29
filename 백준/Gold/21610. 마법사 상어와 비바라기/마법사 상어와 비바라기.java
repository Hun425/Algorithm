
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 물 좌표
        int[][] map = new int[N+1][N+1];

        // 구름 이동 좌표
        int[][] cdn = new int[M][2];

        // 초기 구름 좌표
        int[][] cloud = {{N,1},{N,2},{N-1,1},{N-1,2}};
        boolean[][] history = new boolean[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cdn[i][0] = Integer.parseInt(st.nextToken());
            cdn[i][1] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        while(count < M) {
            // 구름 이동
            moveCloud(cdn[count][0],cdn[count][1], cloud);

            // 구름 좌표 계산
            caculateCloudCdn(cloud,N);

            // 구름 위치 물내리기
            for(int i = 0; i < cloud.length; i++) {
                map[cloud[i][0]][cloud[i][1]] += 1;
            }

            // 물 추가 존재 여부
            existWater(map,cloud, N);

            // 좌표 기록
            history = createHistory(cloud,N);

            // 구름 생성
            cloud= createCloudCdn(map,history);



            count++;
        }

        int ans = countWater(map);


        System.out.println(ans);
    }

    private static boolean[][] createHistory(int[][] cloud,int N) {
        boolean[][] history = new boolean[N+1][N+1];
        for (int i = 0; i < cloud.length; i++) {
            int y = cloud[i][0];
            int x = cloud[i][1];

            history[y][x] = true;
        }

        return history;
    }

    static void moveCloud(int dir, int dis, int[][] cloud) {

        int[][] direct = new int[][]{{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};

        int count = 0;

        while(count < dis) {

            for(int i = 0; i < cloud.length; i++) {
                cloud[i][0] += direct[dir][0];
                cloud[i][1] += direct[dir][1];
            }

            count++;
        }

    }

    static void caculateCloudCdn(int[][] cloud,int N) {

        for (int i = 0; i < cloud.length; i++) {
            int y = cloud[i][0];
            int x = cloud[i][1];

            if(y<1){
                while(y<1){
                    y += N;
                }
            }
            if(y>N){
                while(y>N){
                    y -= N;
                }
            }
            if(x<1){
                while(x<1){
                    x += N;
                }
            }
            if(x>N){
                while(x>N){
                    x -= N;
                }
            }

            cloud[i][0] = y;
            cloud[i][1] = x;
        }
    }

    static void existWater(int[][] map,int[][]cdn, int N) {
        int[][] dx = new int[][]{{1,1},{-1,1},{1,-1},{-1,-1}};

        for(int i = 0; i < cdn.length; i++) {
            int y = cdn[i][0];
            int x = cdn[i][1];

            for(int j = 0; j < dx.length; j++) {
                int ny = y + dx[j][0];
                int nx = x + dx[j][1];

                if(ny<1 || ny>N || nx<1 || nx>N)continue;

                if(map[ny][nx] > 0) {
                    map[y][x]+=1;
                }
            }
        }
    }

    static int[][] createCloudCdn(int[][] map, boolean[][] history) {

        int count = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(history[i][j])continue;
                if(map[i][j] > 1) {
                    count++;
                }
            }
        }

        int[][] cdn = new int[count][2];

        count = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(history[i][j])continue;
                if(map[i][j] > 1) {

                    cdn[count][0] = i;
                    cdn[count][1] = j;

                    map[i][j]-=2;
                    count++;
                }
            }
        }

        return cdn;
    }

    static int countWater(int[][]map){
        int count = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                count+=map[i][j];
            }
        }
        return count;
    }
}
