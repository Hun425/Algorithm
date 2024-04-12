import java.util.*;
import java.io.*;
public class Main {
    static int ans,cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int [][] cdn = new int[N+1][N+1];
        int [][] dt = new int[N+1][N+1];
        int [] DAT = new int[N+1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            cdn[s][e]=1;
        }
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if(cdn[i][j]!=0){
                    dt[i][j]=cdn[i][j];
                }else{
                    dt[i][j]=Integer.MAX_VALUE/2;
                }
            }
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                for (int k = 0; k < N + 1; k++) {
                    dt[j][k] = Math.min(dt[j][k],dt[j][i]+dt[i][k]);
                }
            }
        }
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (dt[i][j] != Integer.MAX_VALUE / 2) {
                    DAT[i]++;
                    DAT[j]++;
                }
            }
        }

        for (int i = 0; i < DAT.length; i++) {
            if(DAT[i]==N-1)ans++;
        }

        System.out.println(ans);

    }


}