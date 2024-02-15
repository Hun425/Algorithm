import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int N,cnt;  // 조건 검사를 위한 배열의 길이
    static void DFS(int y, int x, int rotnum) {

        if (y == N - 1 && x == N - 1) {
            cnt++;
        }
        int[][] dx1 = new int[][]{{0, 1}, {1, 1}};
        int[][] dx2 = new int[][]{{0,1},{1,1},{1,0}};
        int[][] dx3 = new int[][]{{1, 0}, {1, 1}};


            if (rotnum == 1) {  // 가로 방향
                for (int i = 0; i < dx1.length; i++) {
                    int y_del = y+dx1[i][0];
                    int x_del = x+dx1[i][1];

                    if(0>y_del||y_del>= arr.length||0>x_del||arr[0].length<=x_del)continue;
                    if(arr[y_del][x_del]==1)continue;

                    if (i == 1) {
                        if (arr[y_del - 1][x_del] == 1 || arr[y_del][x_del - 1] == 1) { // 대각선 움직일때 4칸을 차지하는 조건
                            continue;

                        }

                        DFS(y_del, x_del, 2);
                    } else {//i==0
                        if(x_del==N-1&&y_del!=N-1)continue;
                        DFS(y_del, x_del, 1);
                    }


                }
            }
            else if (rotnum == 2) { // 대각선
                for (int i = 0; i < dx2.length; i++) {
                    int y_del = y+dx2[i][0];
                    int x_del = x+dx2[i][1];

                    if(0>y_del||y_del>= arr.length||0>x_del||arr[0].length<=x_del)continue;
                    if(arr[y_del][x_del]==1)continue;

                    if (i == 1) {
                        if (arr[y_del - 1][x_del] == 1 || arr[y_del][x_del - 1] == 1) { // 대각선 움직일때 4칸을 차지하는 조건
                            continue;

                        }
                        DFS(y_del, x_del, 2);
                    } else if(i==0) {//i==0
                        if(x_del==N-1&&y_del!=N-1)continue;
                        DFS(y_del, x_del, 1);
                    }
                    else{//i==2
                        DFS(y_del, x_del, 3);
                    }


                }
            }
            else if (rotnum == 3) { // 세로
                for (int i = 0; i < dx3.length; i++) {
                    int y_del = y+dx3[i][0];
                    int x_del = x+dx3[i][1];

                    if(0>y_del||y_del>= arr.length||0>x_del||arr[0].length<=x_del)continue;
                    if(arr[y_del][x_del]==1)continue;

                    if (i == 1) {
                        if (arr[y_del - 1][x_del] == 1 || arr[y_del][x_del - 1] == 1) { // 대각선 움직일때 4칸을 차지하는 조건
                            continue;

                        }
                        DFS(y_del, x_del, 2);
                    } else {//i==0
                        if(x_del!=N-1 && y_del==N-1)continue;
                        DFS(y_del, x_del, 3);
                    }

                }
            }
        }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값 받기

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr =new int[N][N]; // BFS 위한 전역변수 파이프맵

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,1,1);

        System.out.println(cnt);


    }
}

/*
    파이프 끝만 기준으로 BFS 돌리기
 */

