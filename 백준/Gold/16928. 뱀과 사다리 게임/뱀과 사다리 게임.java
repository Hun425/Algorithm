import java.util.*;
import java.io.*;
public class Main {
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cdn = new int[101][1];
        int[][] min = new int[101][1];
        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            cdn[s][0] = e;
        }

        for (int i = 0; i < 101; i++) {
         min[i][0] = Integer.MAX_VALUE;
        }
        ans = Integer.MAX_VALUE;
        BFS(0,min,cdn);
        System.out.println(min[100][0]);
    }
    static void BFS(int s,int[][]min,int[][]cdn) {
        Queue<Integer[]>que = new ArrayDeque<>();

        que.add(new Integer[]{1,0});

        while (!que.isEmpty()) {
            Integer[] now = que.poll();
            int value = now[1]+1;
            for (int i = 1; i < 7; i++) {
                int del = now[0]+i;
                if(del>100)del=100;
                if(cdn[del][0]!=0)del = cdn[del][0];
                if (min[del][0] > value) {
                    que.add(new Integer[]{del,value});
                    min[del][0] = value;
                }

            }
        }

    }
}
