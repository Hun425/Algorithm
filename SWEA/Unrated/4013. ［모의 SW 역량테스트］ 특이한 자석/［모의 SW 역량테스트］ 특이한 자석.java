import java.io.*;
import java.util.*;

public class Solution {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void find(int[][]arr,int num, int rt) {
        int temp = rt;

        Queue<Integer[]> cdn = new LinkedList<>();
        int start= num;
        while (num-1 >= 0) {
            if (arr[num - 1][2] != arr[num][6]) {
                if (rt == -1) {

                    rt = 1;
                } else {
                    rt = -1;
                }
                cdn.add(new Integer[]{num-1,rt});

            } else {
                break;
            }
            num--;
        }
        num=start;
        rt = temp;
        while (num + 1 < 4) {
            if (arr[num + 1][6] != arr[num][2]) {
                if (rt == -1) {

                    rt = 1;
                } else {
                    rt = -1;
                }
                cdn.add(new Integer[]{num+1,rt});

            } else {
                break;
            }
            num++;
        }

        while (!cdn.isEmpty()) {
            Integer []now = cdn.poll();
            rot(arr,now[0],now[1]);
        }
    }
    static void rot(int[][] arr,int num, int rt) {
        if (rt == 1) {
            int temp = arr[num][arr[0].length - 1];

            for (int i = arr[0].length - 1; i > 0; i--) {
                arr[num][i] = arr[num][i - 1];
            }
            arr[num][0] = temp;
        } else {
            int temp = arr[num][0];

            for (int i = 0; i < arr[0].length-1; i++) {
                arr[num][i]=arr[num][i+1];
            }
            arr[num][arr[0].length-1]=temp;
        }
    }
    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            // 입력값 받기
            int N = Integer.parseInt(br.readLine());
            int [][] arr = new int[4][8];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken())-1;
                int rt = Integer.parseInt(st.nextToken());
                find(arr,num,rt);
                rot(arr,num,rt);
            }

            int ans =0;
            for (int i = 0; i < 4; i++) {
                if(i==0 && arr[i][0]==1)ans+=1;
                if(i==1 && arr[i][0]==1)ans+=2;
                if(i==2 && arr[i][0]==1)ans+=4;
                if(i==3 && arr[i][0]==1)ans+=8;
            }

            System.out.println("#"+(t+1)+" "+ans);
        }

    }
}
/*
첫 좌표를 입력받고 회전 할 좌표와 방향을 먼저 계산하기
 */