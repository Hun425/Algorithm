import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int time;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean check;




    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String [][] arr = new String[R][C];
        int[][] timetable = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            for (int j = 0; j < C; j++) {
                arr[i][j] = String.valueOf(n.charAt(j));
                if (arr[i][j].equals("O")) {
                    timetable[i][j]+=3;
                }
            }
        }
//        for (int[] ints : timetable) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }
        time =1;
        check =false;
        // 이동좌표
        int[][] dx = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        // 시간 변화에 따른 맵 변화
        while (time < N ) {
            time++;
            if (check) {
                break;
            }

            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        int current_time = time;
                        if (arr[i][j].equals(".")) {
                            timetable[i][j]=current_time+3;
                        }
                        arr[i][j]="O";
                    }
                }

            }

            else {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (timetable[i][j] == time) {
                            arr[i][j] = ".";
                            for (int k = 0; k < 4; k++) {
                                int y = i + dx[k][0];
                                int x = j + dx[k][1];

                                // 폭탄 연쇄 반응 금지 조건 추가
                                if (0 <= y && y < R && 0 <= x && x < C && !arr[y][x].equals(".")) {
                                    arr[y][x] = ".";
                                }
                            }
                        }
                    }
                }


            }

        }

        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }
}