import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        Integer s = Integer.parseInt(st.nextToken());
        Integer e = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        int[] record = new int[100001];


        for (int i = 0; i < time.length; i++) {
            time[i] = Integer.MAX_VALUE;
        }



        BFS(s,e,e,time,record);

        int idx = e;

        int []ans = new int[time[e]+1];
        int x = 0;
        while(true){
            ans[x++] = idx;
            if(idx==s)break;
            idx = record[idx];
        }
        System.out.println(time[e]);
        for (int i = ans.length-1; i >-1 ; i--) {
            System.out.print(ans[i]+" ");
        }
    }

    static void BFS(int s, int e,int goal, int[] time,int[] record){
        PriorityQueue<Integer[]> que = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        que.add(new Integer[]{s,0});
        time[s] = 0;
        while(!que.isEmpty()){
            Integer[]now = que.poll();
                if(now[0]==goal)break;
                if( now[0]*2<=100000 && now[0]!=0) {
                    if (time[now[0] * 2] > now[1] + 1 ) {
                        time[now[0] * 2] = now[1] + 1;

                        record[now[0] * 2] = now[0];
                        que.add(new Integer[]{now[0] * 2, now[1] + 1});

                    }
                }


                if( now[0]+1<=100000){
                if (time[now[0] + 1] > (now[1] + 1) ) {
                    time[now[0] + 1] = now[1] + 1;

                    record[now[0] + 1] = now[0];
                    que.add(new Integer[]{now[0] + 1, now[1] + 1});

                }

            }

                if(now[0]-1>=0) {
                    if (time[now[0] - 1] > now[1] + 1 ) {
                        time[now[0] - 1] = now[1] + 1;

                        record[now[0] - 1] = now[0];
                        que.add(new Integer[]{now[0] - 1, now[1] + 1});


                    }
                }






        }
    }
}