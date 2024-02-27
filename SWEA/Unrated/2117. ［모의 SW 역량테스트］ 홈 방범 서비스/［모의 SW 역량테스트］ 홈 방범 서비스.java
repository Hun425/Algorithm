import java.io.*;
import java.util.*;
public class Solution {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] arr;
    static boolean[][] visited;
    static int N,K,sum,count,result;
    static void AddCdn(int y, int x,int ct) {
        Queue<Integer[]> que = new ArrayDeque<>();
        int cnt=0;
        int[][] dx = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        count=0;
        visited[y][x]=true;
        que.add(new Integer[]{y,x,0});
        if (arr[y][x] == 1) {
            sum+=K;
            count++;
        }
        boolean check =false;
        while (!que.isEmpty()) {
            Integer[] now = que.poll();
            y = now[0];
            x = now[1];
            cnt = now[2];

            if (now[2] == ct) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int del_y = y+dx[i][0];
                int del_x = x+dx[i][1];

                if(del_y<0 || del_y>=N || del_x<0 || del_x>=N)continue;
                if(visited[del_y][del_x])continue;

                que.add(new Integer[]{del_y,del_x,now[2]+1});
                visited[del_y][del_x]=true;
                if (now[2] + 1 == ct) {
                    check = true;
                    break;
                }
                if (arr[del_y][del_x] == 1) {
                    sum+=K;
                    count++;
                }
            }
            if(check)break;
        }




    }


    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            int cnt=0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j]==1)cnt++;
                }
            }

            // 필요 변수 생성

            int ans =-100;
            int k =1;
            int k_reuslt = k*k+(k-1)*(k-1);
            result=0;
            while (cnt * K - k_reuslt > 0) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        sum=0;
                        visited =new boolean[N][N];
                        AddCdn(i,j,k);
                        if(sum-k_reuslt<0)continue;
                        result = Math.max(count,result);
                    }
                }
                k++;
                k_reuslt = k*k+(k-1)*(k-1);

            }



            System.out.println("#"+(t+1)+" "+result);

        }

    }
}
/*

 */