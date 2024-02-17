import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] base;
    static int[][] path;
    static boolean []visited;
    static int out,score,maxscore,btorder;
    static void playball(int a,int[]base) {

        if(a==0){
            out++;
        } else if (a == 1) {
            if (base[2] == 1)score++;
            for (int i = 2; i > 0; i--) {
                base[i]=base[i-1];
            }
            base[0]=1;
        } else if (a == 2) {
            if(base[2]==1)score++;
            if(base[1]==1)score++;
            base[2]=base[0];
            base[1]=1;
            base[0]=0;
        } else if (a==3) {
            for (int i = 0; i < 3; i++) {
                if(base[i]==1)score++;
                base[i]=0;
            }
            base[2]=1;
        } else if (a == 4) {
            for (int i = 0; i < 3; i++) {
                if(base[i]==1)score++;
                base[i]=0;
            }
            score++;
        }
    }

    static void Ining(int level,int[][]arr,int ining) {
        if (level == 3) {
            level=4;
        }
        if (level == 9) {
            int cntining=0;
            for (int i = 0; i < path.length; i++) {

                while (cntining <ining) {
                    if (btorder == 9) {
                        btorder=0;
                    }
                    playball(path[cntining][btorder],base);
                    btorder++;
                    if (out == 3) {
                        cntining++;
                        base=new int[3];
                        out=0;
                    }
                }
            }
            btorder=0;
            maxscore=Math.max(score,maxscore);
            out=0;
            score=0;
            base=new int[3];
            return;
        }

        for (int i = 0; i < 9; i++) {
            if(visited[i])continue;
            visited[i]=true;
            for (int j = 0; j < ining; j++) {

                path[j][level]=arr[j][i];
            }
            Ining(level+1,arr,ining);
            visited[i]=false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값 받기
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr= new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[9];
        base = new int[3];
        path =new int[N][9];
        for (int i = 0; i < N; i++) {
            int temp=arr[i][0];
            arr[i][0]=arr[i][3];
            arr[i][3]=temp;
            path[i][3]=arr[i][3];
        }


        visited[3]=true;
        Ining(0,arr,N);
        System.out.println(maxscore);
    }
}
/*
    1. 메서드화 시키기
    2. 전역변수 남발하지 않기
    3. 변수명 알기쉽게하기
    4. 주석 잘 달기
    5. **설계 꼼꼼하게 하기**
 */

